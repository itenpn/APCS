import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MyMouseListener implements MouseListener{

    private Canvas Parent;

    public MyMouseListener(Canvas x){
        Parent = x;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double x = (double)(e.getX() - 10) * 20 / (double)Parent.getXSize();
        x -= 9.5;
        double y = (double)((e.getY() - 10)) * 20 / (double)Parent.getYSize();
        y -= 9.5;
        y *= -1;
        if (Parent.getNum() < 3){
            PolyPoint z = new PolyPoint(x,y);
            Parent.setP(z,Parent.getNum());
            Parent.setNum(Parent.getNum() + 1);
        }
        Parent.clicked();
    }
    @Override
    public void mouseExited(java.awt.event.MouseEvent e){}
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e){}
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e){}            
    @Override
    public void mousePressed(java.awt.event.MouseEvent e){
    }

}