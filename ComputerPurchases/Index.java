import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Index{

    public static void main(String[] args){
        double price = Double.parseDouble(JOptionPane.showInputDialog("What is the input price?"));
        double downpay = price * .1;
        double monthpay = (price - downpay) * .05;
        double interest = 0;
        double due = price - downpay;
        int month = 0;
        double principal;
        Schedule[] output = new Schedule[100];
        double duebefore;
        String title = String.format("%-10s %10s %10s %10s %10s %10s\n", "Month #", "Balance", "Interest", "Principal", "Payment", "Remaining");
        output[0] = new Schedule(0, price, 0, downpay, downpay, price - downpay);
        month++;
        while (due > 0){
            interest = due * .12/12;
            principal = monthpay - interest;
            due += interest;
            if (due - monthpay < 0){
                monthpay = due;
                principal = monthpay - interest;
            }
            duebefore = due;
            due -= monthpay;
            output[month] = new Schedule(month, duebefore, interest, principal, monthpay, due);
            month++;
        }
        JFrame GUI = new JFrame("Monthly Payment Schedule");
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setSize(500,1000);
        Container pane = GUI.getContentPane();
        JTextArea text = new JTextArea();
        text.append(title);
        for (int i = 0; i < month; i++){
            text.append(output[i].toString() + "\n");
        }
        pane.add(text);
        GUI.setVisible(true);
        System.out.print(title);
        for (int i = 0; i < month; i++){
            System.out.println(output[i].toString());
        }
    }

}
