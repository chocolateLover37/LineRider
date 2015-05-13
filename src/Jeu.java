import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class Jeu extends JFrame{
	
	public Container mainPanel;
	public JPanel toolBar = new JPanel();
	public JPanel outils = new JPanel();
	public JPanel couleurs = new JPanel();
	public JButton jTrait, jCrayon, jPoubelle, jGomme;
	public JButton jNoir, jRouge, jOrange, jVert, jBleu, jTest;
	public JButton[] tabOutils;
	public JButton[] tabCouleurs;
	public GamePanel gamePanel = new GamePanel();
	public MenuPanel menuPanel = new MenuPanel();
        public Bille bille;


	public Jeu(){
              bille= new Bille(50,50,(double)0,(double)0,"bille.png");
		JPanel mainPanel=new JPanel();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.black);

		jCrayon = new JButton(new ImageIcon(Jeu.class.getResource("Kcrayon.png")));
		jTrait = new JButton(new ImageIcon(Jeu.class.getResource("Ktrait.png")));
        jPoubelle = new JButton(new ImageIcon(Jeu.class.getResource("Kpoubelle.png")));
        jGomme = new JButton(new ImageIcon(Jeu.class.getResource("Kgomme.png")));
        
        jNoir = new JButton(new ImageIcon(Jeu.class.getResource("Gnoir.png")));
        jRouge = new JButton(new ImageIcon(Jeu.class.getResource("Grouge.png")));
        jOrange = new JButton(new ImageIcon(Jeu.class.getResource("Gorange.png")));
        jVert = new JButton(new ImageIcon(Jeu.class.getResource("Gvert.png")));
        jBleu = new JButton(new ImageIcon(Jeu.class.getResource("Gbleu.png")));
        
        JButton[] tabOutils = {jTrait,jCrayon,jPoubelle,jGomme};
        for(int i=0;i<tabOutils.length;i++){
                tabOutils[i].setPreferredSize(new Dimension(50, 50));
                tabOutils[i].addActionListener(new GestionToolBar());
                tabOutils[i].setBackground(Color.white);
                outils.add(tabOutils[i]);    
        }
        jPoubelle.addActionListener(new GestionPoubelle());
        JButton[] tabCouleurs = {jRouge,jOrange,jVert,jBleu,jNoir};
        for(int i=0;i<tabCouleurs.length;i++){
                tabCouleurs[i].setPreferredSize(new Dimension(20, 20));
                tabCouleurs[i].addActionListener(new GestionToolBar());	
                tabCouleurs[i].setBackground(Color.white);
                couleurs.add(tabCouleurs[i]);
        }

		outils.add(jTrait);
        outils.add(jCrayon);
        outils.add(jPoubelle);
        outils.add(jGomme);
        couleurs.add(jNoir);
        couleurs.add(jRouge);
        couleurs.add(jOrange);
        couleurs.add(jVert);
        couleurs.add(jBleu);
        
        toolBar.setLayout(new BorderLayout());
        toolBar.add("North",outils);
        toolBar.add("South",couleurs);
        
        jTest = new JButton(new ImageIcon(Jeu.class.getResource("Gnoir.png")));
        jTest.setPreferredSize(new Dimension(40, 40));
        jTest.addActionListener(new GestionMenu());
        menuPanel.add(jTest);
        //mainPanel.add(menuPanel);
        mainPanel.add("North", toolBar);
		mainPanel.add("South", gamePanel); 
	    
		this.setContentPane(mainPanel);
		this.pack();
		this.setVisible(true);
	}
    
    public class GestionMenu implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==jTest){
	    		System.out.println("je devrais avoir change en gamePanel !!!! mais non :)");
				//mainPanel.add("North", toolBar);     //apparement on n'a pas le droit d'ecrire ca...
				//mainPanel.add("South", gamePanel); 
	    		//mainPanel.remove(menuPanel);
    		}	
    	}
    }
    
    public class GestionToolBar implements ActionListener{  

    	public void actionPerformed(ActionEvent e){

	    	if(e.getSource()==jCrayon){
	    		gamePanel.setAction("crayon");
	    		gamePanel.setPointerColor(gamePanel.getPointerColor());
	    		background(jCrayon);
	    	    afficherCouleurs(true);
	    	}
	    	else if(e.getSource()==jTrait){
	    		gamePanel.setAction("trait");
	    		gamePanel.setPointerColor(gamePanel.getPointerColor());
	    		
	    	    afficherCouleurs(true);
	    	}
	        else if (e.getSource()==jGomme){
	        	gamePanel.setAction("gomme");
	        	
	            afficherCouleurs(false);
	        }
	        else if (e.getSource ()==jPoubelle){
	        	
	            afficherCouleurs(false);
	            
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
	        else if (e.getSource ()==jNoir){
	        	gamePanel.setPointerColor(Color.black);
	        }  
	    	
    	} 
    } 
    
	public class GestionPoubelle implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {          
			ImageIcon img = new ImageIcon(Jeu.class.getResource("attention.png"));
			img.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
			int option = JOptionPane.showConfirmDialog(null, "Voulez-vous effacer toutes les lignes ?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, img);
			if(option == JOptionPane.OK_OPTION){
				gamePanel.erase();
			}
			gamePanel.setAction("trait");
			background(jTrait);
    	    afficherCouleurs(true);
		}    
	}
    
    public void afficherCouleurs(boolean b){//c'est ca qui fait tous les messages d'erreur, pourtant ca devrait marcher :/
    	couleurs.setVisible(b);
    	repaint();
    }
    
    
    
	
    //Methode de detection des collisions
    public Ligne collision (Rectangle2D [] bbille, LinkedList<Ligne> lili){
        Ligne choc = null;
        Rectangle2D bcourbe;
        bcourbe = null;
        for (int k=0; k< bbille.length; k++){
		    java.util.Iterator<Ligne> iterator = lili.iterator();
		    //check of collisions with other objects
		    while (iterator.hasNext()) {
		    	Ligne i = iterator.next();
		    	bcourbe = this.getBounds();
		    	if (bcourbe.intersects(bbille[k])==true){
		    		choc = i;
		    	}
		    }
        }
        return choc;
    }
}

