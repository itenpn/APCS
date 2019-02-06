public class FullTimeEmployee extends Employee {

   private double uniondue;

   public FullTimeEmployee(){
      super();
      uniondue = 0;
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
}

