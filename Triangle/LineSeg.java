import java.math.BigDecimal;
import java.math.RoundingMode;

public class LineSeg{

    private PolyPoint x;
    private PolyPoint y;

    public LineSeg(){
        x = new PolyPoint();
        y = new PolyPoint();
    }

    public LineSeg(double x1, double y1, double x2, double y2){
        x = new PolyPoint(x1, y1);
        y = new PolyPoint(x2, y2);
    }

    public LineSeg(PolyPoint a, PolyPoint b){
        x = a;
        y = b;
    }

    public void setL1(PolyPoint a){
        x = a;
    }

    public void setL2(PolyPoint a){
        y = a;
    }

    public PolyPoint getL1(){
        return x;
    }

    public PolyPoint getL2(){
        return y;
    }

    public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

    public double slope(){
        double num = y.gety() - x.gety();
        double den = y.getx() - x.getx();
        return num / den;
    }
    
    public double dist(){
        return round(Math.sqrt(Math.pow(y.getx() - x.getx(), 2) + Math.pow(y.gety()-x.gety(),2)),2);
    }

}