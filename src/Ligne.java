import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Ligne{
	public Color color = Color.black;
	public int size;
	public PointCustom pointA = new PointCustom(-10,-10,size,color);
	public PointCustom pointB = new PointCustom(-10,-10,size,color);
	
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
	/*public void convertLine2D(){
		Line2D l = new Line2D();
		l.setLine(pointA.getX(),pointA.getY(),pointB.getX(),pointB.getY());
	}    travaux en cours....
	*/
}
