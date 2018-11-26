import javax.swing.*;
import java.awt.*;

public class Goal{
        private int x, y, width, height;
        private Image i;

        public Goal(int xpos, int ypos){
            x = xpos;
            y = ypos;
            width = 30;
            height = 30;
            i = Toolkit.getDefaultToolkit().getImage("peach.gif");
        }

        public void draw(Graphics g){
            g.drawImage(i, x, y - 20, null);
        }

        public boolean contacts(Mario m){
            if (m.getx() + m.getWidth() >= x
                &&  m.getx() <= x + width
                &&  m.gety() + m.getHeight() >= y
                &&  m.gety() <= y + height){
                return true;
            }
            return false;
        }
}
