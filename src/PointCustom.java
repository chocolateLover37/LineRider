import java.awt.Color;
import java.awt.geom.Point2D;

public class PointCustom {

	private Color color = Color.black; //Couleur du point
	private int size = 5; //Taille
	private int x = -10; //Position sur l'axe X : initialis� au dehors du conteneur
	private int y = -10; //Position sur l'axe Y : initialis� au dehors du conteneur
	private Point2D point;
	
	public PointCustom(){} // Constructeur par d�faut

	public PointCustom(int x, int y, int size, Color color){
		this.size = size;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	//ACCESSEURS
	public Color getColor() {
		return color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
