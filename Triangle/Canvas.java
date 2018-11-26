import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Canvas extends JPanel{

    private PolyPoint[] myP = new PolyPoint[4];
    private int numP;

    public Canvas(){
        numP = 0;
        myP[0] = new PolyPoint();
        myP[1] = new PolyPoint();
        myP[2] = new PolyPoint();
        setSize(500,500);
        this.addMouseListener(new MyMouseListener(this));
    }

    public Canvas(PolyPoint a, PolyPoint b, PolyPoint c){
        myP[0] = a;
        myP[1] = b;
        myP[2] = c;
        numP = 3;
    }

    public void resetCanvas(){
        numP = 0;
        myP[0] = new PolyPoint();
        myP[1] = new PolyPoint();
        myP[2] = new PolyPoint();
    }

    public void setP(PolyPoint x, int pos){
        myP[pos] = x;
    }

    public PolyPoint[] getP(){
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
    
    public PolyPoint convertXY(PolyPoint point){
        int newX = (int)(getWidth() * (point.getx() + 10) / 20);
        int newY = (int)(getHeight() * (20-(point.gety() + 10))/ 20);
        return new PolyPoint(newX, newY);
    }

    public LineSeg convertXYLine(LineSeg l){
        PolyPoint newL1 = convertXY(l.getL1());
        PolyPoint newL2 = convertXY(l.getL2());
        return new LineSeg(newL1, newL2);
    }

    public void createPoint(Graphics g, PolyPoint p){
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

    public void createTri(Graphics g, Triangle t){
        createLine(g,t.geta());
        createLine(g,t.getb());
        createLine(g,t.getc());
    }

    public int getXSize(){
        return getWidth();
    }

    public int getYSize(){
        return getHeight();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        createGraph(g);
        for(int i = 0; i < numP; i++){
            createPoint(g, myP[i]);
        }
        if (numP == 3){
            LineSeg L1 = new LineSeg(myP[0],myP[1]);
            LineSeg L2 = new LineSeg(myP[1],myP[2]);
            LineSeg L3 = new LineSeg(myP[2],myP[0]);
            Triangle t = new Triangle(L1,L2,L3);
            createTri(g,t);
            Triangle d = new Triangle();
            d.seta(new LineSeg(3,4,-3,1));
            d.setb(new LineSeg(-3,1,1,0));
            d.setc(new LineSeg(1,0,3,4));
            createTri(g,d);

            System.out.println("Triangle 1");
            System.out.println(t.toString());
            System.out.println("Triangle 2");
            System.out.println(d.toString());
        }
    }
}