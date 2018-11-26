import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Index{

	public static void main(String[] args){
		/*Initial GUI information*/
		JFrame GUI = new JFrame("Matrix");
		GUI.setSize(1000,1300);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = GUI.getContentPane();
		pane.setLayout(new GridLayout(0,1, 0, 100));
		
		/*Edit the Matrix*/
		JPanel EditMatrix = new JPanel(new GridLayout(0, 2, 100, 50));
		EditMatrix.add(new MyJLabel("Rows"));
		EditMatrix.add(new MyJLabel("Columns"));
		MyJTextArea trow1 = new MyJTextArea();
		MyJTextArea trow2 = new MyJTextArea();
		MyJTextArea tcol1 = new MyJTextArea();
		MyJTextArea tcol2 = new MyJTextArea();
		trow1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		trow2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		tcol2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		tcol1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		EditMatrix.add(trow1);
		EditMatrix.add(tcol1);
		EditMatrix.add(trow2);
		EditMatrix.add(tcol2);
		MyJButton m1 = new MyJButton("Edit Matrix 1");
		MyJButton m2 = new MyJButton("Edit Matrix 2");
		EditMatrix.add(m1);
		EditMatrix.add(m2);
		pane.add(EditMatrix);

		/*GUI Representation of Matrix*/
		JPanel TotalMatrix = new JPanel(new GridLayout(0, 2, 100, 100));
		JPanel Matrix1 = new JPanel();
		JPanel Matrix2 = new JPanel();
		ArrayList<MyJTextArea> t1 = new ArrayList<MyJTextArea>();
		ArrayList<MyJTextArea> t2 = new ArrayList<MyJTextArea>();
		ArrayList<Integer> val1 = new ArrayList<Integer>();
		val1.add(0);
		val1.add(0);
		ArrayList<Integer> val2 = new ArrayList<Integer>();
		val2.add(0);
		val2.add(0);
		TotalMatrix.add(Matrix1);
		TotalMatrix.add(Matrix2);
		pane.add(TotalMatrix);

		/*Operation Selector*/
		JPanel Operations = new JPanel(new GridLayout(0, 6, 100, 100));
		MyJButton add = new MyJButton("+");
		MyJButton sub = new MyJButton("-");
		MyJButton mult = new MyJButton("*");
		MyJButton div = new MyJButton("/");
		MyJButton inv = new MyJButton("^-1");
		MyJButton det = new MyJButton("det");
		Operations.add(add);
		Operations.add(sub);
		Operations.add(mult);
		Operations.add(div);
		Operations.add(inv);
		Operations.add(det);
		pane.add(Operations);

		/*Answer Matrix*/
		JPanel AnsMatrix = new JPanel();
		pane.add(AnsMatrix);
		
		/*Button Functionality*/
		m1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int row = Integer.parseInt(trow1.getText());
				int col = Integer.parseInt(tcol1.getText());
				Matrix1.removeAll();
				Matrix1.setLayout(new GridLayout(row, col, 10, 10));
				for (int i = 0; i < row * col; i++){
					if (i >= t1.size())
						t1.add(new MyJTextArea());
					else
						t1.set(i, new MyJTextArea());
					Matrix1.add(t1.get(i));
				}	
				val1.set(0, row);
				val1.set(1, col);
				TotalMatrix.revalidate();
				TotalMatrix.repaint();
			}
		});

		m2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int row = Integer.parseInt(trow2.getText());
				int col = Integer.parseInt(tcol2.getText());
				Matrix2.removeAll();
				Matrix2.setLayout(new GridLayout(row, col, 10, 10));
				for (int i = 0; i < row * col; i++){
					if (i >= t2.size())
						t2.add(new MyJTextArea());
					else
						t2.set(i, new MyJTextArea());
					t2.add(new MyJTextArea());
					Matrix2.add(t2.get(i));
				}
				val2.set(0, row);
				val2.set(1, col);
				TotalMatrix.revalidate();
				TotalMatrix.repaint();
			}
		});

		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Matrix m1 = getMatrix(t1, val1.get(0), val1.get(1));
				Matrix m2 = getMatrix(t2, val2.get(0), val2.get(1));
				Matrix m = m1.add(m2);
				AnsMatrix.removeAll();
				if (m.getRows() > 0){
				AnsMatrix.setLayout(new GridLayout(m.getRows(), m.getColumns(), 10, 10));
				for(int i = 0; i < m.getRows(); i++){
					for (int j = 0; j < m.getColumns(); j++){
						String str = Double.toString(m.getMatrix()[i][j]);
						MyJTextArea out = new MyJTextArea();
						out.setText(str);
						AnsMatrix.add(out);
					}
				}
				}
				else{
					AnsMatrix.setLayout(new GridLayout(1, 1));
					AnsMatrix.add(new JLabel("Invalid Input"));
				}
				AnsMatrix.revalidate();
				AnsMatrix.repaint();		
			}
		});

		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Matrix m1 = getMatrix(t1, val1.get(0), val1.get(1));
				Matrix m2 = getMatrix(t2, val2.get(0), val2.get(1));
				Matrix m = m1.sub(m2);
				AnsMatrix.removeAll();
				if (m.getRows() > 0){
				AnsMatrix.setLayout(new GridLayout(m.getRows(), m.getColumns(), 10, 10));
				for(int i = 0; i < m.getRows(); i++){
					for (int j = 0; j < m.getColumns(); j++){
						String str = Double.toString(m.getMatrix()[i][j]);
						MyJTextArea out = new MyJTextArea();
						out.setText(str);
						AnsMatrix.add(out);
					}
				}
				}
				else{
					AnsMatrix.setLayout(new GridLayout(1,1));
					AnsMatrix.add(new JLabel("Invalid Input"));
				}
					AnsMatrix.revalidate();
				AnsMatrix.repaint();	
			}
		});
		
		mult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Matrix m1 = getMatrix(t1, val1.get(0), val1.get(1));
				Matrix m2 = getMatrix(t2, val2.get(0), val2.get(1));
				Matrix m = m1.mult(m2);
				AnsMatrix.removeAll();
				if (m.getRows() > 0){
				AnsMatrix.setLayout(new GridLayout(m.getRows(), m.getColumns(), 10, 10));
				for(int i = 0; i < m.getRows(); i++){
					for (int j = 0; j < m.getColumns(); j++){
						String str = String.format("%.3f", m.getMatrix()[i][j]);
						MyJTextArea out = new MyJTextArea();
						out.setText(str);
						AnsMatrix.add(out);
					}
				}
				}

				else{
					AnsMatrix.setLayout(new GridLayout(1,1));
					AnsMatrix.add(new JLabel("Invalid Input"));
				}
					AnsMatrix.revalidate();
				AnsMatrix.repaint();	
			}
		});

		div.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Matrix m1 = getMatrix(t1, val1.get(0), val1.get(1));
				Matrix m2 = getMatrix(t2, val2.get(0), val2.get(1));
				Matrix m = m1.div(m2);
				AnsMatrix.removeAll();
				if (m.getRows() > 0){
				AnsMatrix.setLayout(new GridLayout(m.getRows(), m.getColumns(), 10, 10));
				for(int i = 0; i < m.getRows(); i++){
					for (int j = 0; j < m.getColumns(); j++){
						String str = String.format("%.3f",m.getMatrix()[i][j]);
						MyJTextArea out = new MyJTextArea();
						out.setText(str);
						AnsMatrix.add(out);
					}
				}
				}

				else{
					AnsMatrix.setLayout(new GridLayout(1,1));
					AnsMatrix.add(new JLabel("Invalid Input"));
				}
					AnsMatrix.revalidate();
				AnsMatrix.repaint();	
			}
		});
		
		inv.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Matrix m1 = getMatrix(t1, val1.get(0), val1.get(1));
				Matrix m = m1.inverse();
				AnsMatrix.removeAll();
				if (m.getRows() > 0){
				AnsMatrix.setLayout(new GridLayout(m.getRows(), m.getColumns(), 10, 10));
				for(int i = 0; i < m.getRows(); i++){
					for (int j = 0; j < m.getColumns(); j++){
						String str = String.format("%.3f", m.getMatrix()[i][j]);
						MyJTextArea out = new MyJTextArea();
						out.setText(str);
						AnsMatrix.add(out);
					}
				}
				}

				else{
					AnsMatrix.setLayout(new GridLayout(1,1));
					AnsMatrix.add(new JLabel("Invalid Input"));
				}
					AnsMatrix.revalidate();
				AnsMatrix.repaint();	
			}
		});

		det.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Matrix m = getMatrix(t1, val1.get(0), val1.get(1));
				AnsMatrix.removeAll();
				AnsMatrix.setLayout(new GridLayout(1, 1));
				MyJTextArea out = new MyJTextArea();
				out.setText(String.format("%.3f", m.det()));
				AnsMatrix.add(out);
				AnsMatrix.revalidate();
				AnsMatrix.repaint();		
			}
		});

		GUI.setVisible(true);
	}

	private static Matrix getMatrix(ArrayList<MyJTextArea> j, int row, int col){
		double[][] x = new double[row + 1][col + 1];
		int p = 0;
		int q = 0;
		for (int i = 0; i < row * col; i++){
			x[p][q] = Double.parseDouble(j.get(i).getText());
			q++;
			if (q == col){
				q = 0;
				p++;
			}
		}
		return new Matrix(x, row, col);
	}

	private static class MyJLabel extends JLabel{
		MyJLabel(String s){
			setText(s);
			setFont(new Font("TimesRoman", Font.PLAIN, 30));
		}
	}

	private static class MyJTextArea extends JTextArea{
		MyJTextArea(){
			setFont(new Font("TimesRoman", Font.PLAIN, 50));
		}
	}

	private static class MyJButton extends JButton{
		MyJButton(String s){
			setText(s);
			setFont(new Font("TimesRoman", Font.PLAIN, 20));
		}
	}
}
