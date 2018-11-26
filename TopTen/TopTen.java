import java.io.*;
import java.util.Scanner;

public class TopTen{

    private Player[] p = new Player[10];
    private int nump;

    public TopTen(){
        for (int i = 0; i < 10; i++){
            p[i] = new Player();
        }
        nump = 0;
    }

    public TopTen(File f) throws IOException{
        Scanner r = new Scanner(f);
        int i = 0;
        while(r.hasNext()){
            String init = r.next();
            int sc = r.nextInt();
            p[i] = new Player(init, sc);
            i++;
        }
        nump = i;
        r.close();
    }

    public void Save(File f) throws IOException{
        PrintWriter pw = new PrintWriter(f);
        for (int i = 0; i < nump; i++){
            pw.println(p[i].getInitials());
            pw.println(p[i].getScore());
        }
        pw.close();
    }

    private void Sort(){
        for (int i = 0; i < nump; i++){
            for (int j = i; j < nump; j++){
                if (p[i].getScore() < p[j].getScore()){
                    Player temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }

    public void checkScore(Player test){
        if (nump < 10){
            p[nump] = test;
            nump++;
            Sort();
        }
        Sort();
        int pos = 11;
        for (int i = 0; i < nump; i++){
            if (test.getScore() > p[i].getScore()){
                pos = i;
                break;
            }
        }
        if (pos < 11){
            for (int i = 9; i > pos; i--){
                p[i] = p[i - 1];
            }
            p[pos] = test;
        }
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < nump; i++){
            str += p[i].toString() + "\n";
        }
        return str;
    }

}
