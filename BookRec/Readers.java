import java.io.*;
import java.util.*;

public class Readers{

	private Reader[] myR;
	private int numR;

	public Readers(File f) throws IOException{	
		myR = new Reader[86];
		Scanner r = new Scanner(f);
		while (r.hasNext()){
			String name = r.nextLine();
			String[] scores = r.nextLine().split(" ");
			int[] s = new int[86];
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
	
	public Book popular(Reader SI, Books b){
		int numbooks = 0;
		for (Book i : b.getBook())
			numbooks++;
		int high = 0;
		int current = 0;
		for (int pos = 0; pos < numbooks; pos++){
			int sum = 0;
			for (Reader test : myR){
				if (SI.getScore()[pos] == 0)
					sum += test.getScore()[pos];
			}
			if (sum > high){
				high = sum;
				current = pos;
			}
		}
		return b.getBook()[current];
	}

	public Book methodB(Reader r, Books b){
		return b.getBook()[0];
	}

	public Book matchReader(Reader r, Books b){
		ArrayList<Reader> options = new ArrayList<Reader>();
		for (Reader i : myR){
			/*
			 * Checks if user has similar habits to other users
			 * For example
			 * If user1 hates reading and the test user hates reading
			 * then any books user1 likes might have more merit!
			 */
			if (i.sum() <= r.sum() + 20 && i.sum() >= r.sum() - 20){
				options.add(i);
				continue;		
			}
			/*Tests if users have similar book reviews*/
			int pos = 0;
			int likeness = 0;
			for (int otherscore : i.getScore()){
				if (r.getScore()[pos] + 1 >= otherscore 
				 && r.getScore()[pos] - 1 <= otherscore
				 && r.getScore()[pos] != 0){
					likeness += Math.pow(otherscore, 2);
				 }
				pos++;
			}
			if (likeness >= 100)
				options.add(i);
		}
		
		//Finds number of books in the list
		int numbooks = 0;
		for (int i : r.getScore()){
			numbooks++;
		}
		
		//Loop through books and find how much it is recommended.
		//Higher Scores are given more weight than low scores
		double[] choice = new double[86];
		int numread = 0;
		int numgood = 0;
		for (int pos = 0; pos < numbooks; pos++){
			choice[pos] = 0;
			numread = 0;
			numgood = 0;
			for (int j = 0; j < options.size(); j++)
				if (options.get(j).getScore()[pos] >= 4
				&&  r.getScore()[pos] == 0){
					numread += 1;
					numgood += options.get(j).likeness(r);
				}
				else{
					numread += 1;
				}
			choice[pos] = numgood/numread;
		}
		
		//Finally calculate which book is the best!
		double high = 0;
		int current = 0;
		int winner = 0;
		for (double i : choice){
			if (i > high){
				high = i;
				winner = current;
			}
			current++;
		}
		return b.getBook()[winner];
	}
}
