import javax.swing.*;
import java.awt.*;

class CreatePoint extends JPanel{

    private PolyPoint point;

    public CreatePoint(PolyPoint p){
        point = p;
    }

    public PolyPoint convertXY(){
        int newX = (int)(getWidth() * (point.getx() + 10) / 20);
        int newY = (int)(getHeight() * (20-(point.gety() + 10))/ 20);
        return new PolyPoint(newX, newY);
    }

    public void makePoint(Graphics g){
        g.setColor(Color.MAGENTA);
        g.drawOval((int)(convertXY().getx()-5), (int)(convertXY().gety()-5),5,5);
        g.fillOval((int)(convertXY().getx()-5), (int)(convertXY().gety()-5),5,5);
        g.drawString(point.toString(),(int)(convertXY().getx()-10), (int)(convertXY().gety()-10));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
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
        this.addMouseListener(new java.awt.event.MouseListener(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                double x = (double)(e.getX() - 10) * 20 / (double)getWidth();
                x -= 9.5;
                double y = (double)((e.getY() - 10)) * 20 / (double)getHeight();
                y -= 9.5;
                y *= -1;
                point = new PolyPoint(x,y);
                repaint();
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){}
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){}
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e){}            
            @Override
            public void mousePressed(java.awt.event.MouseEvent e){}
        });
        makePoint(g);
    }

}