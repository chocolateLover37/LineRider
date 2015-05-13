import java.awt.Rectangle;

public abstract class Bille extends Objet {
   

    
    public Bille(int ax,int ay,double vx,double vy, Rectangle aframe,String NomImage){
    	//dy=0 au debut, dx=cste (m*g) ;
        super(ax,ay,vx,vy,NomImage);
    }
}
