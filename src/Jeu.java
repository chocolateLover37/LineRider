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
    public Rectangle frameBille;
    public static boolean play;
    public static boolean stop;
    public Audio son;

    public Jeu() {
        JPanel mainPanel = new JPanel();
        setSize(1600, 900);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.black);
        mainPanel.add("South", menuPanel);
        mainPanel.add("North", toolBar);
        mainPanel.add("Center", gamePanel);
        toolBar.setVisible(false);
        gamePanel.setVisible(false);
        
        
        Ecran = new Rectangle(getInsets().left, getInsets().top, getSize().width - getInsets().right - getInsets().left, getSize().height - getInsets().bottom - getInsets().top);
        //ArrierePlan = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
        //buffer = ArrierePlan.getGraphics();
        
        timer = new Timer(20, new TimerAction());
        timer.start();        
        temps=0;
        
        son=new Audio();
        son.start();
    
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    private class TimerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(play==true){
                boucle_princip(); //c'etait dans space invaders
                temps++;               
            }else{
                temps=0;
                gamePanel.billeRougebis= new Bille((int)gamePanel.dpt.getX()+gamePanel.billeRougebis.h/2,(int)gamePanel.dpt.getY()+gamePanel.billeRougebis.h/2,0,0,gamePanel.rec,"BilleRouge.png");   
            }
        }
    }
    

    public void boucle_princip() {
        if(gamePanel.billeRougebis!=null&& gamePanel!=null){
            gamePanel.billeRougebis.move(gamePanel.lignes,temps);
            repaint();
            if(Ecran.contains(gamePanel.billeRougebis.x, gamePanel.billeRougebis.y)==false){ //arrete le jeu quand la bille sort du cadre
                play=false;
            }
        }
    }
    
    public static void main(String[] args) {
        new Jeu();
    }
}