
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Bouton extends JButton implements MouseListener {
	protected String nom;
	protected Image image;
	
	public Bouton(String aNom){ //pour tous les boutons on d�finira le chemin
		super(aNom);  // on h�rite du constructeur d�j� dans java
		this.nom = aNom;
		ImageIcon icone = new ImageIcon(aNom);
        image = icone.getImage();

        
		this.addMouseListener(this);  //interface d'�coute pour chaque bouton
	}
	
	public void paint( Graphics g ) {
        super.paint( g );
        g.drawImage(image,  0 , 0 , getWidth() , getHeight() , (ImageObserver) image);
    }
	
	
	public void mousePressed(MouseEvent e) {  // on doit tout mettre m�me si c'est vide pour pouvoir compiler
	    }
	public void mouseReleased(MouseEvent e) {
	    }
	public void mouseEntered(MouseEvent e) {
	    }
	public void mouseExited(MouseEvent e) {
	    }
	public void mouseClicked(MouseEvent e) {
	    }
}

