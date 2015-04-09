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
	
	public Container mainPanel; //fenetre globale
	
	public JToolBar toolBar; //barre d'outils

	
	public JButton jTrait; //quelques boutons de base
	public JButton jCrayon;
	public JButton jPoubelle;
	public JButton jGomme;
	
	public GamePanel gamePanel; //aire de dessin des courbes (classe faite maison)
	
	
	public Jeu(){
		JPanel mainPanel=new JPanel();
		this.setResizable(false);

		
		toolBar = new JToolBar("Line Rider menu"); //ToolBar c'est une classe deja dans java
		
		
		
		jCrayon = new JButton(new ImageIcon(Jeu.class.getResource("Kcrayon.png"))); //JButton c'est aussi dans java
		jTrait = new JButton(new ImageIcon(Jeu.class.getResource("Ktrait.png")));
        jPoubelle = new JButton(new ImageIcon(Jeu.class.getResource("Kpoubelle.png")));
		
        
        
        jCrayon.addActionListener(new ActionListener() {//ici on gardera en memoire la case cochee
			public void actionPerformed(ActionEvent e) {
				System.out.println("le crayon a ete clique");
			}
		});
		
        jTrait.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        System.out.println("le trait a ete clique");
                }
        });
        jPoubelle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    System.out.println("la poubelle a ete cliquee");
            }
        });
        
        

		toolBar.add(jCrayon);
        toolBar.add(jTrait);
        toolBar.add(jPoubelle);
        
		toolBar.setFloatable(false); //ca sert a rien de pouvoir la deplacer
		


		GamePanel gamePanel=new GamePanel();
		
		
		mainPanel.setLayout(new BorderLayout());//facon de ranger les trucs dans le mainPanel
		mainPanel.setBackground(Color.blue);//on ne devrait pas voir de bleu si toolBar et gamePanel sont ajoutes
		mainPanel.add("North",toolBar);
		mainPanel.add("South", gamePanel);  
		
		this.setContentPane(mainPanel);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
}
