import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class Jeu extends JFrame{
	
	public Container mainPanel;
	public JPanel toolBar = new JPanel();
	public JPanel outils = new JPanel();
	public JPanel couleurs = new JPanel();
	public JButton jTrait;
	public JButton jCrayon, jPoubelle, jGomme;
	public JButton jNoir, jRouge, jOrange, jVert, jBleu;
	public JButton[] tabOutils;
	public JButton[] tabCouleurs;
	public GamePanel gamePanel=new GamePanel();

	public Jeu(){
		JPanel mainPanel=new JPanel();
		this.setResizable(false);
		this.setTitle("Line Rider !!!");
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
        
		mainPanel.add("North",toolBar);
		mainPanel.add("South", gamePanel); 
	    
		this.setContentPane(mainPanel);
		this.pack();
		this.setVisible(true);
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

    public class GestionToolBar implements ActionListener{  

    	public void actionPerformed(ActionEvent e){

	    	if(e.getSource()==jCrayon){
	    		gamePanel.setAction("crayon");
	    		gamePanel.setPointerColor(Color.black);
	    	    jCrayon.setBackground(Color.blue);
	    	    jTrait.setBackground(Color.white);
	    	    jGomme.setBackground(Color.white);
	    	    jPoubelle.setBackground(Color.white);       
	    	}
	    	else if(e.getSource()==jTrait){
	    		gamePanel.setAction("trait");
	    		gamePanel.setPointerColor(Color.black);
	    	    jTrait.setBackground(Color.blue);
	    	    jGomme.setBackground(Color.white);
	    	    jCrayon.setBackground(Color.white);
	    	    jPoubelle.setBackground(Color.white);       
	    	}
	        else if (e.getSource()==jGomme){
	        	gamePanel.setAction("gomme");
	            jTrait.setBackground(Color.white);
	            jCrayon.setBackground(Color.white);
	            jGomme.setBackground(Color.blue);
	            jPoubelle.setBackground(Color.white);
	        }
	        else if (e.getSource ()==jPoubelle){
	        	gamePanel.erase();
	        	gamePanel.setPointerColor(Color.white);
	            jTrait.setBackground(Color.white);
	            jCrayon.setBackground(Color.white);
	            jGomme.setBackground(Color.white);
	            jPoubelle.setBackground(Color.blue);          
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
}

