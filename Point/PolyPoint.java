class PolyPoint{
    
    private double x;
    private double y;

    public PolyPoint(){
        x = 0;
        y = 0;
    }

    public PolyPoint(double a, double b){
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

    public String toString(){
        return "(" + Double.toString(x) + "," + Double.toString(y) + ")";
    }

}