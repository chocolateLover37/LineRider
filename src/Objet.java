
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;


import javax.imageio.ImageIO;

public abstract class Objet {
    public double h;
    public double x,y;
    public double dx,dy; // vitesse
    public boolean collision;
    public Image image;
    
    
    
    public Objet(double ax,double ay,double adx,double ady,String NomImage){
    	x=ax;
        y=ay;
        dx=adx;
        dy=ady;
      
    
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
	    
	    // definie les limites de l'objet pour les collisions et les sorties
	    //limites = GetCollisionBoxes();
	    
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
  
    //recupere les rectangles qui definissent la bille pour les collisions (plus utile)
    //public abstract Rectangle[] GetCollisionBoxes();
    
  
    public void move(long t, ArrayList<Ligne> Listdeligne){
    	double g=9.81;
        double a=1; //provisoire
        double ecmax=10; //provisoire
        
        double xt = x; // enregistrement coordonnées actuelles
        double yt = y;
      
        //  calcule la prochaine position de l'objet en chute libre
        x=x+dx*t ;
        y=y+(-0.5)*g*Math.pow(t,2)+dy*t;
        dy=-g*t+dy;
        
        // check la collision à ce point et recupere pente de la courbe et boolean: 
        ReturnCollision k= collision(Listdeligne);
        Ligne l = k.getLigne();
        double p= pente(l);
        boolean collision=k.getBol();
        
         // cas 1 : pas de contact avec une courbe pour le prochain point
        if (collision==false){
        	//on laisse comme ça
        }
        //cas 2: collision avec une courbe pour le prochain point
         
        else{ 
            //on repart aux coordonnées précedentes et on change la direction de déplacement
        	x = xt;
        	y = yt;
            
        	// cas 2 : sans rebond
        	if((Math.pow(dx,2)+Math.pow(dy,2))<ecmax){
            //produit scalaire entre la vitesse et le vecteur unitaire de la pente
            double ps = dx*Math.cos(p)+dy*Math.sin(p);
            //On dirige la vitesse ainsi obtenue selon la pente
            dx= ps*Math.cos(p);
            dy = ps*Math.sin(p);
            //Calcul de la position du prochain point
            x=x+(-0.5)*g*t*2*Math.sin(p)+ dx*t;
            y=y+0.5*g*Math.pow(t,2)*(Math.cos(p)-1)+dy*t;
            //Calcul de la vitesse suivante
            dx=-g*t*Math.sin(p) + dx;
            dy=g*t*(Math.cos(p) -1)+ dy;
            }
            
            
            // cas 3 : rebond
            
            else{
            double coeff = 0.8; // facteur d'amortissement
            dx = coeff*(Math.cos(p)*dx*Math.cos(p)+dy*Math.sin(p) - Math.sin(p)*dx*Math.sin(p)-dy*Math.cos(p));
            dy = coeff*(Math.sin(p)*dx*Math.cos(p)+dy*Math.sin(p) + Math.cos(p)*dx*Math.sin(p)-dy*Math.cos(p));
            x=x+dx*t ;
            y=y+(-0.5)*g*Math.pow(t,2)+dy*t;
            }  
           
        }
        
        //limites.setLocation((int)(x),(int)(y)); erreur compilation
      
        
    }
	public double pente(Ligne babaorum){//méthode pour avoir la pente d'une ligne
		double pente = (babaorum.pointB.getY()-babaorum.pointA.getY())/(babaorum.pointB.getX()-babaorum.pointA.getX());
		return pente;
	}
}
