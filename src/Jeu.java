import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

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
    //public static Bille billeRouge;
    public Rectangle frameBille;
    public static boolean play;
    public static boolean stop;

    public Jeu() {
        JPanel mainPanel = new JPanel();
        setSize(1200, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.black);
      
        //billeRouge= new Bille((int)gamePanel.dpt.getX(),(int)gamePanel.dpt.getY(),0,0,Ecran,);
        

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
        timer = new Timer(20, new TimerAction());
        timer.start();
   
        
        temps=0;
        
              
        

        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    private class TimerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(play==true){
            boucle_princip(); //c'etait dans space invaders
            //System.out.println("say hi action"+temps);
            temps++;
               
            }else{
                temps=0;
                gamePanel.billeRougebis= new Bille((int)gamePanel.dpt.getX()+gamePanel.billeRougebis.h/2,(int)gamePanel.dpt.getY()+gamePanel.billeRougebis.h/2,0,0,gamePanel.rec,"BilleRouge.png");
                
            }
            
            }
        }
    

    public void boucle_princip() {
        if(gamePanel.billeRougebis!=null&& gamePanel!=null){
            for(int i=2;i<8;i++){
                gamePanel.nomIm="BilleRouge"+String.valueOf(i)+"png";
            }  
            gamePanel.billeRougebis.move(gamePanel.lignes,temps);
            repaint();
            //System.out.println("say hi boucle principale");
        }
    }
    

    /*Methode de detection des collisions
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
    }*/
        

    public static void main(String[] args) {
        new Jeu();
    }
}

