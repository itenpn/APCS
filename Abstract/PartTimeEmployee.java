public class PartTimeEmployee extends Employee {

   public PartTimeEmployee() {
      super();
   }

   public PartTimeEmployee(String n, double r, int h){
   	super(n, r, h);
   }
  
   public double getPay() {
      double pay;
      pay = rate * hours;
      totalPay += pay;
      return pay;
   }
}

