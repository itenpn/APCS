import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index{

	public static JList<Student> stulist;
	public static JScrollPane stuscroll;
	public static int index;

	public static void main(String[] args){
		Font f = new Font("TimesRoman", Font.PLAIN, 25);
		District x = new District();
		try{
			x.Save();
		}catch(Exception e){
			System.out.println("Failure");
		}
		JFrame GUI = new JFrame("District");
		GUI.setSize(1000,1000);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = GUI.getContentPane();
		pane.setLayout(new GridLayout(2, 2));
		
		
		JPanel stupanel = new JPanel();
		Student[] arrstu = new Student[x.getStudents().size()];
		DefaultListModel<Student> model = new DefaultListModel<Student>();
		for (int i = 0; i < x.getStudents().size(); i++)
			model.add(i, x.getStudents().get(i));
		stulist = new JList<Student>(model);
		stulist.setFont(f);
		stuscroll = new JScrollPane(stulist);
		stuscroll.setFont(f);
		stuscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		stupanel.add(stuscroll);
		pane.add(stupanel);

		
		JPanel datapanel = new JPanel();
		JTextArea dataout = new JTextArea();
		dataout.setFont(f);
		datapanel.add(dataout);
		pane.add(datapanel);

		JPanel butpanel = new JPanel();
		JButton addstu = new JButton("add");
		JButton delstu = new JButton("delete");
		JButton chgstu = new JButton("edit");
		JButton searchstu = new JButton("search");
		addstu.setFont(f);
		delstu.setFont(f);
		chgstu.setFont(f);
		searchstu.setFont(f);
		butpanel.add(addstu);
		butpanel.add(delstu);
		butpanel.add(chgstu);
		butpanel.add(searchstu);
		pane.add(butpanel);

		JPanel totalpanel = new JPanel();
		JTextArea totallabel = new JTextArea();
		totallabel.setText(String.format("Total Fees: %.2f\nTotal Students: %d", 
					Student.totalfees, Student.totalStu));
		totallabel.setFont(f);
		totalpanel.add(totallabel);
		pane.add(totalpanel);

		stulist.addMouseListener( new MouseListener(){
			public void mouseClicked(MouseEvent e){
				index = stulist.locationToIndex(e.getPoint());
				dataout.setText(x.getStudents().get(index).output());	
				datapanel.revalidate();
				datapanel.repaint();
			}
			public void mouseExited(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});

		addstu.addMouseListener( new MouseListener(){
			public void mouseClicked(MouseEvent e){
				String fname = JOptionPane.showInputDialog("What is the first name?");
				String lname = JOptionPane.showInputDialog("What is the last name?");
				double fee = Double.parseDouble(JOptionPane.showInputDialog("What is their current fee?"));
				int [] score = new int[3];
				for (int i = 0; i < 3; i++){
					String out = String.format("What is score #%d", i + 1);
					score[i] = Integer.parseInt(JOptionPane.showInputDialog(out));
				}
				int grade = Integer.parseInt(JOptionPane.showInputDialog("What is the grade?"));
				if (grade >= 9){
					int apclass = Integer.parseInt(JOptionPane.showInputDialog("How many AP Classes?"));
					x.addStu(new HSStu(grade, apclass, fname, lname, fee, score));	
				}
				else if (grade >= 7){
					String[] t = new String[5];
					t[0] = "Gifford Dinos";
					t[1] = "Kummer Tuners";
					t[2] = "Fightin' Itens";
					t[3] = "Sri's Trees";
					t[4] = "House of Kim";
					int option = JOptionPane.showOptionDialog(null, 
						"What team are they on?","Team",
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, 
						null, t, t[0]);
					x.addStu(new MSStu(grade, t[option], fname, lname, fee, score)); 
				}
				else if (grade >= 4){
					String[] t = new String[2];
					t[0] = "William Foster";
					t[1] = "John Schmidt";
					int option = JOptionPane.showOptionDialog(null, 
						"What building are they in?","Building",
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, 
						null, t, t[0]);
					x.addStu(new ISStu(grade, t[option], fname, lname, fee, score)); 
				}
				else{
					String[] t = new String[3];
					t[0] = "Painting";
					t[1] = "Math Problems";
					t[2] = "Science Fair";
					int option = JOptionPane.showOptionDialog(null, 
						"What project are they doing?","Project",
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, 
						null, t, t[0]);
					x.addStu(new ESStu(grade, t[option], fname, lname, fee, score)); 
				}
				model.add(x.getStudents().size() - 1, x.getStudents().get(x.getStudents().size() -1));
				stulist.revalidate();
				stulist.repaint();
				stuscroll.revalidate();
				stuscroll.repaint();
				stupanel.revalidate();
				stupanel.repaint();
				totallabel.setText(String.format("Total Fees: %.2f\nTotal Students: %d", 
					Student.totalfees, Student.totalStu));
				totalpanel.revalidate();
				totalpanel.repaint();
				try{
				x.Save();
				}catch(IOException ev){}
			}
			public void mouseExited(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});

		delstu.addMouseListener( new MouseListener(){
			public void mouseClicked(MouseEvent e){
				x.removeStu(index);
				model.remove(index);
				stulist.revalidate();
				stulist.repaint();
				stuscroll.revalidate();
				stuscroll.repaint();
				stupanel.revalidate();
				stupanel.repaint();
				totallabel.setText(String.format("Total Fees: %.2f\nTotal Students: %d", 
					Student.totalfees, Student.totalStu));
				totalpanel.revalidate();
				totalpanel.repaint();
				try{
				x.Save();
				}catch(IOException ev){}
			}
			public void mouseExited(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});

		chgstu.addMouseListener( new MouseListener(){
			public void mouseClicked(MouseEvent e){
				String fname = JOptionPane.showInputDialog("What is the first name?");
				String lname = JOptionPane.showInputDialog("What is the last name?");
				double fee = Double.parseDouble(JOptionPane.showInputDialog("What is their current fee?"));
				int idnum = x.getStudents().get(index).getID();
				x.removeStu(index);
				int [] score = new int[3];
				for (int i = 0; i < 3; i++){
					String out = String.format("What is score #%d", i + 1);
					score[i] = Integer.parseInt(JOptionPane.showInputDialog(out));
				}
				int grade = Integer.parseInt(JOptionPane.showInputDialog("What is the grade?"));
				if (grade >= 9){
					int apclass = Integer.parseInt(JOptionPane.showInputDialog("How many AP Classes?"));
					x.addStu(new HSStu(grade, apclass, fname, lname, fee, score));
					x.getStudents().get(x.getStudents().size() -1).setID(idnum);	
				}
				else if (grade >= 7){
					String[] t = new String[5];
					t[0] = "Gifford Dinos";
					t[1] = "Kummer Tuners";
					t[2] = "Fightin' Itens";
					t[3] = "Sri's Trees";
					t[4] = "House of Kim";
					int option = JOptionPane.showOptionDialog(null, 
						"What team are they on?","Team",
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, 
						null, t, t[0]);
					x.addStu(new MSStu(grade, t[option], fname, lname, fee, score)); 	
					x.getStudents().get(x.getStudents().size() -1).setID(idnum);	
				}
				else if (grade >= 4){
					String[] t = new String[2];
					t[0] = "William Foster";
					t[1] = "John Schmidt";
					int option = JOptionPane.showOptionDialog(null, 
						"What building are they in?","Building",
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, 
						null, t, t[0]);
					x.addStu(new ISStu(grade, t[option], fname, lname, fee, score)); 
					x.getStudents().get(x.getStudents().size() -1).setID(idnum);	
				}
				else{
					String[] t = new String[3];
					t[0] = "Painting";
					t[1] = "Math Problems";
					t[2] = "Science Fair";
					int option = JOptionPane.showOptionDialog(null, 
						"What project are they doing?","Project",
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, 
						null, t, t[0]);
					x.addStu(new ESStu(grade, t[option], fname, lname, fee, score)); 	
					x.getStudents().get(x.getStudents().size() -1).setID(idnum);	
				}
				model.remove(index);
				model.add(x.getStudents().size() -1, x.getStudents().get(x.getStudents().size() -1));
				stulist.revalidate();
				stulist.repaint();
				stuscroll.revalidate();
				stuscroll.repaint();
				stupanel.revalidate();
				stupanel.repaint();
				totallabel.setText(String.format("Total Fees: %.2f\nTotal Students: %d", 
					Student.totalfees, Student.totalStu));
				totalpanel.revalidate();
				totalpanel.repaint();
				try{
				x.Save();
				}catch(IOException ev){}
			}
			public void mouseExited(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		
		searchstu.addMouseListener( new MouseListener(){
			public void mouseClicked(MouseEvent e){
				int id = Integer.parseInt(JOptionPane.showInputDialog("Which ID?"));
				index = x.search(id);
				if (index < 0)
					JOptionPane.showMessageDialog(null, "invalid id");
				else{
					dataout.setText(x.getStudents().get(index).output());	
					datapanel.revalidate();
					datapanel.repaint();
				}	
				stulist.revalidate();
				stulist.repaint();
				stuscroll.revalidate();
				stuscroll.repaint();
				stupanel.revalidate();
				stupanel.repaint();
				totallabel.setText(String.format("Total Fees: %.2f\nTotal Students: %d", 
					Student.totalfees, Student.totalStu));
				totalpanel.revalidate();
				totalpanel.repaint();
			}
			public void mouseExited(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});

		GUI.setVisible(true);
	}

}
