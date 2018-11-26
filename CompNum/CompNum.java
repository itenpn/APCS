
public class CompNum{

    private double myR;
    private double myI;

    public CompNum(){
        myR = 0;
        myI = 0;
    }

    public CompNum(double r, double i){
        myR = r;
        myI = i;
    }

    public CompNum(String cn){
        int pos = 0;
        int type = 0;
        for (int i = 1; i < cn.length(); i++){
            if (cn.substring(i, i + 1).equals("+")){
                pos = i;
            }
            else if(cn.substring(i, i + 1).equals("-")){
                pos = i;
                type = 1;
            }
        }
        myR = Double.parseDouble(cn.substring(0,pos));
        myI = Double.parseDouble(cn.substring(pos + 1,cn.length() - 1));
        if (type == 1)
            myI *= -1;
    }

    public CompNum(CompNum c){
        myR = c.getR();
        myI = c.getI();
    }

    public double argument(){
        double angle = Math.atan(myI/myR);
        angle *= (180/Math.PI);
        return angle;
    }

    public double modulus(){
        return Math.sqrt(Math.pow(myR,2) + Math.pow(myI,2));
    }

    public CompNum conjugate(){
        double a = myR;
        double b = -myI;
        CompNum c = new CompNum(a,b);
        return c;
    }

    public CompNum add(CompNum c){
        double r, i;
        r = myR + c.getR();
        i = myI + c.getI();
        return new CompNum(r,i);
    }

    public CompNum sub(CompNum c){
        double r, i;
        r = myR - c.getR();
        i = myI - c.getI();
        return new CompNum(r,i);
    }

    public CompNum mult(CompNum c){
        double r, i;
        r = (myR * c.getR()) - (myI * c.getI());
        i = (myR * c.getI()) + (myI * c.getR());
        return new CompNum(r, i);
    }

    public CompNum div(CompNum c){
        double bottom = c.mult(c.conjugate()).getR();
        CompNum top = mult(c.conjugate());
        return new CompNum(top.getR()/bottom, top.getI()/bottom);
    }

    public CompNum pow(double n){
        double r, theta;
        r = modulus();
        theta = argument() * Math.PI / 180;
        r = Math.pow(r, n);
        theta *= n;
        return new CompNum(r * Math.cos(theta), r * Math.sin(theta));
    }

    public double getR(){
        return myR;
    }    

    public double getI(){
        return myI;
    }

    public void setR(double r){
        myR = r;
    }

    public void setI(double i){
        myI = i;
    }

    public String toString(){
        if (myI >= 0)
            return String.format("%.3f",myR) + " + " + String.format("%.3f", myI) + "i";
        else
            return String.format("%.3f",myR) + " - " + String.format("%.3f", -myI) + "i";
    }

}