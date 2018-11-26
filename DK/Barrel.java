import javax.swing.*;
import java.awt.*;

public class Barrel{

	private int x, y, width, height;
	private Image i;
	private int direction;

	public Barrel(int xpos, int ypos){
		x = xpos;
		y = ypos;
		direction = 1;
		width = 20;
		height = 20;
		i = Toolkit.getDefaultToolkit().getImage("barrel.png");
	}
	
	public void move(int dx, int dy){
		x += dx;
		y += dy;
	}

	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.drawImage(i, x, y - 20, null);
	}
	
	public int getdir(){
		return direction;
	}

	public void setdir(int dir){
		direction = dir;
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
		&&  m.gety() <= y + height - 10){
			return true;
		}
		return false;
	}

}
