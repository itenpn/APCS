import java.io.*;
import java.util.Scanner;

public class Readers{

	private Reader[] myR;
	private int numR;

	public Readers(File f) throws IOException{	
		myR = new Reader[100];
		Scanner r = new Scanner(f);
		while (r.hasNext()){
			String name = r.nextLine();
			String[] scores = r.nextLine().split(" ");
			int[] s = new int[100];
			int si = 0;
			for (String i : scores){
				s[si] = Integer.parseInt(i);
				si++;
			}	
			myR[numR] = new Reader(name, s);
			numR++;
		}
		r.close();
	}

	public Reader[] getReaders(){
		return myR;
	}

	public Reader getReader(String name){
		for (Reader test : myR){
			if (test.getName().equals(name))
				return test;
		}
		return new Reader();
	}

}
