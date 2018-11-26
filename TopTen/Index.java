import java.io.*;
import java.util.Scanner;

public class Index{

    public static void main(String[] args) throws IOException{
        TopTen test = new TopTen(new File("data.txt"));
        System.out.println(test.toString());
	Scanner r = new Scanner(System.in);
	System.out.println("Enter name of new winner");
	String name = r.nextLine();
	System.out.println("Enter score");
	int score = r.nextInt();
	Player p = new Player(name, score);
	test.checkScore(p);
	System.out.println(test.toString());
    }

}
