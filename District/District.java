import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class District{

	private ArrayList<Student> stus;

	public District(){
		stus = new ArrayList<Student>();
		Random rng = new Random();
		for (int i = 0; i < 1000; i++){
			int g = rng.nextInt(12) + 1;
			if (g >= 9){
				int numap = rng.nextInt(11);
				stus.add(new HSStu(g, numap));
			}
			else if (g >= 7){
				int team = rng.nextInt(5);
				stus.add(new MSStu(g, team));
			}
			else if (g >= 4){
				int building = rng.nextInt(2) + 1;
				stus.add(new ISStu(g, building));
			}
			else{
				String[] x = new String[3];
				x[0] = "Painting";
				x[1] = "Math Problems";
				x[2] = "Science Fair";
				int proj = rng.nextInt(3);
				stus.add(new ESStu(g, x[proj]));
			}
		}
	}
	
	public int search(int id){
		for (int i = 0; i < stus.size(); i++){
			if (stus.get(i).getID() == id){
				return i;
			}
		}
		return -1;
	}

	public void addStu(Student s){
		stus.add(s);
	}

	public void removeStu(int index){
		stus.remove(index);
		Student.totalStu--;
	}

	public void sort(int type){
		Student temp;
		Student[] x = new Student[stus.size()];
		for (int i = 0; i < stus.size(); i++){
			x[i] = stus.get(i);
			System.out.println(x[i].output());
		}
		if (type == 1){
			for (int i = 0; i < stus.size(); i++){
				for (int j = i; j < stus.size(); j++)
					if (x[i].getID() > x[j].getID()){
						temp = x[i];
						x[i] = x[j];
						x[j] = temp;
					}
			}
		}
		else{
			for (int i = 0; i < stus.size(); i++){
				for (int j = i; j < stus.size(); j++)
					if (x[i].getGrade() > x[j].getGrade()){
						temp = x[i];
						x[i] = x[j];
						x[j] = temp;
					}
			}
		}
		System.out.println("pass");
		stus.clear();
		for (int i = 0; i < stus.size(); i++){
			stus.add(x[i]);
		}
	}

	public void Save() throws IOException{
		PrintWriter p = new PrintWriter(new File("Students.txt"));
		for (int i = 0; i < stus.size(); i++){
			p.println(stus.get(i).output());
		}
		p.close();
	}

	public ArrayList<Student> getStudents(){
		return stus;
	}

}
