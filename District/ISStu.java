public class ISStu extends Student{

	private String building;

	public ISStu(int g, int build){
		super();
		setGrade(g);
		if (build == 1)
			building = "William Foster";
		else
			building = "John Schmidt";
	}

	public ISStu(int g, String build, String newfname, String newlname, double newfee, int[] scores){
		super(newfname, newlname, g, newfee, scores);
		building = build;
	}

	public String getBuilding(){
		return building;
	}

	public String output(){
		return String.format("Name: %-20s\nGrade: %2d\nScores: %d, %d, %d\nGPA: %3.2f\nFees: $%5.2f\nID: %6d\nBuilding: %s", 
				getName(), grade, score[0], score[1], score[2], getGPA(), fees, idnum, building);
	}
}
