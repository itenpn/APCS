import javax.swing.*;
import java.awt.*;

public class Book{

	private String title, author;
	
	public Book(String t, String a){
		title = t;
		author = a;
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public String toString(){
		return author + ", " + title;
	}

	public void draw(Graphics g, int x, int y){
		String changedTitle = "";
		for (int i = 0; i < title.length(); i++){
			if (title.charAt(i) == '\'') {changedTitle += "_";}
			else{changedTitle += title.charAt(i);}	
		}
		if (changedTitle.equals("The Hitchhiker_s Guide To The Galaxy")){
			changedTitle = "hhg";
		}
		else if (changedTitle.equals("Nineteen Eighty-Four (1984)")){
			changedTitle = "1984";
		}
		String path = "BookCovers/" + changedTitle + ".jpg";
		Image cover = Toolkit.getDefaultToolkit().getImage(path);
		cover.getScaledInstance(50, 100, Image.SCALE_DEFAULT);
		g.drawImage(cover, x, y, null);
	}

}
