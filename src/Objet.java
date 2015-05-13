
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Objet {
	public double h,l;
    public double x,y;
    public double dx,dy;
    public boolean actif;
    public boolean collision;
    public Image image;
    public Rectangle [] limites;
    public Rectangle limitesframe;
    
    
    public Objet(double ax,double ay,double adx,double ady,Rectangle aframe,String NomImage){
    	x=ax;
        y=ay;
        dx=adx;
        dy=ady;
        actif=true;
        limitesframe=aframe;
      
    
	    //lire l'image de l'objet designee par son nom en controlant
	    // les exceptions provoquees par les erreurs de chargement
	    try {
	        image= ImageIO.read(new File(NomImage));
	    }
	    catch(Exception err) {
	        System.out.println(NomImage+" introuvable !");
	        System.out.println("Mettre les images dans le repertoire :"
	        +getClass().getClassLoader().getResource(NomImage));
	        System.exit(0);
	    }
	    
	    // recupere une fois pour toute la hauteur et largeur de l'image
	    h= image.getHeight(null);
	    l= image.getWidth(null);
	    
	    // definie les limites de l'objet pour les collisions et les sorties
	    limites = GetCollisionBoxes();
	    }
	    
	    // affiche image
	    public void draw (long t, Graphics g) {
	    g.drawImage(image,(int)x,(int)y,null);
    }
    
    
    public ReturnCollision collision (ArrayList<Ligne> lili){
	        
	        boolean col = false;
	        double bcourbe;
	        java.util.Iterator<Ligne> iterator = lili.iterator();
	        //check of collisions with other objects
	        while (iterator.hasNext()) {
	        	Ligne i = iterator.next();
	        	bcourbe = i.distance((int) x,(int) y);
	        	if (bcourbe<=5){
	        		col = true;
	        		ReturnCollision choc = new ReturnCollision(i,col);
	        		return choc;}
	        }
	        
	        ReturnCollision choc = new ReturnCollision(null, col);
			return choc;
	}
  
    //recupere les rectangles qui definissent la bille pour les collisions
    public abstract Rectangle[] GetCollisionBoxes();
    
    // en construction
    public void move(long t, ArrayList<Ligne> Listdeligne){
    	double g=9.81;
        double a=1; //provisoire
        // recupere pente de la courbe et boolean: 
        ReturnCollision k= collision(Listdeligne);
        Ligne l = k.getLigne();
        double p= pente(l);
        boolean collision=k.getBol();
      
        
        
    	//  recalcule la nouvelle position de l'objet 
        
        // cas 1 : pas de contact avec une courbe 
        if (collision==false){
        x=x+dx*t ;
        y=y+(-0.5)*g*Math.pow(t,2)+dy*t;
        dy=-g*t+dy;


        }
        
        //cas 2: contact avec une courbe
         
        else{
            x=x+(-0.5)*g*t*2*Math.sin(a)+ dx*t;
            y=y+0.5*g*Math.pow(t,2)*(Math.cos(a)-1)+dy*t;  
            dx=-g*t*Math.sin(a) + dx; 
            dy=g*t*(Math.cos(a) -1)+ dy;
        }
    }
	public double pente(Ligne babaorum){//ca servira probablement pour l'animation
		double pente = (babaorum.pointB.getY()-babaorum.pointA.getY())/(babaorum.pointB.getX()-babaorum.pointA.getX());
		return pente;
	}
}
