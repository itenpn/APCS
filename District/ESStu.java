public class ESStu extends Student{

	private String project;

	public ESStu(int g, String proj){
		super();
		setGrade(g);
		project = proj;
	}

	public ESStu(int g, String proj, String newfname, String newlname, double newfee, int[] scores){
		super(newfname, newlname, g, newfee, scores);
		project = proj;
	}

	public String getProject(){
		return project;
	}

	public String output(){
		return String.format("Name: %-20s\nGrade: %2d\nScores: %d, %d, %d\nGPA: %3.2f\nFees: $%5.2f\nID: %6d\nProject: %s", 
				getName(), 
				grade,
			       	score[0],
				score[1],
				score[2],	
				getGPA(), 
				fees, 
				idnum, 
				project);
	}
}
