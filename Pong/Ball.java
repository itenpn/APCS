import java.awt.*;
import javax.swing.*;

public class Ball{

    private int x, y;

    public Ball(){
        this(0,0);
    }

    public Ball(int xcoord, int ycoord){
        x = xcoord;
        y = ycoord;
    }

    public void draw(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, 20, 20);
    }

    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}