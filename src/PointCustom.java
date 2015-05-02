import java.awt.Color;

public class PointCustom {

	private Color color = Color.black; //Couleur du point
	private int x = -10; //Position sur l'axe X : initialisé au dehors du conteneur
	private int y = -10; //Position sur l'axe Y : initialisé au dehors du conteneur

	public PointCustom(int x, int y, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
	public PointCustom(){
		this.x=-10;
		this.y=-10;
		this.color = Color.black;
	}

	//ACCESSEURS
	public Color getColor() {
		return color;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int ax){
		x=ax;
	}
	public void setY(int ay){
		y=ay;
	}
	public void setXY(int ax, int ay){
		x=ax;
		y=ay;
	}
}
