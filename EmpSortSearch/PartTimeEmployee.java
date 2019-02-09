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

   public double getDues(){return 0;}

   public String toString(){
   	return String.format("Name: %s\nRate: %.2f\nHours: %d", name, rate, hours);
   }

}

