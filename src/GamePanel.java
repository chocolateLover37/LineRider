import java.awt.*;

import javax.swing.*;

import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class GamePanel extends JPanel{
	
	public Color pointerColor = Color.red; //couleur du pointeur
	public int posX = -10, oldX = -10;  //position X du pointeur
	public int posY = -10, oldY = -10; //position Y du pointeur
	public boolean erasing = true; //savoir si on dessine ou pas
	public int pointerSize = 10; //taille du pointeur
	public String lineType = "point"; //type de trait, impossible de le changer en cliquant sur les boutons, bizzare...
	public ArrayList<PointCustom> points = new ArrayList<PointCustom>();  
	public ArrayList<Ligne> lignes = new ArrayList<Ligne>();
	public PointCustom pointStart = new PointCustom(-10,-10,10,pointerColor);
	public PointCustom pointEnd = new PointCustom(-10,-10,10,pointerColor);
	
	public GamePanel(){
		setPreferredSize(new Dimension(900,450));
		this.setBackground(Color.white);
		setVisible(true);
		
		if(this.lineType=="point"){//l'attribut lineType reste fixe, donc on est toujours dans ce cas
			
			this.addMouseListener(new MouseAdapter(){
			      public void mousePressed(MouseEvent e){
			    	  points.add(new PointCustom(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor));
			    	  repaint();
			      }
			});
			
			this.addMouseMotionListener(new MouseMotionListener(){
			      public void mouseDragged(MouseEvent e) {
			    	  //On récupère les coordonnées de la souris et on enlève la moitié de la taille du pointeur pour centrer le tracé
			    	  points.add(new PointCustom(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor));
			    	  repaint();
			      }
			      public void mouseMoved(MouseEvent e) {}
			});
		}
		
		//désolé ca ne marche pas encore pour les traits
		/*if(this.lineType=="trait"){//on n'entre jamais dans ce cas pour l'instant, mais le dessin des lignes droites ne fonctionne pas du tout
	        this.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                	pointStart = new PointCustom(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor);
                	System.out.println("1");
                }

                public void mouseReleased(MouseEvent e) {
                	pointEnd = new PointCustom(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor);
                	lignes.add(new Ligne(pointStart,pointEnd));
                    System.out.println("2");
                }
            });
            this.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                }
                public void mouseMoved(MouseEvent e) {
                }
            });        
		}*/
	}
	
	public void paintComponent(Graphics g) {

	    g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());

	    //Si on doit effacer, on ne passe pas dans le else => pas de dessin
	    if(this.erasing){
	    	this.erasing = false;
	    }
	    else{
	    	
	    	//On parcourt notre collection de points
	    	for(PointCustom p : this.points){//ecriture chelou pour les arraylists
	    		//On recupere la couleur
	    		g.setColor(p.getColor());
	    		g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
	    	}
	    	
	    	//On essaye de parcourir notre collection de lignes, sans grand succès
	    	for(int k=0;k<lignes.size();k++){//on parcourt chaque Ligne de la ArrayList lignes
	    		System.out.println("je parcours la liste de Ligne");//ca ne s'affiche jamais
	    		//On recupere la couleur
	    		for(int i=0;i<lignes.get(k).tab.length;i++){//on parcourt chaque PointCustom de la Ligne 
	    			g.setColor(lignes.get(k).getColor());
    				g.fillOval(lignes.get(k).tab[i].getX(), lignes.get(k).tab[i].getY(), lignes.get(k).tab[i].getSize(), lignes.get(k).tab[i].getSize());
    			}
	    	}
	    } 
	} 
	
	//Efface le contenu
	public void erase(){
		this.erasing = true;
	    this.points = new ArrayList<PointCustom>();
	    this.lignes = new ArrayList<Ligne>();
	    repaint();
	}

	//Definit la couleur du pointeur
	public void setPointerColor(Color c){
	    this.pointerColor = c;
	}
	
	//Definit le type de trait
	public void setLineType(String type){
		this.lineType = type;
	}
	
}	
		
		

