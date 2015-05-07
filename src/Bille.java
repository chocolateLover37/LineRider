import java.awt.Rectangle;

public abstract class Bille extends Objet {
   
    public double masse;
    
    public Bille(int ax,int ay,double vx,double vy, Rectangle aframe,String NomImage){
    	//dy=0 au debut, dx=cste (m*g) ;
        super(ax,ay,vx,vy,aframe,NomImage);
        masse=1;
    }
    public Rectangle[] GetCollisionBoxes (){
    	
    	Rectangle[] pipi = new Rectangle[5];
    	for (int i=0; i<5; i++){
    		pipi[i] = new Rectangle((int) (x-(i+1)*h/5), (int) (y + rayon*(-i+5)/5),(int) (rayon*(i+1)*(2/5)),(int) (rayon*(5-i)*(2/5)));
    	}
    	return pipi;
    }
    public void move(double pente) {
    	// cas contact  if (Collision==true)
        
        //cas sans contact 
            
    }   
}
