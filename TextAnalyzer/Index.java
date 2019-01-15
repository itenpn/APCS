import java.util.Scanner;
import java.io.*;

public class Index{

	public static void main(String[] args) throws IOException{
		Scanner r = new Scanner(System.in);
		String[] texts = {"Beowulf.txt", "Gettysburg.txt", "RomeoJuliet.txt"};
		int i = r.nextInt();
		TextAnalyzer ta = new TextAnalyzer(new File(texts[i]));
		System.out.println(texts[i]);
		System.out.printf("Flesch: %d\n", ta.flesch());
		System.out.printf("Flesch Grade: %s\n", ta.fleschgrade());
		System.out.printf("Smog: %f\n", ta.smog());
	}

}
