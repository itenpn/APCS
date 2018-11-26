
public class Player{

    private String initials;
    private int score;

    public Player(){
        this("",0);
    }

    public Player(String i, int s){
        score = s;
        initials = i;
    }

    public void setInitials(String i){
        initials = i;
    }

    public void setScore(int s){
        score = s;
    }

    public String getInitials(){
        return initials;
    }

    public int getScore(){
        return score;
    }

    public String toString(){
        return initials + ": " + Integer.toString(score);
    }

}