import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Depart {
	public double x,y;
	public Image image;
	
	public Depart(double ax, double ay){
		x=ax;
		y=ay;
		try {
	        image= ImageIO.read(new File("dpt.png"));
	    }
	    catch(Exception err) {
	        System.out.println("dpt.png est introuvable !");
	        System.out.println("Mettre l'image dans le repertoire");
	        System.exit(0);
	    }	
	}
	
	public void setXY(double ax, double ay){
		x=ax;
		y=ay;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
}
