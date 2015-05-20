import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
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

	public Timer timer;
	public long temps;
	public static Rectangle Ecran;
	public BufferedImage ArrierePlan;
	public Graphics buffer;
	public Bille billeRouge;
	
	public Jeu(){		
		JPanel mainPanel=new JPanel();
		setSize(1200,600);
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
        
        menuPanel.jTest.addActionListener(new GestionToolBar());
        
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
        
        mainPanel.add("South",menuPanel);
        mainPanel.add("North",toolBar);
        mainPanel.add("Center",gamePanel);
        toolBar.setVisible(false);
        gamePanel.setVisible(false);
        
        Ecran=new Rectangle(getInsets().left,getInsets().top,getSize().width-getInsets().right-getInsets().left,getSize().height-getInsets().bottom-getInsets().top);
		ArrierePlan = new BufferedImage(getSize().width,getSize().height,BufferedImage.TYPE_INT_RGB);
		buffer = ArrierePlan.getGraphics();
        timer = new Timer(100, new TimerAction());
		timer.setDelay(40);
		timer.start();
        
		this.setContentPane(mainPanel);
		this.pack();
		this.setVisible(true);
	}
	
	private class TimerAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//boucle_principale_jeu();  c'etait dans space invaders
			temps++;
		}
	}
    
    public class GestionToolBar implements ActionListener{  
    	
        public void background(JButton b){
        	for(int i=0;i<tabOutils.length;i++){
        		if(tabOutils[i]==b){
        			tabOutils[i].setBackground(Color.blue);
        		}
        		else{
        			tabOutils[i].setBackground(Color.white);
        		}
    		} 
        }  
        
    	public void actionPerformed(ActionEvent e){
    		
    		if(e.getSource()==menuPanel.jTest){
    			menuPanel.setVisible(false);
    	        gamePanel.setVisible(true);
    			toolBar.setVisible(true);
    		}

	    	if(e.getSource()==jCrayon){
	    		gamePanel.setAction("crayon");
	    		gamePanel.setPointerColor(gamePanel.getPointerColor());
	    		background(jCrayon);
	    	}
	    	else if(e.getSource()==jTrait){
	    		gamePanel.setAction("trait");
	    		gamePanel.setPointerColor(gamePanel.getPointerColor());
	    		background(jTrait);
	    	}
	        else if (e.getSource()==jGomme){
	        	gamePanel.setAction("gomme");
	        	background(jGomme);
	        }
	        else if (e.getSource ()==jPoubelle){
	        	ImageIcon img = new ImageIcon(Jeu.class.getResource("attention.png"));
				img.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				int option = JOptionPane.showConfirmDialog(null, "Voulez-vous effacer toutes les lignes ?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, img);
				if(option == JOptionPane.OK_OPTION){
					gamePanel.erase();
				}
				gamePanel.setAction("trait");
				background(jTrait);
	        	background(jPoubelle);	            
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

