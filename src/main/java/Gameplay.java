import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{

    private boolean play = false;

    private Timer timer;
    private int delay = 4;

    private int playerX = 300;
    private int playerY = 300;

    private int ballPosX = 350;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint (Graphics g)
    {

        g.setColor(Color.BLACK);
        g.fillRect(1,1,692,592);

        g.setColor(Color.GREEN);
        g.fillRect(0,0,692,2);
        g.fillRect(0,558,692,2);

        g.setColor(Color.GREEN);
        g.fillRect(650,playerX,8,100);     //x->  y|up

        g.setColor(Color.GREEN);
        g.fillRect(50,playerY,8,100);

        g.setColor(Color.WHITE);
        g.fillOval(ballPosX,ballPosY,20,20);

        if (ballPosX <0 || ballPosX > 660) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("Comic Sans",Font.BOLD,30 ));
            g.drawString("Koniec Gry CIOTO",200,200);

            g.setFont(new Font("Comic Sans",Font.BOLD,10 ));
            g.drawString("PRESS SPACE TO CONTINUE",230,250);

        }

        g.dispose();

    }

    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            if(new Rectangle(ballPosX, ballPosY,20,20).intersects(new Rectangle(650,playerX,8,100)))
            {
                ballXdir = - ballXdir;
            }
            if(new Rectangle(ballPosX, ballPosY,20,20).intersects(new Rectangle(50,playerY,8,100)))
            {
                ballXdir = -ballXdir;
            }
            ballPosX += ballXdir;
            ballPosY += ballYdir;
            if (ballPosY > 540) {
                ballYdir = -ballYdir;
            }
            if (ballPosY < 0) {
                ballYdir = -ballYdir;
            }
            /*if (ballPosX < 0) {
                ballXdir = -ballXdir;
            }
            if (ballPosX < 500) {
                ballXdir = -ballXdir;
            }*/

            repaint();

        }
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
             if(playerX <= 5) {
                 playerX = 5;
              } else {
                  moveUpUp();
              }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(playerX >=452) {
                playerX =452;
            } else {
                moveDownDown();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
            if(playerY <= 5) {
                playerY = 5;
            } else {
                moveUpE();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            if(playerY >=452) {
                playerY =452;
            } else {
                moveDownS();
            }
        }
        if(e.getKeyCode() ==KeyEvent.VK_SPACE){
            if(!play) {
                play = true;
                 playerX = 300;
                 playerY = 300;

                 ballPosX = 350;
                 ballPosY = 350;
                 ballXdir = -1;
                 ballYdir = -2;
            }

        }

}
    private void moveUpE() {
        play = true;
        playerY-=20;
    }
    private void moveDownS(){
        play = true;
        playerY+=20;
    }
    private void moveDownDown() {
        play = true;
        playerX+=20;
    }
    private void moveUpUp() {
        play = true;
        playerX-=20;
    }
}
