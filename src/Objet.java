import java.awt.Image;
import java.awt.Rectangle;


public abstract class Objet {
    public double x;
    public double y;
    public double dx;
    public double dy;
    public boolean actif;
    public Image image;
    public Rectangle limites;
    
    
    public Objet(double ax,double ay,double adx,double ady) {
        x=ax;
        y=ay;
        dx=adx;
        dy=ady;
        actif=true;

    }
    
    public abstract void move(double pente); 
}