
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Objet {
    public int h,l,x,y;
    public double dx,dy,vitesse;
    public boolean collision;
    public Image image;
    public Rectangle limites,limitesframe;
    
    
    public Objet(int ax, int ay, double adx, double ady, Rectangle aframe, String NomImage){
    	x=ax;
        y=ay;
        dx=adx;
        dy=ady;
        limitesframe=aframe;
      
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
	    limites = new Rectangle(ax,ay,l,h);
	    
    }
    
    // affiche image
    public void draw (long t, Graphics g) {
    g.drawImage(image,x,y,null);
    }
    
    public boolean Collision(Objet O){
		return limites.intersects(O.limites);
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
  
    //recupere les rectangles qui definissent la bille pour les collisions (plus utile)
    //public abstract Rectangle[] GetCollisionBoxes();
    
  
    public abstract void move(ArrayList<Ligne> Listdeligne, long time);
    
	/*public double pente(Ligne babaorum){//ca servira probablement pour l'animation
		double pente = (babaorum.pointB.getY()-babaorum.pointA.getY())/(babaorum.pointB.getX()-babaorum.pointA.getX());
		return pente;
	}*/
}
