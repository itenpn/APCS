import java.math.BigDecimal;
import java.math.RoundingMode;

class Point{
    
    private double x;
    private double y;

    public Point(){
        x = 0;
        y = 0;
    }

    public Point(double a, double b){
        x = a;
        y = b;
    }

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }

    public void setx(double a){
        x = a;
    }

    public void sety(double b){
        y = b;
    }

    public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
    }
    
    public String toString(){
        return "(" + Double.toString(round(x,2)) + "," + Double.toString(round(y,2)) + ")";
    }

}