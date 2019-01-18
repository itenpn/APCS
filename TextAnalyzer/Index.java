import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Index{

	public static void main(String[] args) throws IOException{
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
        	UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 30));
		JFrame GUI = new JFrame("Text Analyzer");
		GUI.setSize(500,500);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = GUI.getContentPane();
		pane.setLayout(new GridLayout(0,1));
		JButton OpenBut = new JButton("Open File");
		JButton TextBut = new JButton("Without File");
		JPanel ButtonPanel = new JPanel(new GridLayout(1,2));
		JTextArea text = new JTextArea();
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		OpenBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					text.setText("");
					String file = JOptionPane.showInputDialog("Filename?");
					TextAnalyzer ta = new TextAnalyzer(new File(file));
					String output = String.format("Flesch: %d\n Flesch Grade: %s\n Smog: %f\n%s",
							ta.flesch(),
							ta.fleschgrade(),
							ta.smog(),
							ta.toString());	
					Scanner r = new Scanner(new File(file));
					while (r.hasNext()){
						String line = r.nextLine();
						text.setText(text.getText() + "\n" + line);
					}
					r.close();
					JOptionPane.showMessageDialog(null, output);
				}catch(Exception ex){System.out.println("failure");}	
			}
		});	
		TextBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				TextAnalyzer ta = new TextAnalyzer(text.getText());
				String output = String.format("Flesch: %d\n Flesch Grade: %s\n Smog: %f\n%s",
						ta.flesch(),
						ta.fleschgrade(),
						ta.smog(),
						ta.toString());	
				JOptionPane.showMessageDialog(null, output);
			}
		});
		text.setFont(new Font("Arial", Font.BOLD, 30));
		OpenBut.setFont(new Font("Arial", Font.BOLD, 30));
		TextBut.setFont(new Font("Arial", Font.BOLD, 30));
		ButtonPanel.add(OpenBut);
		ButtonPanel.add(TextBut);
		ButtonPanel.setPreferredSize(new Dimension(100,100));
		pane.add(ButtonPanel);
		pane.add(text);
		GUI.setVisible(true);
	}

}
