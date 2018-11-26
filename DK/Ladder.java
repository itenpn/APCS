import javax.swing.*;
import java.awt.*;

public class Ladder{

	private int x, y, width, height;
	private Image i;

	public Ladder(int xpos, int ypos){
		x = xpos;
		y = ypos;
		width = 140;
		height = 100;
		i = Toolkit.getDefaultToolkit().getImage("ladder.png");
	}

	public void draw(Graphics g){
		g.drawImage(i, x, y, null);
	}
	
	public int getx(){
		return x;
	}

	public int gety(){
		return y;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean contacts(Mario m){
		if (m.getx() + m.getWidth() >= x
		&&  m.getx() <= x + width
		&&  m.gety() + m.getHeight() >= y
		&&  m.gety() <= y + height){
			return true;
		}
		return false;
	}

}
