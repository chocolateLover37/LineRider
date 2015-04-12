import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	    		gamePanel.setLineType("point");
	    		//ca fait des ronds
	    	}
	    	else if(e.getSource()==jTrait){
	    		gamePanel.setLineType("trait");
	    		//ca fait des traits a cote....
	    	}
	        else if (e.getSource ()==jPoubelle){
	        	gamePanel.erase();//ca marche
	        }
	        else if (e.getSource ()==jGomme){
	        	//coming soon.....
	        }
	    	
	        else if (e.getSource ()==jRouge){
	        	gamePanel.setPointerColor(Color.red);
	        }
	        else if (e.getSource ()==jVert){
	        	gamePanel.setPointerColor(Color.green);
	        }
	        else if (e.getSource ()==jOrange){
	        	gamePanel.setPointerColor(Color.orange);
	        }
	        else if (e.getSource ()==jBleu){
	        	gamePanel.setPointerColor(Color.blue);
	        }    	
    	}	  
	}	    	
}
