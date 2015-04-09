public class Bille extends Objet {
   
    public double ec;
    public double masse;
    
    
    public Bille(double ax,double ay,double dx){
       //* dy=0 au dbut, dx=cste (m*g) 
         super(ax,ay,dx,0);
         ec=0;
         masse=10;
    }
    
    
    public void move(double pente) {
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