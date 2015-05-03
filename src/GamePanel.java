import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{
	
	public Color pointerColor = Color.black; //couleur du pointeur
	public String action = "trait"; //type de trait 
	public ArrayList<Ligne> lignes = new ArrayList<Ligne>();
	public Ligne temporaire = new Ligne();
	public int xS;
	public int yS;
	
	public GamePanel(){
		setPreferredSize(new Dimension(1200,600));
		this.setBackground(Color.white);
		setVisible(true);
		this.addMouseListener(new GestionOutils());
		this.addMouseMotionListener(new GestionOutils());
	}
	
	public class GestionOutils implements MouseListener, MouseMotionListener{
		PointCustom pointTempoS = new PointCustom();
		PointCustom pointTempoE = new PointCustom();
		
		
		public void mousePressed(MouseEvent e){
			xS=e.getX();
			yS=e.getY();
			
			if(action.equals("gomme")){
				for(int k=0;k<lignes.size();k++){
					if(lignes.get(k).distance(e.getX(),e.getY())<=30){
						lignes.remove(k);
					}
				}
			}
			repaint();
	    }
			
		public void mouseDragged(MouseEvent e) {
			
			if(action.equals("crayon")){
				pointTempoS.setXY(xS,yS);
				pointTempoE.setXY(e.getX(),e.getY());
				temporaire = new Ligne(pointTempoS,pointTempoE,pointerColor);
				
				if(temporaire.taille()>=20){
					lignes.add(new Ligne(new PointCustom(xS,yS,pointerColor), new PointCustom(e.getX(),e.getY(),pointerColor),pointerColor));
					xS=e.getX();
					yS=e.getY();
				}
			}
			
			if(action.equals("gomme")){
				for(int k=0;k<lignes.size();k++){
					if(lignes.get(k).distance(e.getX(),e.getY())<=30){
						lignes.remove(k);
					}
				}
			}

			if(action.equals("trait")){
				pointTempoS.setXY(xS,yS);
				pointTempoE.setXY(e.getX(),e.getY());
				temporaire = new Ligne(pointTempoS,pointTempoE,pointerColor);
			}
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
			if(action.equals("trait")){
				lignes.add(new Ligne(new PointCustom(xS,yS,pointerColor), new PointCustom(e.getX(),e.getY(),pointerColor),pointerColor));
			}
			repaint();
		}	
		public void mouseMoved(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	public void paintComponent(Graphics g) {

	    g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());

    	for(int k=0;k<lignes.size();k++){//on parcourt chaque Ligne de la ArrayList lignes
    		g.setColor(lignes.get(k).getColor());
    		PointCustom pA=lignes.get(k).getPointA();
    		PointCustom pB=lignes.get(k).getPointB();
    	    PointCustom pTempoA=temporaire.getPointA();
    		PointCustom pTempoB=temporaire.getPointB();
    		Graphics2D g2d = (Graphics2D)g;
    		Stroke stroke = new BasicStroke(5f);
    		g2d.setStroke(stroke);
    		g2d.drawLine(pA.getX(),pA.getY(),pB.getX(),pB.getY());
    		g2d.drawLine(pTempoA.getX(),pTempoA.getY(),pTempoB.getX(),pTempoB.getY());	
	    }	
	}	
	    	
	public void erase(){ //Efface le contenu
	    lignes.clear();
	    repaint();
	}
	public void setPointerColor(Color c){
	    this.pointerColor = c;
	}
	public void setAction(String type){
		this.action = type;
	}
}	
		
		

