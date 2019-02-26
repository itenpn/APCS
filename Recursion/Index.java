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
		JTextArea[] twoinputboxes = new JTextArea[4];
		for (int i = 0; i < 4; i++){
			twoinputboxes[i] = new JTextArea();
			twoinputboxes[i].setFont(f);
			twoinputboxes[i].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		JButton[] twobut = new JButton[2];
		twobut[0] = new JButton("Exponent");
		twobut[0].setFont(f);
		twobut[1] = new JButton("Summation");
		twobut[1].setFont(f);
		TwoInputs.add(twobut[0]);
		TwoInputs.add(twoinputboxes[0]);
		TwoInputs.add(twoinputboxes[1]);
		TwoInputs.add(twobut[1]);
		TwoInputs.add(twoinputboxes[2]);
		TwoInputs.add(twoinputboxes[3]);
		pane.add(TwoInputs);

		JPanel OneInput = new JPanel(new GridLayout(0,2));
		JTextArea[] oneinputboxes = new JTextArea[3];
		for (int i = 0; i < 3; i++){
			oneinputboxes[i] = new JTextArea();
			oneinputboxes[i].setFont(f);
			oneinputboxes[i].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		JButton[] onebut = new JButton[3];
		onebut[0] = new JButton("Fibbonacci");
		onebut[0].setFont(f);
		onebut[1] = new JButton("Backwards");
		onebut[1].setFont(f);
		onebut[2] = new JButton("Palindrome");
		onebut[2].setFont(f);
		for (int i = 0; i < 3; i++){
			OneInput.add(onebut[i]);
			OneInput.add(oneinputboxes[i]);
		}	
		pane.add(OneInput);
		
		twobut[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int base = Integer.parseInt(twoinputboxes[0].getText());	
				int power = Integer.parseInt(twoinputboxes[1].getText());
				JOptionPane.showMessageDialog(null, Recursion.exponent(base, power));
			}
		});
	
		twobut[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int base = Integer.parseInt(twoinputboxes[2].getText());	
				int power = Integer.parseInt(twoinputboxes[3].getText());
				JOptionPane.showMessageDialog(null, Recursion.sum(base, power));
			}
		});

		onebut[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = Integer.parseInt(oneinputboxes[0].getText());	
				JOptionPane.showMessageDialog(null, Recursion.fib(index));
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
		GUI.setVisible(true);

	}

}
