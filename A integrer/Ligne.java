import java.awt.*;
import java.awt.geom.Line2D;

public class Ligne{
	public Color color = Color.black;
	public int size = 5;
	public PointCustom pointA = new PointCustom(-10,-10,size,color);
	public PointCustom pointB = new PointCustom(-10,-10,size,color);
	public int nbPoints=1000;//oui c'est beaucoup, il faudrait ajuster nbPoints en fonction de la longueur du trait (Pythagore tavu)
	public PointCustom[] tab = new PointCustom[nbPoints];
	
	public Ligne(PointCustom pointStart, PointCustom pointEnd,Color couleur){
		pointA = pointStart;
		pointB = pointEnd;
		color=couleur;
		int dX = pointB.getX()-pointA.getX();
		int dY = pointB.getY()-pointA.getY();

		for(int i=0;i<tab.length;i++){
			tab[i]= new PointCustom(pointA.getX()+i*dX/nbPoints,pointA.getY()+i*dY/nbPoints,size,color);
		}
	}

	public double pente(){//ca servira probablement pour l'animation
		double pente = (pointB.getY()-pointA.getY())/(pointB.getX()-pointA.getX());
		return pente;
	}
	
	public Line2D.Double GetLineforCollision(){
		Line2D.Double chaussette = new Line2D.Double(pointA.getX(),pointA.getY(),pointB.getX(),pointB.getY());
		return chaussette; 
	}
	
	//ACCESSEURS
	public Color getColor() {
		return color;
	}
}
