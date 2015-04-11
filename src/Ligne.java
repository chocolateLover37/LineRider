import java.awt.Point;

public class Ligne {//cette classe est pour l'instant inutile
	
	Point pointA;
	Point pointB;
	
	public Ligne(Point apointA, Point apointB){
		pointA = apointA;
		pointB = apointB;
	}
	
	
	public double pente(){
		double pente = (pointB.y-pointA.y)/(pointB.x-pointA.x);
		return pente;
	}
	
}
