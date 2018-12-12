import java.io.*;
import java.util.Scanner;

public class Books{

	private Book[] myB;
	private int numB;

	public Books(File f) throws IOException{
		myB = new Book[55];
		numB = 0;
		Scanner r = new Scanner(f);
		while (r.hasNext()){
			String line = r.nextLine();
			String[] data = line.split(",");
			myB[numB] = new Book(data[1], data[0]);
			numB++;
		}
		r.close();
	}

	public Book[] getBook(){
		return myB;
	}

	public String toString(){
		String str = "";
		for (int i = 0; i < numB; i++){
			str += myB[i].toString() + "\n";
		}	
		return str;
	}
}
