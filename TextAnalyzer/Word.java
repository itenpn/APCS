public class Word{

	private String myw;
	
	public Word(){myw = "";}
	
	public Word(String w){myw = w.toLowerCase();}

	public void append(String w){
		myw += w.toLowerCase();
	}

	public boolean hasEnd(){
		String c = "";
		if (myw.length() > 1){
			c = myw.substring(myw.length() - 1, myw.length());
		}
		else {c = myw;}
		if (c.equals(".")
		||  c.equals(";")
		||  c.equals(":")
		||  c.equals("!")
		||  c.equals("?"))
			return true;
		return false;
	}

	private boolean isVowel(String c){
		if (c.equals("a")
		||  c.equals("e")
		||  c.equals("i")
		||  c.equals("o")
		||  c.equals("u")
		||  c.equals("y"))
			return true;
		return false;
	}
	
	private boolean leTest(){
		String c = myw.substring(myw.length() - 2, myw.length());
		if ((c.equals("le") || c.equals("el"))
		&&  !isVowel(myw.substring(myw.length() - 3, myw.length() - 2)))
			return true;
		return false;
	}

	public int syllables(){
		int vowel = 0;
		int score = 0;
		int eflag = 0;
		for (int i = 0; i < myw.length(); i++)
			if (isVowel(myw.substring(i, i + 1))){
				vowel++;
				score++;
				if (i > 0){
					if (isVowel(myw.substring(i-1, i))
					&&  !myw.substring(i-1,i).equals("y")){
						score--;
						vowel--;
					}
					if (myw.substring(i, i + 1).equals("e")
					&&  vowel == 2
					&&  !isVowel(myw.substring(i-1,i))
					&&  isVowel(myw.substring(i-2,i-1))
					&&  !myw.substring(i-2,i-1).equals("u") 
					&&  !myw.substring(i-2,i-1).equals("y") 
					){
						score--;
						eflag = 1;
						vowel = 0;
					}
				}
			}
		if (myw.length() > 2)
			if (leTest() && eflag == 1){
				score++;
			}
		if (score <= 0){score = 1;}	
		return score;
	}

}
