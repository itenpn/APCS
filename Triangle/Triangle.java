import javax.lang.model.util.ElementScanner6;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Triangle{

    private LineSeg a;
    private LineSeg b;
    private LineSeg c;

    public Triangle(){
        a = new LineSeg();
        b = new LineSeg();
        c = new LineSeg();
    }

    public Triangle(LineSeg x, LineSeg y, LineSeg z){
        a = x;
        b = y;
        c = z;
    }

    public void seta(LineSeg x){
        a = x;
    }

    public void setb(LineSeg y){
        b = y;
    }

    public void setc(LineSeg z){
        c = z;
    }

    public LineSeg geta(){
        return a;
    }

    public LineSeg getb(){
        return b;
    }

    public LineSeg getc(){
        return c;
    }

    public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

    public boolean isTri(){
        if(a.dist() < (b.dist() + c.dist())
        || b.dist() < (a.dist() + c.dist())
        || c.dist() < (a.dist() + b.dist())){
            return true;
        }
        else{
            return false;
        }
    }

    public double area(){
        if (isTri()){
            double s = (a.dist() + b.dist() + c.dist()) / 2;
            return round(Math.sqrt(s * (s-a.dist()) * (s-b.dist()) * (s-c.dist())),2);
        }
        else{
            return 0;
        }
    }

    public String triType(){
        String str = "";
        if (angleA() == 90 || angleB() == 90 || angleC() == 90){
            str = "Right ";
        }
        else if (angleA() < 90 && angleB() < 90 && angleC() < 90){
            str = "Acute ";
        }
        else{
            str = "Obtuse ";
        }
        

        if (a.dist() == b.dist() && b.dist() == c.dist()){
            str += "Equilateral";
        }
        else if(a.dist() != b.dist() && a.dist() != c.dist() && b.dist() != c.dist()){
            str += "Scalene";
        }
        else{
            str += "Iscoceles";
        }
        return str;
    }
    
    public double perimeter(){
        return round(a.dist() + b.dist() + c.dist(),2);
    }

    public double angleA(){
        double angle = Math.acos((Math.pow(a.dist(),2) - Math.pow(b.dist(),2) - Math.pow(c.dist(),2))/ -2 / b.dist() / c.dist());
        angle *= 180/Math.PI;
        return round(angle,2);
    }

    public double angleB(){
        double angle = Math.acos((Math.pow(b.dist(),2) - Math.pow(a.dist(),2) - Math.pow(c.dist(),2))/ -2 / a.dist() / c.dist());
        angle *= 180/Math.PI;
        return round(angle,2);
    }

    public double angleC(){
        double angle = Math.acos((Math.pow(c.dist(),2) - Math.pow(b.dist(),2) - Math.pow(a.dist(),2))/ -2 / b.dist() / a.dist());
        angle *= 180/Math.PI;
        return round(angle,2);
    }

    public String toString(){
        String str = "";
        if (isTri()){
        str += "Triangle Type: " + triType() + "\n";
        str += "Angle A: " + Double.toString(angleA()) + "\n";
        str += "Angle B: " + Double.toString(angleB()) + "\n";
        str += "Angle C: " + Double.toString(angleC()) + "\n";
        str += "Area: " + Double.toString(area()) + "\n";
        str += "Perimeter: " + Double.toString(perimeter()) + "\n";
        }
        else{
            str = "Not a Triangle";
        }
        return str;
    }

}