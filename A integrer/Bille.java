public class Bille extends Objet {
   
    public double ec;
    public double masse;
    public double rayon;
    
    
    public Bille(double ax,double ay){
       //* dx et dy ne sont pas constants!!  
         super(ax,ay,0,0);
         ec=0;
         masse=10;
    }
    
    public Rectangle[] GetCollisionBoxes (){
    	Rectangle[] pipi = new Rectangle[5];
    	for (int i=0; i<5; i++){
    		Rectangle[i] = new Rectangle((int) (x-(i+1)*rayon/5), (int) (y + rayon*(-i+5)/5),(int) (rayon*(i+1)*(2/5)),(int) (rayon*(5-i)*(2/5)));
    	}
    }
    
    
    public void move(double pente, boolean col) {
        dy=dy-(pente*10);
    }
    
    
    public boolean energieCinetique(){
    	ec=(1/2)*masse*Math.pow(dx+dy,(1/2)); 
    	if(ec>100){
    		return false; 
    	}
    	else{
    		return true;
    	}
    }
    
}