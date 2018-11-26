public class Reader{

	private String name;
	private int[] score;

	public Reader(){
		name = "";
		score = new int[100];
	}

	public Reader(String n, int[] s){
		name = n;
		score = s;
		
	}

	public String getName(){
		return name;
	}

	public int[] getScore(){
		return score;
	}

	public int sum(){
		int sum = 0;
		for (int i : score){
			sum += i;
		}
		return sum;
	}
}
