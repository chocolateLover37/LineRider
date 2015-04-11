import java.awt.*;

import javax.swing.*;

import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class GamePanel extends JPanel{
	
	public Color pointerColor = Color.red; //couleur du pointeur
	public String pointerType = "CIRCLE"; //forme du pointeur
	public int posX = -10, oldX = -10;  //position X du pointeur
	public int posY = -10, oldY = -10; //position Y du pointeur
	public boolean erasing = true; //savoir si on dessine ou pas
	public int pointerSize = 15; //taille du pointeur
	private ArrayList<Point> points = new ArrayList<Point>();  
	
	public GamePanel(){
		setPreferredSize(new Dimension(900,450));
		this.setBackground(Color.white);
		setVisible(true);
		
		this.addMouseListener(new MouseAdapter(){
		      public void mousePressed(MouseEvent e){
		    	  points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
		    	  repaint();
		      }
		});
		
		this.addMouseMotionListener(new MouseMotionListener(){
		      public void mouseDragged(MouseEvent e) {
		    	  //On récupère les coordonnées de la souris et on enlève la moitié de la taille du pointeur pour centrer le tracé
		    	  points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
		    	  repaint();
		      }
		      public void mouseMoved(MouseEvent e) {}
		});
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
	    	for(Point p : this.points){
	    		//On récupère la couleur
	    		g.setColor(p.getColor());

	    		//Selon le type de point
	    		if(p.getType().equals("SQUARE")){
	    			g.fillRect(p.getX(), p.getY(), p.getSize(), p.getSize());
	    		}
	    		else{
	    			g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
	    		}
	    	}
	    } 
	} 
	
	//Efface le contenu
	public void erase(){
		this.erasing = true;
	    this.points = new ArrayList<Point>();
	    repaint();
	}

	//Définit la couleur du pointeur
	public void setPointerColor(Color c){
	    this.pointerColor = c;
	}

	//Définit la forme du pointeur
	public void setPointerType(String str){
		this.pointerType = str;
	}
	
}	
		
		

