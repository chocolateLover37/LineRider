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
		jCrayon.setPreferredSize(new Dimension(40, 40));
                jTrait = new JButton(new ImageIcon(Jeu.class.getResource("Ktrait.png")));
                jTrait.setPreferredSize(new Dimension(40, 40));
                jPoubelle = new JButton(new ImageIcon(Jeu.class.getResource("Kpoubelle.png")));
                jPoubelle.setPreferredSize(new Dimension(40, 40));
                jGomme = new JButton(new ImageIcon(Jeu.class.getResource("Kgomme.png")));
                jGomme.setPreferredSize(new Dimension(40, 40));
                        
                jCrayon.addActionListener(new GestionToolBar());	
                jTrait.addActionListener(new GestionToolBar());      
                jPoubelle.addActionListener(new GestionToolBar()); 
                jGomme.addActionListener(new GestionToolBar());
		toolBar.add(jCrayon);
                toolBar.add(jTrait);
                toolBar.add(jPoubelle);
                toolBar.add(jGomme);
                
        
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
	
        public class GestionToolBar implements ActionListener{  
        
                    public void actionPerformed(ActionEvent e){
                            //il faut recuperer l'information quand les boutons sont cliques
                        if(e.getSource()==jCrayon){
                            System.out.println("le crayon a ete clique"); 
                            //plutard va nous envoyer dans une classe avec des methodes liees aux dessins. voir methode dans la framecalculette
                        } else if(e.getSource()==jTrait){
                            System.out.println("le trait a ete clique");
                        }else if (e.getSource ()==jPoubelle){
                            System.out.println("la poubelle a ete cliquee");
                        }else if (e.getSource ()==jGomme){
                            System.out.println("la gomme a ete cliquee");
                            }
                
                    }               
        }    
}
