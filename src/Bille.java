

public class Bille extends Objet {
    double pente;
    double ec;
    double masse;
    
    public Bille(double ax,double ay,double dx){
       //* dy=0 au début, dx=cste (m*g) 
         super(ax,ay,dx,0);
         pente=0;
         ec=0;
         masse=10;
         
    }
    
    public  void acceleration() {
        dy=dy-(pente*10);
   
    }
    public void move(){
    	
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
        
        
        
    

