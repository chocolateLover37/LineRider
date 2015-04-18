import java.awt.Rectangle;

public abstract class Bille extends Objet {
   
    public double masse;
    
    
    public Bille(double ax,double ay,double vx,double vy, Rectangle aframe,String NomImage){
       //* dy=0 au debut, dx=cste (m*g) 
         super(ax,ay,vx,vy,aframe,NomImage);
         masse=1;
    }
    
    
    public void move(double pente) {
        // cas contact  if (Collision==true)
        
        
        
        //cas sans contact 
        
        
        
        
    }
    
    
    
    
}