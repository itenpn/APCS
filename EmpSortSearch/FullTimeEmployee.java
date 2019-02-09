import java.util.Random;

public class FullTimeEmployee extends Employee {

   private double uniondue;

   public FullTimeEmployee(){
      super();
      Random rng = new Random();
      uniondue = rng.nextDouble() * 100;
   }
  
   public FullTimeEmployee(String n, double r, int h, double u){
      super(n, r, h);
      uniondue = u;
   }

   public double getPay() {
      double pay;
      
      if (hours <= 40)
         pay = rate * hours;
      else
         pay = rate * 40 +  rate * 2 * (hours - 40);

      totalPay += pay;
      return pay;
   }

   public double getDues(){return uniondue;}

   public String toString(){
   	return String.format("Name: %s\nRate: %.2f\nHours: %d\nUnion: %.2f", name, rate, hours, uniondue);
   }

}

