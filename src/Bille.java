import java.awt.Rectangle;

public class Bille extends Objet {
   
    public double masse;
    
    public Bille(Rectangle aframe){
    	//dy=0 au debut, dx=cste (m*g) ;
        super((aframe.width/2),aframe.height,0,0,10,aframe,"BilleRouge.png");
        //masse=1;
    }
    
    /*public Rectangle[] GetCollisionBoxes (){
		Rectangle[] pipi = new Rectangle[5];
		for (int i=0; i<5; i++){
			pipi[i] = new Rectangle((int) (x-(i+1)*h/5), (int) (y + h*(-i+5)/5),(int) (h*(i+1)*(2/5)),(int) (h*(5-i)*(2/5)));
		}
		return pipi;
	}*/
    
    public void move(long t){
    	x=x+(int)(vitesse*dx);
		y=y+(int)(vitesse*dy);
		
		if (x<limitesframe.x){ //pour ne pas sortir du cadre
			x= limitesframe.x;
		}
	    else if (x+l>limitesframe.x+limitesframe.width){
	    	x=limitesframe.x+limitesframe.width-l;
	    }
		
		if (y<limitesframe.y){
			y= limitesframe.y;
		}
	    else if (y+h>limitesframe.y+limitesframe.height){
	    	 y=limitesframe.y+limitesframe.height-h;
	    }
		
		limites.setLocation(x,y);
    	
		
		
    	/*double g=9.81;
        double a=1; //provisoire
        double ecmax=10; //provisoire
        //recupere pente de la courbe et boolean: 
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
            
            
        	// cas sans rebond
        	if((Math.pow(dx,2)+Math.pow(dy,2))<10){
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
            
            
            // cas rebond
            
            else{
            double teta=((Math.PI)/2)-p;
            dx=dx*Math.cos(teta)+dy*Math.sin(teta);
            dy=-dy*Math.sin(teta)+dy*Math.cos(teta);
            x=x+dx*t ;
            y=y+(-0.5)*g*Math.pow(t,2)+dy*t;    
            }  
           
        }
        
        //limites.setLocation((int)(x),(int)(y)); erreur compilation
      	*/
        
    
    }
}
