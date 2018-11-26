import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.Scanner;
import java.io.*;

public class Index{

    public static void main(String[] args) throws IOException{
        int flag = 0;
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Polygon");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setSize(500,500);
        Container pane = theGUI.getContentPane();
        pane.setLayout(new CardLayout());
        Canvas panel = new Canvas();
        panel.setSize(500,500);
        String option = JOptionPane.showInputDialog("Open file or new file?");
        if (option.equals("open")){
            File f = new File("data.txt");
            Scanner r = new Scanner(f);
            Point[] p = new Point[100];
            int nump = 0;
            while (r.hasNext()){
                double x = r.nextDouble();
                double y = r.nextDouble();
                p[nump] = new Point(x,y);
                nump++;
                panel.setP(p, nump);
            }
            r.close();
        }
        pane.add(panel);
        theGUI.setVisible(true);
    }



}