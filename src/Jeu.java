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
	
	public Container mainPanel; //fenêtre globale
	
	public JToolBar toolBar; //barre d'outils (de rien)
	public Bouton jTrait; //quelques boutons de base (à compléter)
	public Bouton jCrayon;
	public Bouton jGomme;
	
	public GamePanel gamePanel; //aire de dessin des courbes (classe faite maison)
	
	
	public Jeu(){
		JPanel mainPanel=new JPanel();
		mainPanel.setSize(1000,1000); //taille non définitive
		this.setResizable(true);
		this.addKeyListener(new Jeu_this_keyAdaptater());
		
		
		toolBar = new JToolBar("Line Rider menu"); //ToolBar c'est déjà dans java
		jCrayon = new Bouton("Kcrayon.png"); //on a créé l'objet Bouton
		toolBar.add(jCrayon);
		jTrait = new Bouton("Ktrait.png");
		toolBar.add(jTrait);
		
		// + autres Boutons à créer

		GamePanel gamePanel=new GamePanel();
		
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.blue);
		mainPanel.add("North",toolBar);
		mainPanel.add("South", gamePanel);  
		
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
