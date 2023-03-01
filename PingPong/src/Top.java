import java.awt.*;

public class Top {
    private  static final int DIAMETER =30;
    int x =0;
    int y = 40;
    int xa =2; // top hareket edeceği için artış miktarı başlangıç olarak verilmiş
    int ya =2;
    int say1 =0; // skor kısmı
    int say2 =0;
    int y1 ;
    private Oyun game;

    public Top(Oyun game){
        this.game=game;
    }
    void move(){
    if (x+xa <0){ // top sola vardığı zaman sağa gitmesini sağlar.
        xa =2;}
    if (x +xa > game.getWidth()- DIAMETER){
        xa = -2;}
    if (y +ya <0){// en üst noktaya vardığı zaman
        ya =2;}
    if (y + ya> game.getHeight()- DIAMETER){
        say1 ++;
        game.gameOver();

    }
    if (y +ya< 3){
        say2 ++;
        game.gameOver();
    }
    if (collision1()){
        ya =-2;
        y = game.racquet1.getTopY1()-DIAMETER;
    }
    if (collision2()){
        ya = +2;
        y = game.racquet1.getTopY2()+10;
    }
    x= x+xa;
    y = y +ya;

    }
    private boolean collision1() {
        return game.racquet1.getBounds1().intersects(getBounds());
    }
    private boolean collision2() {
        return game.racquet2.getBounds2().intersects(getBounds());

    }
    public void paint(Graphics2D g){
        g.fillOval(x,y,DIAMETER,DIAMETER);
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER,DIAMETER);

    }

}
