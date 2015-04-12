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
	
	public JPanel toolBar = new JPanel();
	public JPanel outils = new JPanel();
	public JPanel couleurs = new JPanel();

	public JButton jTrait; //quelques boutons de base
	public JButton jCrayon, jPoubelle, jGomme;
	public JButton jRouge, jOrange, jVert, jBleu;
	public JButton[] tabOutils;
	public JButton[] tabCouleurs;
	public GamePanel gamePanel=new GamePanel(); //aire de dessin des courbes (classe faite maison)
	
	
	public Jeu(){
		JPanel mainPanel=new JPanel();
		this.setResizable(false);
		this.setTitle("Line Rider !!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel.setLayout(new BorderLayout());//facon de ranger les trucs dans le mainPanel
		mainPanel.setBackground(Color.black);

		jCrayon = new JButton(new ImageIcon(Jeu.class.getResource("Kcrayon.png"))); //JButton c'est aussi dans java
		jTrait = new JButton(new ImageIcon(Jeu.class.getResource("Ktrait.png")));
        jPoubelle = new JButton(new ImageIcon(Jeu.class.getResource("Kpoubelle.png")));
        jGomme = new JButton(new ImageIcon(Jeu.class.getResource("Kgomme.png")));
        
        jRouge = new JButton(new ImageIcon(Jeu.class.getResource("Grouge.png")));
        jOrange = new JButton(new ImageIcon(Jeu.class.getResource("Gorange.png")));
        jVert = new JButton(new ImageIcon(Jeu.class.getResource("Gvert.png")));
        jBleu = new JButton(new ImageIcon(Jeu.class.getResource("Gbleu.png")));
        jCrayon.setPreferredSize(new Dimension(40, 40));
        
        JButton[] tabOutils = {jCrayon,jTrait,jPoubelle,jGomme};
        for(int i=0;i<tabOutils.length;i++){
        	tabOutils[i].setPreferredSize(new Dimension(40, 40));
        	tabOutils[i].addActionListener(new GestionToolBar());	
        	outils.add(tabOutils[i]);
        }
        JButton[] tabCouleurs = {jRouge,jOrange,jVert,jBleu};
        for(int i=0;i<tabCouleurs.length;i++){
        	tabCouleurs[i].setPreferredSize(new Dimension(20, 20));
        	tabCouleurs[i].addActionListener(new GestionToolBar());	
        	couleurs.add(tabCouleurs[i]);
        }
        
        
		outils.add(jCrayon);
        outils.add(jTrait);
        outils.add(jPoubelle);
        outils.add(jGomme);
        couleurs.add(jRouge);
        couleurs.add(jOrange);
        couleurs.add(jVert);
        couleurs.add(jBleu);
        
        toolBar.setLayout(new BorderLayout());
        toolBar.add("North",outils);
        toolBar.add("South",couleurs);
        
		mainPanel.add("North",toolBar);
		mainPanel.add("South", gamePanel); 
	    
		this.setContentPane(mainPanel);
		this.pack();
		this.setVisible(true);
	}
	
    public class GestionToolBar implements ActionListener{  

    	public void actionPerformed(ActionEvent e){
    		
	    	if(e.getSource()==jCrayon){
	    		System.out.println("Vous avez cliquŽ sur le crayon !!!");
	    		gamePanel.setLineType("point");//impossible de modifier l'attribut LineType
	    		//ca fait des ronds
	    	}
	    	else if(e.getSource()==jTrait){
	    		System.out.println("Vous avez cliquŽ sur le trait !!!");
	    		gamePanel.setLineType("trait");//ne marche pas non plus
	    		//ca devrait faire des traits
	    	}
	        else if (e.getSource ()==jPoubelle){
	        	System.out.println("Vous avez cliquŽ sur la poubelle !!!");
	        	gamePanel.erase();//ca marche !!!!!!!!!!!!!!
	        }
	        else if (e.getSource ()==jGomme){
	        	System.out.println("Vous avez cliquŽ sur la gomme !!!");
	        	//coming soon.....
	        }
	    	
	        else if (e.getSource ()==jRouge){
	        	System.out.println("Vous avez cliquŽ sur le rouge !!!");
	        	gamePanel.setPointerColor(Color.red);
	        }
	        else if (e.getSource ()==jVert){
	        	System.out.println("Vous avez cliquŽ sur le vert !!!");
	        	gamePanel.setPointerColor(Color.green);
	        }
	        else if (e.getSource ()==jOrange){
	        	System.out.println("Vous avez cliquŽ sur l'orange !!!");
	        	gamePanel.setPointerColor(Color.orange);
	        }
	        else if (e.getSource ()==jBleu){
	        	System.out.println("Vous avez cliquŽ sur le bleu !!!");
	        	gamePanel.setPointerColor(Color.blue);
	        }    	
    	}	  
	}	    	
}
