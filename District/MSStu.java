public class MSStu extends Student{

	private String team;

	public MSStu(int g, int t){
		super();
		setGrade(g);
		String[] x = new String[5];
		x[0] = "Gifford Dinos";
		x[1] = "Kummer Tuners";
		x[2] = "Fightin' Itens";
		x[3] = "Sri's Trees";
		x[4] = "House of Kim";
		team = x[t];
	}
	
	public MSStu(int g, String t, String newfname, String newlname, double newfee, int[] scores){
		super(newfname, newlname, g, newfee, scores);
		team = t;;
	}

	public String getTeam(){
		return team;
	}
	
	public String output(){
		return String.format("Name: %-20s\nGrade: %2d\nScores: %d, %d, %d\nGPA: %3.2f\nFees: $%5.2f\nID: %6d\nTeam: %s", 
				getName(), grade, score[0], score[1], score[2], getGPA(), fees, idnum, team);
	}

}
