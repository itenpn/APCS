public class HSStu extends Student{

	private int apclass;

	public HSStu(int g, int numap){
		super();
		setGrade(g);
		apclass = numap;
		fees += numap * 15;
		totalfees += numap * 15;
	}

	public HSStu(int g, int numap, String newfname, String newlname, double newfee, int[] scores){
		super(newfname, newlname, g, newfee, scores);
		apclass = numap;
		fees += numap * 15;
		totalfees += numap * 15;
	}

	public int getAP(){
		return apclass;
	}

	public String output(){
		return String.format("Name: %-20s\nGrade: %2d\nScores: %d, %d, %d\nGPA: %3.2f\nFees: $%5.2f\nID: %6d\nAP Classes: %d", 
				getName(), grade, score[0], score[1], score[2],getGPA(), fees, idnum, apclass);
	}

}
