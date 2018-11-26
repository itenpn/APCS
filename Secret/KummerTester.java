public class KummerTester{

    public static void main(String[] args){
        Kummer god = new Kummer();
        god.consume(50);
        god.drink(20);
        System.out.println(god.status());
    }

}