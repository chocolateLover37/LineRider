import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class GamePanel extends JPanel{
	
	public Color pointerColor = Color.red; //couleur du pointeur
	public boolean erasing = true; //savoir si on dessine ou pas
	public int pointerSize = 10; //taille du pointeur
	public String lineType = "point"; //type de trait
	public ArrayList<PointCustom> points = new ArrayList<PointCustom>();  
	public ArrayList<Ligne> lignes = new ArrayList<Ligne>();
	
	public GamePanel(){
		setPreferredSize(new Dimension(1200,600));
		this.setBackground(Color.white);
		setVisible(true);
		this.addMouseListener(new GestionOutils());
		this.addMouseMotionListener(new GestionOutils());
	}
	
	public class GestionOutils implements MouseListener, MouseMotionListener{
		PointCustom pointStart = new PointCustom(-10,-10, pointerSize, pointerColor);
		PointCustom pointEnd = new PointCustom(-10,-10, pointerSize, pointerColor);
		
		public void mousePressed(MouseEvent e){
			if(lineType.equals("point")){
				points.add(new PointCustom(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor));
				repaint();
			}
			
			if(lineType.equals("trait")){
				pointStart = new PointCustom(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor);
			}	
	    }
			
		public void mouseDragged(MouseEvent e) {
			if(lineType.equals("point")){
				//On rŽcupre les coordonnŽes de la souris et on enlve la moitiŽ de la taille du pointeur pour centrer le tracŽ
				points.add(new PointCustom(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor));
				repaint();
			}
			if(lineType.equals("trait")){
			}
		}
		public void mouseReleased(MouseEvent e) {
			if(lineType.equals("trait")){
				pointEnd = new PointCustom(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor);
				lignes.add(new Ligne(pointStart,pointEnd,pointerColor));
	        	repaint();
			}
		}	
		public void mouseMoved(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		
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
	    	
	    	for(int k=0;k<lignes.size();k++){//on parcourt chaque Ligne de la ArrayList lignes
	    		//On recupere la couleur
	    		g.setColor(lignes.get(k).getColor());
	    		for(int i=0;i<lignes.get(k).tab.length;i++){//on parcourt chaque PointCustom de la Ligne 
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
		
		

