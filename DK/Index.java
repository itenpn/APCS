import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Index{

	public static void main(String[] args) throws IOException{
      UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
      UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 30));
    JFrame GUI = new JFrame("Donkey Kong");
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setSize(500, 1000);
    JOptionPane.showMessageDialog(null, "Welcome to Donkey Kong!");
		Game test = new Game();
		Container pane = GUI.getContentPane();
		pane.add(test);
		GUI.setVisible(true);
	}

}
