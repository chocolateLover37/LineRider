import java.awt.Color;

public class PointCustom {

	private Color color = Color.black; //Couleur du point
	private int size = 10; //Taille
	private int x = -10; //Position sur l'axe X : initialis� au dehors du conteneur
	private int y = -10; //Position sur l'axe Y : initialis� au dehors du conteneur

	
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
	public void setColor(Color color) {
		this.color = color;
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
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
