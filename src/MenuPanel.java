import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		jTest.addActionListener(new GestionMenu());
	}
    
    public class GestionMenu implements ActionListener{ 
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==jTest){
    			Jeu.menuPanel.setVisible(false);
    	        Jeu.gamePanel.setVisible(true);
    			Jeu.toolBar.setVisible(true);
    		}
    	}
    }	
}
