import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GestionTraits implements ActionListener{
	Point pointA = null;
	Point pointB=null; //en fontion du bouton de la barre d'outil clique la classe fera des trucs differents 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	 /*on a copie un code bizzare, faudra voir si il marche
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pointA = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                pointA = null;
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                pointB = e.getPoint();
            }

            public void mouseDragged(MouseEvent e) {
                pointB = e.getPoint();
                repaint();
            }
        });
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        if (pointA != null) {
            g.setColor(Color.RED);
            g.drawLine(pointA.x, pointA.y, pointB.x, pointB.y);
        }
    }
    */
}

