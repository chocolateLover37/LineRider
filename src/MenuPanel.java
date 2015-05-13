import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements MouseMotionListener{
	public JButton jNoir;
	boolean top = false;
	
	public MenuPanel(){
		setPreferredSize(new Dimension(1200,600));
		this.setBackground(Color.blue);
		setVisible(true);
		this.addMouseMotionListener(this);
	}
	
	public void mouseMoved(MouseEvent arg0) {}
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("coucou");
	}
}
