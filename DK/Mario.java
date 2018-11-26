import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Mario{

	private int x, y, width, height;
	private Image right, left;

	public Mario(int xpos, int ypos){
		x = xpos;
		y = ypos;
		width = 10;
		height = 43;
		left = Toolkit.getDefaultToolkit().getImage("marioleft.gif");
		right = Toolkit.getDefaultToolkit().getImage("mario.gif");
	}	
	
	public void move(int dx, int dy){
		x += dx;
		y += dy;
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

	public int getHeight(){
		return height;
	}

	public void draw(Graphics g, int mflag){
		if (mflag == 1){
			g.drawImage(right, x, y, null);
		}
		else {
			g.drawImage(left, x, y, null);
		}
	}

}
