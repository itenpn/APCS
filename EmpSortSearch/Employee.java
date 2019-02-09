import java.util.Random;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

abstract public class Employee {

// Protected Instance Variables:  
   protected String name;  
   protected double rate;  
   protected int hours;
     
// Public Methods:  
   public Employee(){
	   ArrayList<String> lastname = new ArrayList<String>();
	   try{
		Scanner r = new Scanner(new File("LastNames.txt"));
		while(r.hasNext())
			lastname.add(r.nextLine());
		r.close();
	   }catch(Exception e){}
	   Random rng = new Random();
	   int rnum = rng.nextInt(lastname.size());
	   name = lastname.get(rnum);
	   rate = rng.nextDouble() * 100;
	   hours = rng.nextInt(60);
   }

   public Employee(String n, double r, int h){
   	name = n;
	rate = r;
	hours = h;
   }
 
   public abstract String toString();

   public boolean setName(String nm){
      if (nm.equals(""))
         return false;
      else{
         name = nm;
         return true;
      }
   }
        
   public boolean setRate(double rt){
      if (!(LOW_RATE <= rt && rt <= HIGH_RATE))
         return false;
      else{
         rate = rt;
         return true;
      }
   }
  
   public boolean setHours(int hrs){
      if (!(LOW_HOURS <= hrs && hrs <= HIGH_HOURS))
         return false;
      else{
         hours = hrs;
         return true;
      }
   }
  
   public String getName(){
      return name;
   }
  
   abstract public double getPay();
   abstract public double getDues(); 
   //---------------------------------------
   
   public static double LOW_RATE = 6.75;
   public static double HIGH_RATE = 30.50;
   public static double LOW_HOURS = 1;
   public static double HIGH_HOURS = 60;
   
   protected static double totalPay = 0;
   
   public static String getNameRules() {
      return "nonblank";
   }
   
   public static String getTypeRules() {
      return "1 or 2";
   }
   
   public static String getRateRules() {
      return getRule (LOW_RATE, HIGH_RATE);
   }
   
   public static String getHoursRules() {
      return getRule (LOW_HOURS, HIGH_HOURS);
   }

   public static boolean typeOK (int type) {
      return type == 1 || type == 2;
   }
   
   public static double getTotalPay() {
      return totalPay;
   }
   
   private static String getRule (double low, double high) {
         return "between " + low + " and " + high + ", inclusive";
   }
}

