import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index{
	
	public static void main(String[] args) throws IOException{
		Books b = new Books(new File("books.txt"));
		Readers r = new Readers(new File("readerratings.txt"));
		MyPanel output = new MyPanel(b,r);
		JFrame GUI = new JFrame("Book Recommendation");
		GUI.setSize(1000,500);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = GUI.getContentPane();
		pane.setLayout(new GridLayout(2,0));
		String[] name = new String[86];
		int pos = 0;
		for (Reader i : r.getReaders()){
			name[pos++] = i.getName();
		}
		JList<String> readlist = new JList<String>(name);
		readlist.addMouseListener( new MouseListener(){
			public void mouseClicked(MouseEvent e){
				int index = readlist.locationToIndex(e.getPoint());
				Reader CurrentReader = r.getReaders()[index];
				System.out.println(r.popular(CurrentReader, b).toString());
				System.out.println(r.matchReader(CurrentReader, b).toString());
				output.draw(CurrentReader); }
			public void mouseExited(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		JPanel test = new JPanel();
		test.setPreferredSize(new Dimension(250, 150));
		JScrollPane scrollPane = new JScrollPane(readlist);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(200,100));
		test.add(scrollPane);
		pane.add(test);
		pane.add(output);	
		GUI.setVisible(true);
	}

}
