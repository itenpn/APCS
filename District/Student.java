import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public abstract class Student{
	protected int grade, idnum;
	protected double fees;
	protected String fname, lname;
	protected static int current_idnum = 100000;
	public static int totalStu = 0;
	public static double totalfees = 0;
	protected int[] score = new int[3];

	public Student(){
		totalStu++;
		current_idnum++;
		idnum = current_idnum;
		Random gender = new Random();
		setName(gender.nextInt(2));
		Random rng = new Random();
		int aptitude = rng.nextInt(3);
		if (aptitude == 2){
			score[0] = rng.nextInt(15) + 85;
			score[1] = rng.nextInt(15) + 85;
			score[2] = rng.nextInt(15) + 85;
		}
		else if (aptitude == 1){
			score[0] = rng.nextInt(25) + 75;
			score[1] = rng.nextInt(25) + 75;
			score[2] = rng.nextInt(25) + 75;
		}
		else{
			score[0] = rng.nextInt(35) + 65;
			score[1] = rng.nextInt(35) + 65;
			score[2] = rng.nextInt(35) + 65;
		}
	}

	public Student(String newfname, String newlname, int newgrade, double newfee, int[] scores){
		totalStu++;
		current_idnum++;
		idnum = current_idnum;
		fname = newfname;
		lname = newlname;
		grade = newgrade;
		fees = newfee;
		totalfees += newfee;
		score = scores;
	}

	public double getGrade(){return grade;}
	public int getID(){return idnum;}
	public int[] getScores(){return score;}
	public double getFee(){return fees;}
	public void setID(int id){idnum = id; current_idnum--;}
	public String getfname(){return fname;}
	public String getlname(){return lname;}

	public double getGPA(){
		double sum = 0;
		for (int i : score){
			if (i > 89)
				sum += 4;
			else if (i > 79)
				sum += 3;
			else if (i > 69)
				sum += 2;
			else
				sum += 1;
		}	
		return sum / 3;
	}

	public String getName(){
		return fname + " " + lname;
	}

	protected abstract String output();

	public String toString(){
		return String.format("%30s, ID: %6d", getName(), idnum);
	}

	public void setGrade(int g){
		grade = g;
		int max;
		if (g >= 9){
			max = 100;
		}
		else if (g >= 7){
			max = 60;
		}
		else if (g >= 4){
			max = 30;
		}
		else{
			max = 10;
		}
		Random rng = new Random();
		fees = rng.nextDouble() * max;	
		totalfees += fees;
	}

	private void setName(int gender){
		try{
		ArrayList<String> firstname, lastname;
		firstname = new ArrayList<String>();
		lastname = new ArrayList<String>();
		if (gender == 0){
			Scanner r = new Scanner(new File("MaleNamesDictionary.txt"));
			while (r.hasNext())
				firstname.add(r.nextLine());
			r.close();
		}
		else{
			Scanner r = new Scanner(new File("FemaleNamesDictionary.txt"));	
			while (r.hasNext())
				firstname.add(r.nextLine());
			r.close();
		}	
		Scanner r = new Scanner(new File("LastNames.txt"));
		while (r.hasNext())
			lastname.add(r.nextLine());
		r.close();
		Random x = new Random();
		fname = firstname.get(x.nextInt(firstname.size() - 1));
		lname = lastname.get(x.nextInt(lastname.size() - 1));
		}
		catch(Exception e){}
	}
}
