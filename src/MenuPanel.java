import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	public JButton jTest;

	public MenuPanel(){
        jTest = new JButton(new ImageIcon(Jeu.class.getResource("Gorange.png")));
        jTest.setPreferredSize(new Dimension(40, 40));
		setPreferredSize(new Dimension(1200,600));
		this.setBackground(Color.black);
		this.add(jTest);
		setVisible(true);
	}
}