import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Jeu extends JFrame{
	
	public Container mainPanel; //fen�tre globale
	
	public JToolBar toolBar; //barre d'outils (de rien)
	public Bouton jTrait; //quelques boutons de base (� compl�ter)
	public JButton jCrayon;
	public Bouton jGomme;
	
	public GamePanel gamePanel; //aire de dessin des courbes (classe faite maison)
	
	
	public Jeu(){
		JPanel mainPanel=new JPanel();
		this.setResizable(false);
		this.addKeyListener(new Jeu_this_keyAdaptater());
		
		
		toolBar = new JToolBar("Line Rider menu"); //ToolBar c'est d�j� dans java
		jCrayon = new JButton(new ImageIcon(Jeu.class.getResource("Kcrayon.png"))); //on a cr�� l'objet Bouton
		jCrayon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello !");
			}
		});
		toolBar.add(jCrayon);
		jTrait = new Bouton("Ktrait.png");
		toolBar.add(jTrait);
		toolBar.setFloatable(false);
		
		
		// + autres Boutons � cr�er

		GamePanel gamePanel=new GamePanel();
		
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.blue);
		mainPanel.add("North",toolBar);
		//mainPanel.add("South", gamePanel);  
		
		this.setContentPane(mainPanel);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	private class Jeu_this_keyAdaptater extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
				System.exit(0);
			}
		}
	}
}
