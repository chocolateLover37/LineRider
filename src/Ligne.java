import java.awt.Color;

public class Ligne{
	public Color color = Color.black;
	public PointCustom pointA = new PointCustom(-10,-10,color);
	public PointCustom pointB = new PointCustom(-10,-10,color);
	
	public Ligne(PointCustom pointStart, PointCustom pointEnd, Color couleur){
		pointA = pointStart;
		pointB = pointEnd;
		color=couleur;
	}
	
	public Ligne(){
		pointA = new PointCustom();
		pointB = new PointCustom();
		color=Color.black;
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
	
	public double distance(int cX, int cY){
		int aX=pointA.getX();
		int aY=pointA.getY();
		int bX=pointB.getX();
		int bY=pointB.getY();
		
		double L = Math.sqrt(Math.pow(bX-aX,2)+Math.pow(bY-aY,2));
		double r=((cX-aX)*(bX-aX)+(cY-aY)*(bY-aY))/(Math.pow(L,2));
		double s=((aY-cY)*(bX-aX)-(aX-cX)*(bY-aY))/(Math.pow(L,2));
		if((r>=0)&&(r<=1)){
			return (double)Math.abs(s)*L;
		}
		if((r<0)&&(r>1)){
			double a=Math.sqrt(Math.pow(cX-aX,2)+Math.pow(cY-aY,2));
			double b=Math.sqrt(Math.pow(cX-bX,2)+Math.pow(cY-bY,2));
			return Math.min(a,b);
		}
		return 1000;
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
