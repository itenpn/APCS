
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

    public double slope(){
        double num = y.gety() - x.gety();
        double den = y.getx() - x.getx();
        return num / den;
    }
    
}