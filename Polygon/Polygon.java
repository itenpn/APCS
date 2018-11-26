public class Polygon{
    private Point[] myPoints = new Point[100];
    private int myNumP;

    public Polygon(){
        myNumP = 0;
        
    }

    public Polygon(Point[] p, int nump){
        myPoints = p;
        myNumP = nump;
    }

    public Point[] getPoints(){
        return myPoints;
    }

    public int getNumP(){
        return myNumP;
    }

    public void setPoints(Point[] p, int nump){
        myPoints = p;
        myNumP = nump;
    }

    public void addPoint(Point p){
        myPoints[myNumP] = p;
        myNumP++;
    }

    public double area(){
        double a = 0;
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < myNumP - 1; i++){
            sum1 += myPoints[i].getx() * myPoints[i+1].gety();
            sum2 += myPoints[i+1].getx() * myPoints[i].gety();
        }
        a = sum1 + myPoints[myNumP - 1].getx() * myPoints[0].gety();
        a -= (sum2 + myPoints[0].getx() * myPoints[myNumP - 1].gety()); 
        a /= 2;
        if (a < 0)
            return -a;
        else
            return a;
    }

    public double perimeter(){
        double p = 0;
        for (int i = 0; i < myNumP - 1; i++){
            p += Math.sqrt(Math.pow(myPoints[i].getx() - myPoints[i+1].getx(),2) + Math.pow(myPoints[i].gety() - myPoints[i+1].gety(),2));     
        }
        p += Math.sqrt(Math.pow(myPoints[0].getx() - myPoints[myNumP - 1].getx(), 2) + Math.pow(myPoints[0].gety() - myPoints[myNumP - 1].gety(),2));
        return p;
    }

    public String polyType(){
        switch (myNumP){
            case 1: return("Point");
            case 2: return("Line");
            case 3: return("Triangle");
            case 4: return("Quadrilateral");
            case 5: return("Pentagon");
            case 6: return("Hexagon");
            case 7: return("Heptagon");
            case 8: return("Octagon");
            case 9: return("Nonagon");
            case 10: return("Decagon");
            case 11: return("Hendegon");
            case 12: return("Dodecagon");
            default: return(Integer.toString(myNumP) + "-gon");
        }
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < myNumP; i++)
            str += myPoints[i].toString() + "\n";
        return str;
    }

}