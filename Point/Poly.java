import java.awt.*;
import javax.swing.*;

public class Poly {

    public static void main(String[] args){
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Coordinates");
        theGUI.setSize(500,500);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        CreatePoint panel = new CreatePoint(new PolyPoint(0,0));
        pane.add(panel);
        theGUI.setVisible(true);
    }


}