import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel{

	private Books myb;
	private Readers myr;
	private Reader CurrentReader;

	public MyPanel(Books b, Readers r){
		myb = b;
		myr = r;
		CurrentReader = myr.getReaders()[0];
	}

	public void draw(Reader si){
		CurrentReader = si;
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Book pop = myr.popular(CurrentReader, myb);
		Book rec = myr.matchReader(CurrentReader, myb);
		g.setFont(new Font("Times Roman", Font.PLAIN, 50));
		g.drawString("Popular", 10 , 50);
		g.drawString("Custom", 900, 50);
		pop.draw(g, 0, 100);
		rec.draw(g, 900, 100);	
	}

}
