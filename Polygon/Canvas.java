import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Canvas extends JPanel{

    private Polygon myP;
    private int numP;
    private int display;

    public Canvas(){
        setSize(500,500);
        myP = new Polygon();
        display = 0;
        this.addMouseListener(new MyMouseListener(this));
        this.setFocusable(true);
        this.addKeyListener(new KeyListen(this));
    }

    public void handleDisplay(){
        if (display == 1){
            display = 0;
        }
        else{
            display = 1;
        }
    }

    public void setP(Point[] x, int pos){
        myP.setPoints(x, pos);
    }

    public Polygon getP(){
        return myP;
    }

    public int getNum(){
        return numP;
    }

    public void setNum(int x){
        numP = x;
    }

    public void clicked(){
        this.repaint();
    }

    public void createGraph(Graphics g){
        g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        g.setColor(Color.red);
        for (int i = 0; i < 21; i++){
            int pos = (int)(getWidth() * i / 20);
            int top = getHeight()/2 + 10;
            int bot = getHeight()/2 - 10;
            g.drawLine(pos,top,pos,bot);
        }
        g.setColor(Color.blue);
        for (int i = 0; i < 21; i++){
            int pos = (int)(getHeight() * i / 20);
            int top = getWidth()/2 + 10;
            int bot = getWidth()/2 - 10;
            g.drawLine(top,pos,bot,pos);
        }
    }
    
    public Point convertXY(Point point){
        int newX = (int)(getWidth() * (point.getx() + 10) / 20);
        int newY = (int)(getHeight() * (20-(point.gety() + 10))/ 20);
        return new Point(newX, newY);
    }

    public LineSeg convertXYLine(LineSeg l){
        Point newL1 = convertXY(l.getL1());
        Point newL2 = convertXY(l.getL2());
        return new LineSeg(newL1, newL2);
    }

    public void createPoint(Graphics g, Point p){
        g.setColor(Color.MAGENTA);
        g.drawOval((int)(convertXY(p).getx()-5), (int)(convertXY(p).gety()-5),5,5);
        g.fillOval((int)(convertXY(p).getx()-5), (int)(convertXY(p).gety()-5),5,5);
        g.drawString(p.toString(),(int)(convertXY(p).getx()-10), (int)(convertXY(p).gety()-10));
    }

    public void createLine(Graphics g, LineSeg l){
        createPoint(g, l.getL1());
        createPoint(g, l.getL2());
        g.setColor(Color.MAGENTA);
        g.drawLine((int)convertXYLine(l).getL1().getx(), (int)convertXYLine(l).getL1().gety(), (int)convertXYLine(l).getL2().getx(), (int)convertXYLine(l).getL2().gety());
    }

    public int getXSize(){
        return getWidth();
    }

    public int getYSize(){
        return getHeight();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (display == 0){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 10)); 
            createGraph(g);
            if (myP.getNumP() > 0){
                Point[] pDraw = myP.getPoints();
                for(int i = 0; i < myP.getNumP(); i++){
                    createPoint(g, pDraw[i]);
                }
                if (myP.getNumP() > 1){
                    for (int i = 0; i < myP.getNumP() - 1; i++){
                        createLine(g, new LineSeg(pDraw[i], pDraw[i + 1]));
                    }
                    createLine(g, new LineSeg(pDraw[0], pDraw[myP.getNumP() - 1]));
                }
            }
        }
        else{
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
            g.setColor(Color.BLACK);
            g.drawString("Stats", 10, 20);
            g.drawString("Area: " + Double.toString(myP.area()), 10, 50);        
            g.drawString("Perimeter: " + Double.toString(myP.perimeter()), 10, 100);   
            g.drawString("Type: " + myP.polyType(), 10, 150);     
            g.drawString("Points: ", 10, 180);
            for (int i = 0; i < myP.getNumP(); i++){
                g.drawString(myP.getPoints()[i].toString(), 10, 250 + i * 50);
            }        

        }
    }
}