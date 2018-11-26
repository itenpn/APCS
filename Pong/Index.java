import javax.swing.*;
import java.awt.*;

public class Index{

    public static void main(String[] args){
        JFrame GUI = new JFrame();
        GUI.setTitle("Pong");
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setSize(1000,500);
        Container pane = GUI.getContentPane();
        pane.add(new MyPanel());
        GUI.setVisible(true);
    }
    
}