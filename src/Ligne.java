import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Ligne{
	public Color color = Color.black;
	public PointCustom pointA = new PointCustom(-10,-10,color);
	public PointCustom pointB = new PointCustom(-10,-10,color);
	
	public Ligne(PointCustom pointStart, PointCustom pointEnd, Color couleur){
		pointA = pointStart;
		pointB = pointEnd;
		color=couleur;
	}
	
	public double pente(){//ca servira probablement pour l'animation
		double pente = (pointB.getY()-pointA.getY())/(pointB.getX()-pointA.getX());
		return pente;
	}
	
	public double taille(){
		double dX=(pointB.getX()-pointA.getX());
		double dY=(pointB.getY()-pointA.getY());
		double taille = Math.sqrt(Math.pow(dX,2)+Math.pow(dY,2));
		return taille;
	}
	
	
	//ACCESSEURS
	public Color getColor() {
		return color;
	}
	public PointCustom getPointA(){
		return pointA;
	}
	public PointCustom getPointB(){
		return pointB;
	}
}
