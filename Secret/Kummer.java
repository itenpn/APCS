public class Kummer{

    private int foodLevel;
    private int waterLevel;

    public Kummer(){
        waterLevel = 0;
        foodLevel = 0;
    }

    public Kummer(int lbFood, int ozWater){
        foodLevel = lbFood;
        waterLevel = ozWater;
    }

    public void consume(int lbFood){
        foodLevel += lbFood;
    }

    public void drink(int ozWater){
        waterLevel += ozWater;
    }

    public boolean isFull(){
        if (foodLevel >= 90)
            return true;
        else
            return false;
    }

    public boolean isHydrated(){
        if (waterLevel >= 90)
            return true;
        else
            return false;
    }

    public void timePasses(){
        foodLevel -= 20;
        waterLevel -= 20;
    }

    public String status(){
        String str = "Full: " + isFull() + "\n";
        str += "Hydrated: " + isHydrated();
        return str;
    }

}