import java.awt.*;
import javax.swing.*;

public class Paddle{

    private int x,y;

    public Paddle(){
        this(0,0);
    }

    public Paddle(int xcoord, int ycoord){
        x = xcoord;
        y = ycoord;
    }

    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x,y , 10, 75);
    }

    public boolean contacts(Ball b){
        if (b.getX() + 20 >= x
        && b.getX() <= x + 10
        && b.getY() + 20 >= y
        && b.getY() <= y + 75){
            return true;
        }
        return false;
    }

}