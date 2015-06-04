import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToolBar extends JPanel {

    public JPanel outils = new JPanel();
    public JPanel couleurs = new JPanel();
    public JButton jTrait, jCrayon, jPoubelle, jGomme;
    public JButton jNoir, jRouge, jOrange, jVert, jBleu, jTest, jPlay, jStop;
    public JButton[] tabOutils;
    public JButton[] tabCouleurs;

    public ToolBar() {
        jCrayon = new JButton(new ImageIcon(Jeu.class.getResource("Kcrayon.png")));
        jTrait = new JButton(new ImageIcon(Jeu.class.getResource("Ktrait.png")));
        jPoubelle = new JButton(new ImageIcon(Jeu.class.getResource("Kpoubelle.png")));
        jGomme = new JButton(new ImageIcon(Jeu.class.getResource("Kgomme.png")));
        jPlay = new JButton(new ImageIcon(Jeu.class.getResource("Kplay.png")));
        jStop = new JButton(new ImageIcon(Jeu.class.getResource("Kstop.png")));

        jNoir = new JButton(new ImageIcon(Jeu.class.getResource("Gnoir.png")));
        jRouge = new JButton(new ImageIcon(Jeu.class.getResource("Grouge.png")));
        jOrange = new JButton(new ImageIcon(Jeu.class.getResource("Gorange.png")));
        jVert = new JButton(new ImageIcon(Jeu.class.getResource("Gvert.png")));
        jBleu = new JButton(new ImageIcon(Jeu.class.getResource("Gbleu.png")));

        JButton[] tabOutils = { jTrait, jCrayon, jPoubelle, jGomme, jPlay, jStop};
        for (int i = 0; i < tabOutils.length; i++) {
            tabOutils[i].setPreferredSize(new Dimension(50, 50));
            tabOutils[i].addActionListener(new GestionToolBar());
            tabOutils[i].setBackground(Color.white);
            outils.add(tabOutils[i]);
        }

        JButton[] tabCouleurs = { jRouge, jOrange, jVert, jBleu, jNoir };
        for (int i = 0; i < tabCouleurs.length; i++) {
            tabCouleurs[i].setPreferredSize(new Dimension(20, 20));
            tabCouleurs[i].addActionListener(new GestionToolBar());
            tabCouleurs[i].setBackground(Color.white);
            couleurs.add(tabCouleurs[i]);
        }

        setLayout(new BorderLayout());
        add("North", outils);
        add("South", couleurs);
    }

    public class GestionToolBar implements ActionListener {

        public void background(JButton b) {
            JButton[] tabOutils = { jTrait, jCrayon, jPoubelle, jGomme, jPlay,jStop };
            for (int i = 0; i < tabOutils.length; i++) {
                tabOutils[i].setPreferredSize(new Dimension(50, 50));
                tabOutils[i].setBackground(Color.white);
                outils.add(tabOutils[i]);
            }
            for (int i = 0; i < tabOutils.length; i++) {
                if (tabOutils[i] == b) {
                    tabOutils[i].setBackground(Color.blue);
                } else {
                    tabOutils[i].setBackground(Color.white);
                }
                if (b == jPlay) {
                    jPlay.setBackground(Color.red);
                } else if(b == jStop) {
                    jStop.setBackground(Color.red);
                }
            }
        }

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == jTest) {
                Jeu.menuPanel.setVisible(false);
                Jeu.gamePanel.setVisible(true);
                outils.setVisible(true);
                couleurs.setVisible(true);
            }

            if (e.getSource() == jCrayon) {
                Jeu.gamePanel.setAction("crayon");
                Jeu.gamePanel.setPointerColor(Jeu.gamePanel.getPointerColor());
                background(jCrayon);
            } else if (e.getSource() == jTrait) {
                Jeu.gamePanel.setAction("trait");
                Jeu.gamePanel.setPointerColor(Jeu.gamePanel.getPointerColor());
                background(jTrait);
            } else if (e.getSource() == jGomme) {
                Jeu.gamePanel.setAction("gomme");
                background(jGomme);
            } else if (e.getSource() == jPoubelle) {
                ImageIcon img = new ImageIcon(Jeu.class.getResource("attention.png"));
                img.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                int option =
                    JOptionPane.showConfirmDialog(null, "Voulez-vous effacer toutes les lignes ?", "",
                                                  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, img);
                if (option == JOptionPane.OK_OPTION) {
                    Jeu.gamePanel.erase();
                    Jeu.stop=true;
                    Jeu.gamePanel.billeRougebis.setXY(-10,-10);
                    
                }
                Jeu.gamePanel.setAction("trait");
                background(jTrait);
                background(jPoubelle);
            }

            else if (e.getSource() == jRouge) {
                Jeu.gamePanel.setPointerColor(Color.red);
            } else if (e.getSource() == jVert) {
                Jeu.gamePanel.setPointerColor(Color.green);
            } else if (e.getSource() == jOrange) {
                Jeu.gamePanel.setPointerColor(Color.orange);
            } else if (e.getSource() == jBleu) {
                Jeu.gamePanel.setPointerColor(Color.blue);
            } else if (e.getSource() == jNoir) {
                Jeu.gamePanel.setPointerColor(Color.black);
            } else if (e.getSource() == jPlay) {
                Jeu.play = true;
                background(jPlay);
                repaint(); 
            } else if(e.getSource()== jStop){
                Jeu.play=false;
                background(jStop);
            }
        }
    }
}
