import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Oyun extends JPanel{
    int count1;
    int count2;
    Top ball = new Top(this);
    Raketler racquet1 = new Raketler(this);
    Raketler racquet2 = new Raketler(this);
public Oyun(){
    addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
        racquet1.keyPressed(e);
        racquet2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            racquet1.keyRelased(e);
            racquet2.keyRelased(e);

        }
    });
    setFocusable(true);
}
private void move(){
    ball.move();
    racquet1.move1();
    racquet2.move2();
}
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        count1 = ball.say1;
        count2 = ball.say2;
        g2d.drawString("1.Oyuncu :", 5, 20);
        g2d.drawString(String.valueOf(count1), 60, 20);
        g2d.drawString("2.Oyuncu :", 5, 350);
        g2d.drawString(String.valueOf(count2), 60, 350);
        ball.paint(g2d);
        racquet1.paint1(g2d);
        racquet2.paint2(g2d);

    }
    public void gameOver(){

    if (count1==2) {
        repaint();
        JOptionPane.showMessageDialog(this, "Oyun bitti 1. oyuncu kazandı", "Oyun bitti", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    } else if (count2==2) {
        repaint();
        JOptionPane.showMessageDialog(this, "Oyun bitti 2. oyuncu kazandı", "Oyun bitti", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);

    }
    else {
        ball.x = 0;
        ball.y = 40;
        ball.xa = 2;
        ball.ya = 2;
    }
    }
    public static void main(String[]args)throws InterruptedException{
        JFrame frame = new JFrame("Mini Tenis");
        Oyun game = new Oyun();
        frame.add(game);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true){
            game.move();
            game.repaint();
            Thread.sleep(10);


        }




    }





}
