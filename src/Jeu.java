import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import java.util.*;

public class Jeu extends JFrame {

    public Container mainPanel;
    public static ToolBar toolBar = new ToolBar();
    public static GamePanel gamePanel = new GamePanel();
    public static MenuPanel menuPanel = new MenuPanel();

    public Timer timer;
    public long temps;
    public static Rectangle Ecran;
    public BufferedImage ArrierePlan;
    public Graphics buffer;
    public Bille billeRouge;
    public Rectangle frameBille;
    public static boolean play;

    public Jeu() {
        JPanel mainPanel = new JPanel();
        setSize(1200, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.black);
        frameBille = new Rectangle(100, 100, 40, 40);
        //billeRouge= new Bille(frameBille);

        mainPanel.add("South", menuPanel);
        mainPanel.add("North", toolBar);
        mainPanel.add("Center", gamePanel);
        toolBar.setVisible(false);
        gamePanel.setVisible(false);

        Ecran =
            new Rectangle(getInsets().left, getInsets().top, getSize().width - getInsets().right - getInsets().left,
                          getSize().height - getInsets().bottom - getInsets().top);
        ArrierePlan = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
        buffer = ArrierePlan.getGraphics();
        timer = new Timer(100, new TimerAction());
        timer.setDelay(40);
        timer.start();

        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    private class TimerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boucle_princip(); //c'etait dans space invaders
            temps++;
        }
    }

    public void boucle_princip() {
        if (play) {
            //billeRouge.move(temps);
            repaint();
        }
    }

    //Methode de detection des collisions
    public Ligne collision(Rectangle2D[] bbille, LinkedList<Ligne> lili) {
        Ligne choc = null;
        Rectangle2D bcourbe;
        bcourbe = null;
        for (int k = 0; k < bbille.length; k++) {
            java.util.Iterator<Ligne> iterator = lili.iterator();
            //check of collisions with other objects
            while (iterator.hasNext()) {
                Ligne i = iterator.next();
                bcourbe = this.getBounds();
                if (bcourbe.intersects(bbille[k]) == true) {
                    choc = i;
                }
            }
        }
        return choc;
    }

    public void paintComponent(Graphics g) {
        billeRouge.draw(temps, buffer);
        g.drawImage(ArrierePlan, 0, 0, this);
        System.out.println("say hi");
    }

    public static void main(String[] args) {
        new Jeu();
    }
}

