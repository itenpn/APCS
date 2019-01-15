import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class TextAnalyzer{

	private ArrayList<Word> w;

	public TextAnalyzer(String s){
		String[] x = s.split(" ");
		w = new ArrayList<Word>();
		for (String i : x){
			w.add(new Word(i));
		}
	}

	public TextAnalyzer(File f) throws IOException{
		Scanner r = new Scanner(f);
		w = new ArrayList<Word>();
		ArrayList<String> lines = new ArrayList<String>();
		while (r.hasNext()){
			lines.add(r.nextLine());
		}
		for (int i = 0; i < lines.size(); i++){
			if (lines.get(i).equals("")){
				continue;
			}
			String[] x = lines.get(i).split(" ");	
			for (String q : x){
				w.add(new Word(q));
			}
		}
		r.close();		
	}

	public double smog(){
		double numwords = w.size();
		double numsent = 0;
		double numpoly = 0;
		for (int i = 0; i < numwords; i++){
			if ( w.get(i).syllables() >= 3)
				numpoly++;
			if (w.get(i).hasEnd())
				numsent++;
		}
		return 1.0430 * Math.sqrt(numpoly * 30 / numsent) + 3.1291;
	}

	public long flesch(){
		double numwords = w.size();
		double numsyl = 0;
		double numsent = 0;
		for (int i = 0; i < numwords; i++){
			numsyl += w.get(i).syllables();
			if (w.get(i).hasEnd())
				numsent++;
		}
		double avgsyl = numsyl / numwords;
		double avgword = numwords / numsent;
		double score = 206.835 - ((avgword * 1.015) + (avgsyl * 84.6));
		long z = Math.round(score);
		return z;
	}
	
	public String fleschgrade(){
		long x = flesch();
		if (x <= 30){
			return "College Grad";
		}
		else if (x <= 50){
			return "College Student";
		}
		else if (x <= 60){
			return "10th to 12th Grade";
		}
		else if (x <= 70){
			return "8th and 9th Grade";
		}
		else if (x <= 80){
			return "7th Grade";
		}
		else if (x <= 90){
			return "6th Grade";
		}
		else if (x <= 100){
			return "5th Grade";
		}
		else{
			return "Pre-5th Grade";
		}
	}
}
