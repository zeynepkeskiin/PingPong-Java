import java.awt.*;
import java.awt.event.KeyEvent;

public class Raketler {
    private static final int Y1 = 300;
    private static final int Y2 = 30;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa1 = 0;
    int xa2 = 0;
    private Oyun game;

    public Raketler(Oyun game) {
        this.game = game;
    }

    public void move1() {
        if (x + xa1 > 0 && x + xa1 < game.getWidth() - WIDTH)
            x = x + xa1;

    }

    public void move2() {
        if (x + xa2 > 0 && x + xa2 < game.getWidth() - WIDTH)
            x = x + xa2;


    }
    public void paint1(Graphics2D g){
        g.fillRect(x,Y1,WIDTH,HEIGHT);
    }
    public void paint2(Graphics2D g){
        g.fillRect(x,Y2,WIDTH,HEIGHT);
    }
    public void keyRelased(KeyEvent e){
        xa1 =0;
        xa2 =0;

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa1 = -3;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa1 = 3;
        if (e.getKeyCode() == KeyEvent.VK_A)
            xa2 = -3;
        if (e.getKeyCode() == KeyEvent.VK_D)
            xa2 = 3;
    }
    public Rectangle getBounds1() {    // topla raketin kesişmesini kontrol etmemiz için get bounds kapladğı yeri al
        return new Rectangle(x, Y1, WIDTH, HEIGHT);
    }
    public Rectangle getBounds2() {
        return new Rectangle(x, Y2, WIDTH, HEIGHT);
    }
    public int getTopY1() { // 1. raketin y nok en üst kısmını
        return Y1;
    }
    public int getTopY2() {
        return Y2;
    }


   }
