import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Depart {
	public double x,y;
	public Image image;
	
	public Depart(double ax, double ay, String NomImage){
		x=ax;
		y=ay;
		try {
	        image= ImageIO.read(new File(NomImage));
	    }
	    catch(Exception err) {
	        System.out.println(NomImage+" introuvable !");
	        System.out.println("Mettre les images dans le repertoire :"+getClass().getClassLoader().getResource(NomImage));
	        System.exit(0);
	    }	
	}
	
	public void setXY(double ax, double ay){
		x=ax;
		y=ay;
	}
}
