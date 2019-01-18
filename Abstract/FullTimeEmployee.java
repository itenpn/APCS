public class FullTimeEmployee extends Employee {

   public FullTimeEmployee(){
      super();
   }
  
   public FullTimeEmployee(String n, double r, int h){
      super(n, r, h);
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
}

