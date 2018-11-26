public class Schedule{
    private double balance, interest, principal, payment, remaining;
    private int month;

    public Schedule(int mon, double bal, double inter, double princi, double pay, double remain){
        month = mon;
        balance = bal;
        interest = inter;
        principal = princi;
        payment = pay;
        remaining = remain;
    }

    public String toString(){
        String str = String.format("%-10d %10s %10s %10s %10s %10s",
                                   month,
                                   String.format("$%.2f",balance),
                                   String.format("$%.2f",interest),
                                   String.format("$%.2f",principal),
                                   String.format("$%.2f", payment),
                                   String.format("$%.2f",remaining));
        return str;
    }

}
