import java.io.*;
import java.util.Scanner;


public class Index{
	
	public static void main(String[] args) throws IOException{
		Books b = new Books(new File("books.txt"));
		Readers r = new Readers(new File("readerratings.txt"));
		Scanner read = new Scanner(System.in);
		System.out.println("Enter User");
		String SI = read.nextLine();
		Reader test = r.getReader(SI);
		read.close();
	}
}
