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

	public int likeness(Reader test){
		int like = 0;
		int pos = 0;
		for (int i : test.getScore()){
			if (score[pos++] == i){
				like += 1;
			}
		}
		if (sum() * like > test.sum() * like){
			like -= like * (sum() - test.sum());
		}
		else {
			like += like * (test.sum() - sum());
		}
		return like;
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
