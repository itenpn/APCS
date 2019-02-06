import java.util.Scanner;
import java.util.Random;

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
			else{
				double union = 0;
				Random rng = new Random();
				union = rng.nextDouble() * 25;
				emps[i] = new FullTimeEmployee(name, rate, hours, union);
			}
		}
		r.close();
		
		double fullpay = 0;
		double partpay = 0;
		for (Employee i : emps)
			if (i instanceof PartTimeEmployee)
				partpay += i.getPay();
			else
				fullpay += i.getPay();

		for (Employee i : emps){
			System.out.printf("Name: %s\nPay: $%.2f\n",
					i.getName(),
					i.getPay());
			if (i instanceof FullTimeEmployee){
				System.out.printf("Union Dues: $%.2f\n", i.getDues());
			}
		}
		
		System.out.printf("Part Time Pay: $%.2f\nFull Time Pay: $%.2f\nTotal Pay: $%.2f\n", 
				partpay,
				fullpay,
				Employee.getTotalPay());	
	}
}
