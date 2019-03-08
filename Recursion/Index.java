import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index{

	public static void main(String[] args){
		JFrame GUI = new JFrame("Recursion");
		GUI.setSize(1000,1000);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = GUI.getContentPane();
		pane.setLayout(new GridLayout(0,1));
		Font f = new Font("TimesRoman", Font.PLAIN, 25);
		UIManager.put("OptionPane.messageFont", f);
        	UIManager.put("OptionPane.buttonFont", f);

		JPanel TwoInputs = new JPanel(new GridLayout(0,3));
		JTextArea[] twoinputboxes = new JTextArea[2];
		for (int i = 0; i < 2; i++){
			twoinputboxes[i] = new JTextArea();
			twoinputboxes[i].setFont(f);
			twoinputboxes[i].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		JButton[] twobut = new JButton[2];
		twobut[0] = new JButton("Exponent");
		twobut[0].setFont(f);
		TwoInputs.add(twobut[0]);
		TwoInputs.add(twoinputboxes[0]);
		TwoInputs.add(twoinputboxes[1]);
		pane.add(TwoInputs);

		JPanel OneInput = new JPanel(new GridLayout(0,2));
		JTextArea[] oneinputboxes = new JTextArea[6];
		for (int i = 0; i < 6; i++){
			oneinputboxes[i] = new JTextArea();
			oneinputboxes[i].setFont(f);
			oneinputboxes[i].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		JButton[] onebut = new JButton[6];
		onebut[0] = new JButton("Fibbonacci");
		onebut[0].setFont(f);
		onebut[1] = new JButton("Backwards");
		onebut[1].setFont(f);
		onebut[2] = new JButton("Palindrome");
		onebut[2].setFont(f);
		onebut[3] = new JButton("Binary to Base 10");
		onebut[3].setFont(f);
		onebut[4] = new JButton("Summation");
		onebut[4].setFont(f);
		onebut[5] = new JButton("Base 10 to Binary");
		onebut[5].setFont(f);
		for (int i = 0; i < 6; i++){
			OneInput.add(onebut[i]);
			OneInput.add(oneinputboxes[i]);
		}	
		pane.add(OneInput);
		
		twobut[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int base = Integer.parseInt(twoinputboxes[0].getText());	
				int power = Integer.parseInt(twoinputboxes[1].getText());
				JOptionPane.showMessageDialog(null, "Recursive: " + Integer.toString(Recursion.exponent(base, power)));
				JOptionPane.showMessageDialog(null, "Iterative: " + Integer.toString(Recursion.iterexponent(base, power)));
			}
		});
	
		onebut[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int base = Integer.parseInt(oneinputboxes[4].getText());	
				JOptionPane.showMessageDialog(null, "Recursive: " + Integer.toString(Recursion.sum(base)));
				JOptionPane.showMessageDialog(null, "Iterative: " + Integer.toString(Recursion.itersum(base)));
			}
		});

		onebut[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = Integer.parseInt(oneinputboxes[0].getText());	
				JOptionPane.showMessageDialog(null, "Recursive: " + Integer.toString(Recursion.fib(index)));
				JOptionPane.showMessageDialog(null, "Iterative: " + Integer.toString(Recursion.iterfib(index)));
			}
		});
		
		onebut[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String index = oneinputboxes[1].getText();	
				JOptionPane.showMessageDialog(null, Recursion.backwards(index));
			}
		});
		
		onebut[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String index = oneinputboxes[2].getText();	
				JOptionPane.showMessageDialog(null, Recursion.palindrome(index));
			}
		});

		onebut[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String index = oneinputboxes[3].getText();	
				JOptionPane.showMessageDialog(null, Recursion.binary(index));
			}
		});

		onebut[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = Integer.parseInt(oneinputboxes[5].getText());	
				JOptionPane.showMessageDialog(null, Recursion.toBinary(index));
			}
		});

		GUI.setVisible(true);

	}

}
