import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;

import javax.imageio.ImageIO;


public abstract class Objet {
    public int h,l;//pas accepte par le constructeur de rectangle si double, probleme ? 
    public int x,y;
    public double dx,dy;
    public boolean actif;
    public Image image;
    public Rectangle limites;
    public Rectangle limitesframe;
    
    public Objet(int ax,int ay,double adx,double ady,Rectangle aframe,String NomImage) {
    	x=ax;
        y=ay;
        dx=adx;
        dy=ady;
        actif=true;
        limitesframe=aframe;
    
    
    //lire l'image de l'objet désigné par son nom en contrôlant
    // les exceptions provoqués par les erreurs de chargement
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
    
    // definir les limites de l'objet pour les collisions et les sorties
    limites = new Rectangle(ax,ay,l,h);
    
    }
    
    // affiche image
    public void draw (long t, Graphics g) {
    g.drawImage(image,x,y,null);
    }
    
    
    public boolean Collision(Ligne O){
    return limites.intersects(O.limites);
    }
    
    public abstract void move(); 
    
}