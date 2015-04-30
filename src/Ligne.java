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
