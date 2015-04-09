import java.awt.*;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.LinkedList;

public class GamePanel extends JPanel /*implements MouseListener, MouseMotionListener*/{
	
	//j'aime le caca
	//et les endives
	public Timer timer;
	public long temps;
	public BufferedImage ArrierePlan;
	public Graphics buffer;
	public LinkedList <Ligne> listeLignes;//ici on retient en mémoire tous les traits
	public Rectangle Ecran;
	
	public GamePanel(){
		listeLignes = new LinkedList <Ligne> ();

	    //ArrierePlan = new BufferedImage(getSize().width,getSize().height,BufferedImage.TYPE_INT_RGB); ça ne compile pas
		//Ecran=new Rectangle(getInsets().left,getInsets().top,getSize().width-getInsets().right-getInsets().left,getSize().height-getInsets().bottom-getInsets().top);
		//buffer = ArrierePlan.getGraphics();
		timer = new Timer(1, new GestionTraits() );
		timer.setDelay(1);
		timer.start();
		setVisible(true);
		
		
		this.addKeyListener(new Jeu_this_keyAdaptater());
		
	}
	
	private class Jeu_this_keyAdaptater extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
				System.exit(0);
				
			}
		}
	}
	

	/*
	public void paint( Graphics g ) {
			
			buffer.setColor(Color.black);
			buffer.fillRect(Ecran.x, Ecran.y, Ecran.x+Ecran.width, Ecran.y+Ecran.height);
			for (int k=0; k<Objets.size(); k++) {
		        Objet O = (Objet) Objets.get(k);
		        O.draw(temps, buffer);
			}
			g.drawImage(ArrierePlan,0,0,this);
		}*/
}
