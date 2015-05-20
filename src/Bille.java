import java.awt.Rectangle;
import java.util.ArrayList;

public class Bille extends Objet {
   
    public Bille(int x, int y, double dx, double dy, Rectangle aframe){
    	//dy=0 au debut, dx=cste (m*g) ;
        super(x, y,dx,dy,aframe,"BilleRouge");
        //masse=1;
        
    }
    
    
    public void move(ArrayList<Ligne> Listdeligne, long t){
    	double dt = 0.04;
    	
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
    	
		
		
    	double g=9.81;
        double a=1; //provisoire
        double ecmax=10; //provisoire
        double xt = x; // enregistrement coordonn�es actuelles
        double yt = y;
      
        //  calcule la prochaine position de l'objet en chute libre
        x=(int) (x+dx*dt) ;
        y=(int) (y+(-0.5)*g*Math.pow(dt,2)+dy*dt);
        dy=-g*dt+dy;
        
        // check la collision � ce point et recupere pente de la courbe et boolean: 
        //recupere pente de la courbe et boolean: 
        ReturnCollision k= collision(Listdeligne);
        Ligne l = k.getLigne();
        double p= l.pente();
        boolean collision=k.getBol();
      	
        
        
    	//  recalcule la nouvelle position de l'objet 
        
        // cas 1 : pas de contact avec une courbe 
        if (collision==false){
         
        x=(int) (x+ dx*dt) ;
        y=(int) (y+(-0.5)*g*Math.pow(dt,2)+dy*dt);
        dy=-g*dt+dy;


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
            x=(int) (x+(-0.5)*g*dt*2*Math.sin(p)+ dx*dt);
            y=(int) (y+0.5*g*Math.pow(dt,2)*(Math.cos(p)-1)+dy*dt);
            //Calcul de la vitesse suivante
            dx=-g*dt*Math.sin(p) + dx;
            dy=g*dt*(Math.cos(p) -1)+ dy;
            }
            
            
            // cas rebond
            
            else{
            double coeff = 0.8; // facteur d'amortissement
            dx = coeff*(Math.cos(p)*dx*Math.cos(p)+dy*Math.sin(p) - Math.sin(p)*dx*Math.sin(p)-dy*Math.cos(p));
            dy = coeff*(Math.sin(p)*dx*Math.cos(p)+dy*Math.sin(p) + Math.cos(p)*dx*Math.sin(p)-dy*Math.cos(p));
            x=(int) (x+dx*dt) ;
            y=(int) (y+(-0.5)*g*Math.pow(dt,2)+dy*dt);   
            }
        	} 
           
        }
        
        
        
    
    }
