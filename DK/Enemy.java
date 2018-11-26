import javax.swing.*;
import java.awt.*;

public class Enemy{
	private int x, y, height, width;
	private Image i;

	public Enemy(){
		x = 10;
		y = 10;
		width = 100;
		height = 100;
		i = Toolkit.getDefaultToolkit().getImage("dk.gif");
	}

	public void draw(Graphics g){
		g.drawImage(i, x, y, null);
	}	
}
