import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Index{

	public static void main(String[] args){
		ArrayList<Employee> emp = new ArrayList<Employee>();
		Random rng = new Random();
		for (int i = 0; i < 100; i++){
			int rnum = rng.nextInt(2);
			if (rnum == 0)
				emp.add(new FullTimeEmployee());
			else
				emp.add(new PartTimeEmployee());
		}
		for (int i = 0; i < 100; i++)
			for (int j = i; j < 100; j++){
				int comp = emp.get(i).getName().compareTo(emp.get(j).getName());
				if (comp > 0){
					Employee temp = emp.get(i);
					emp.set(i, emp.get(j));
					emp.set(j, temp);
				}
			}
		for (int i = 0; i < 100; i++){
			System.out.println(emp.get(i).toString());
		}
		String ans = "y";
		Scanner r = new Scanner(System.in);
		while (ans.equals("y")){
			System.out.println("Who are you looking for?");
			String SI = r.nextLine().toUpperCase();
			int high = emp.size();
			int low = 0;
			int pos = -5;
			while (pos == -5){
				int mid = (low + high) / 2;
				if (low >= high){
					pos = -1;
				}
				else if (emp.get(mid).getName().equals(SI)){
					pos = mid;
				}
				else if (emp.get(mid).getName().compareTo(SI) < 0){
					low = mid;
				}
				else if (emp.get(mid).getName().compareTo(SI) > 0){
					high = mid;
				}
			}
			if (pos >= 0){
				System.out.println(emp.get(pos).toString());
			}	
			else {
				System.out.println("Name not valid");
			}
			System.out.println("Run again? <y/n>");
			ans = r.nextLine();	
		}
		r.close();

	}

}
