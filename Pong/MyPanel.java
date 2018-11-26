import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class MyPanel extends JPanel{
    
    private javax.swing.Timer timer;
    private Ball b;
    private int random;
    private int[] direction = new int[2];
    private Paddle p1;
    private Paddle p2;

    public MyPanel(){
        setBackground(Color.black);
        b = new Ball(500, 250);
        p1 = new Paddle(50,250);
        p2 = new Paddle(950, 250);
        direction[0] = 1;
        direction[1] = 1;
        timer = new javax.swing.Timer(10, new MoveListener());
        timer.start();
        random = 0;
        this.setFocusable(true);
        this.addKeyListener(new MyKeyListener());
        this.addKeyListener(new MyKeyListener2());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        b.draw(g);
        p1.draw(g);
        p2.draw(g);
    }

    private class MoveListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            b.move(direction[0],direction[1]);
            if (b.getX() >= getWidth() - 20
            || b.getX() <= 5
            || p1.contacts(b)
            || p2.contacts(b)
            ){
                direction[0] *= -1;
            }
            if (b.getY() >= getHeight() - 20
            || b.getY() <= 5
            ){
                direction[1] *= -1;
            }
            repaint();
        }

    }

    private class MyKeyListener implements KeyListener{
        
        public MyKeyListener(){}
        @Override
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == 87){
                p1.move(0,-10);
            }
            else if (e.getKeyCode() == 83){
                p1.move(0,10);
            }
            repaint();
        }
        @Override
	public void keyReleased(KeyEvent e){}
	@Override
        public void keyTyped(KeyEvent e){}
    }
    private class MyKeyListener2 implements KeyListener{
        
        public MyKeyListener2(){}
        @Override
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == 38){
                p2.move(0,-10);
            }
            else if (e.getKeyCode() == 40){
                p2.move(0,10);
            }
            repaint();
        }
        @Override
        public void keyReleased(KeyEvent e){}
        @Override
        public void keyTyped(KeyEvent e){}
    }

}
