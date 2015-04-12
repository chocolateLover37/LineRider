import java.awt.Color;

public class Ligne{
	public Color color = Color.black;
	public int size = 10;
	public PointCustom pointA = new PointCustom(-10,-10,size,color);
	public PointCustom pointB = new PointCustom(-10,-10,size,color);
	public PointCustom[] tab = new PointCustom[100];
	
	public Ligne(PointCustom pointStart, PointCustom pointEnd){
		pointA = pointStart;
		pointB = pointEnd;
		int dX = pointB.getX()-pointA.getX();
		int dY = pointB.getY()-pointA.getY();

		for(int i=0;i<tab.length;i++){
			tab[i]= new PointCustom(pointA.getX()+i*dX/100,pointA.getX()+i*dY/100,size,color);
		}
	}
	
	
	public double pente(){
		double pente = (pointB.getY()-pointA.getY())/(pointB.getX()-pointA.getX());
		return pente;
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

		public void setPointA(int ax, int ay) {
			this.pointA.setX(ax);
			this.pointA.setY(ay);
		}

		public void setPointEnd(int ax, int ay) {
			this.pointB.setX(ax);
			this.pointB.setY(ay);
		}

}
