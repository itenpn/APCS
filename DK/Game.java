import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class Game extends JPanel{

    private int display, scorecount;
	private int difficulty;
	private Timer timer;	
	private Mario m;
	private int flag, counter, mflag;
	private Enemy dk;
	private int bcount;	
	private Floor[] floors = new Floor[9];
	private ArrayList<Barrel> barrels = new ArrayList<Barrel>();
	private Ladder[] ladders = new Ladder[9];
  private TopTen t;
    private Goal peach;

	public Game() throws IOException{
      timer = new Timer(5, new MoveListener());
      reset();
      this.addKeyListener(new MyKeyListener());
		this.setFocusable(true);
	}

    public void reset() throws IOException{
        t = new TopTen(new File("data.txt"));
        scorecount = 100000;
        display = 0;
        difficulty = 9;
        dk = new Enemy();
        peach = new Goal(200, 30);
        m = new Mario(300, 800);
        timer.start();
        flag = 0;
        mflag = 0;
        counter = 0;
        bcount = 0;
        for (int i = 0; i < 9; i++){
            if (i % 2 == 0){
                ladders[i] = new Ladder(300, 105 + (i*100));
                floors[i] = new Floor(0, 100 + (i * 100), 400, 10);
            }
            else{
                ladders[i] = new Ladder(20, 105 + (i * 100));
                floors[i] = new Floor(50, 100 + (i * 100), 450, 10);
            }
        }
        barrels.clear();
        barrels.add(new Barrel(70, 60));
    }

	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		if (display == 0){
        g.drawString("Score: " + Integer.toString(scorecount), 200, 20);
			dk.draw(g);
      peach.draw(g);
			for (int i = 0; i < 9; i++){
				floors[i].draw(g);
				ladders[i].draw(g);
			}
			for (int i = 0; i < barrels.size(); i++){
				barrels.get(i).draw(g);
			}
			m.draw(g, mflag);
		}
		else if (display == 1){
        timer.stop();
        SwingUtilities.invokeLater(new LoseDialogue());
		}
    else if (display == 2){
        timer.stop();
        SwingUtilities.invokeLater(new Dialogue());
    }
	}

	private class MoveListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
        scorecount--;
			for (int i = 0; i < barrels.size(); i++){
				if (barrels.get(i).contacts(m)){
					display = 1;
				}
			}
			bcount++;
      if (peach.contacts(m)){
          display = 2;
      }
			if (flag == 0 || flag == 1){
				flag = 0;
				for (int i = 0; i < 9; i++){
					if (floors[i].contact(m)){
              difficulty = i;
						flag = 1;
						break;
					}	
				}
			}
			else if (flag == 3){
				counter += 1;
				m.move(0, -1);
				if (counter == 60){
					counter = 0;
					flag = 0;
				}	
			}
			else if (flag == 4){
				m.move(0, -1);
				boolean touchladder = false;
				for (int i = 0; i < 9; i++){
					if (ladders[i].contacts(m)){
						touchladder = true;
					}
				}
				if (!touchladder){
					flag = 0;
					m.move(0,-1);
				}
			}
			if (flag == 0){
				m.move(0, 1);
			}
			if (mflag == 1){
				m.move(1, 0);
			}
			else if(mflag == -1){
				m.move(-1,0);
			}
			for (int i = 0; i < barrels.size(); i++){
				if (barrels.get(i).getx() <= 0){
					barrels.get(i).setdir(1);
				}
				else if(barrels.get(i).getx() + barrels.get(i).getWidth() >= 460){
					barrels.get(i).setdir(-1);
				}
				boolean touchfloor = false;
				for (int j = 0; j < 9; j++){
					if (floors[j].contact(barrels.get(i))){
						touchfloor = true;
						if (j % 2 == 0)
							barrels.get(i).setdir(1);
						else
							barrels.get(i).setdir(-1);
					}
				}
				barrels.get(i).move(barrels.get(i).getdir(), 0);
				if (!touchfloor){
					barrels.get(i).move(0,1);
				}
			}
			int modifier = 0;
			switch (difficulty){
				case 1:
					modifier = 125;
					break;
				case 2:
					modifier = 150;
					break;
				case 3:
					modifier = 200;
					break;
				case 4:
					modifier = 250;
					break;
				case 5: 
					modifier = 300;
					break;
				case 6:
					modifier = 350;
					break;
				case 7:
					modifier = 350;
					break;
				case 8:
					modifier = 50;
					break;
				default:
					modifier = 100;
					break;
			}
			if (bcount %  modifier == 0){
				barrels.add(new Barrel(70, 60));
			}
			repaint();	
		}	
	}

    /*
      private class Dialogue implements runnable
      public void run()
      SwingUtilities.invokeLater(new Dialogue())
     */
    private class Dialogue implements Runnable{
        @Override
        public void run(){
            if (JOptionPane.showConfirmDialog(null, "Would you like to add your score to the top ten?", "Score Check", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String initials = JOptionPane.showInputDialog("What are you first two initials");
                int score = scorecount;
                t.checkScore(new Player(initials, score));
                try{
                    t.Save(new File("data.txt"));
                }
                catch(IOException e){}
                JOptionPane.showMessageDialog(null, "Top Ten\n" + t.toString());
            }
            else{
                JOptionPane.showMessageDialog(null, "Thanks for playing");
                JOptionPane.showMessageDialog(null, "Top Ten\n" + t.toString());
            }
            JOptionPane.showMessageDialog(null, "Top Ten\n" + t.toString());
            if (JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Restart", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                try{
                    reset();
                }
                catch(IOException e){}
            }
        }
    }
    private class LoseDialogue implements Runnable{
        @Override
        public void run(){
            JOptionPane.showMessageDialog(null, "Thanks for playing");
            JOptionPane.showMessageDialog(null, "Top Ten\n" + t.toString());
            if (JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Restart", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                try{
                    reset();
                }
                catch(IOException e){}
            }
        }
    }
	private class MyKeyListener implements KeyListener{
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode() == 68) {
				mflag = 1;
				if (m.getx() + m.getWidth() >= 460){
					mflag = 0;
				}
			}
			else if (e.getKeyCode() == 65) {
				mflag = -1;
				if (m.getx() <= 0){
					mflag = 0;
				}
				//m.move(-5,0);
			}
			if (e.getKeyCode() == 87 && flag == 1){
				flag = 3;
				for (int i = 0; i < 9; i++){
					if (ladders[i].contacts(m)){
						flag = 4;
					}
				}
			}	
		}
		public void keyReleased(KeyEvent e){
        if (e.getKeyCode() == 68 || e.getKeyCode() == 65 || e.getKeyCode() == 87 && flag == 4){
				mflag = 0;
			}
		}
		public void keyTyped(KeyEvent e){}

	}

}
