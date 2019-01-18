import java.util.Scanner;

public class Index{

	public static void main(String[] args){
		Scanner r = new Scanner(System.in);
		Employee[] emps = new Employee[5];
		for (int i = 0; i < 5; i++){
			System.out.println("Name?");
			String name = r.next();
			System.out.println("Rate?");
			double rate = r.nextDouble();
			System.out.println("Hours?");
			int hours = r.nextInt();
			System.out.println("Type of Employee? 0 = PT 1 = FT");
			int type = r.nextInt();
			if (type == 0)
				emps[i] = new PartTimeEmployee(name, rate, hours);
			else
				emps[i] = new FullTimeEmployee(name, rate, hours);
		}
		r.close();
		for (Employee i : emps){
			System.out.printf("Name: %s\nPay: $%.2f\n",
					i.getName(),
					i.getPay());
		}
		System.out.printf("Total Pay: $%.2f\n", Employee.getTotalPay());	
	}
}
