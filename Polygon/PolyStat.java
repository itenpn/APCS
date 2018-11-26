import javax.swing.*;
import java.awt.*;

public class PolyStat extends JPanel{
    
    private Polygon x;

    PolyStat(Canvas z){
        x = z.getP();
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.drawString(x.toString(), 10, 10);
    }

}