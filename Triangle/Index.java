import javax.swing.*;
import java.awt.*;

public class Index{

    public static void main(String[] args){
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Triangles");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setSize(500,500);
        Container pane = theGUI.getContentPane();
        Canvas panel = new Canvas();
        panel.setSize(500,500);
        pane.add(panel);
        theGUI.setVisible(true);
    }

}