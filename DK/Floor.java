import javax.swing.*;
import java.awt.*;

public class Floor{

	private int x1, y1, width, height;

	public Floor(int xpos1, int ypos1, int xpos2, int ypos2){
		x1 = xpos1;
		y1 = ypos1;
		width = xpos2;
		height = ypos2;	
	}

	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x1, y1,width, height);
	}

	public boolean contact(Mario m){
		if (m.gety() + m.getHeight() >= y1
		&&  m.gety() + m.getHeight() <= y1 + height
		&&  m.getx() + m.getWidth() >= x1
		&&  m.getx() + m.getWidth() <= x1 + width){
			return true;
		}
		return false;
	}

	public boolean contact(Barrel b){
		if (b.gety() + b.getHeight() >= y1
		&&  b.gety() + b.getHeight() <= y1 + height
		&&  b.getx() + b.getWidth() >= x1
		&&  b.getx() + b.getWidth() <= x1 + width){
			return true;
		}
		return false;
	}
}
