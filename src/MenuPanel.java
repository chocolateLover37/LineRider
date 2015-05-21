import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	public JButton jTest;

	public MenuPanel(){
        jTest = new JButton(new ImageIcon(Jeu.class.getResource("intro.png")));
        jTest.setPreferredSize(new Dimension(200, 150));
		setPreferredSize(new Dimension(1200,600));
		this.setBackground(Color.black);
		this.add(jTest);
		setVisible(true);
	}
}
