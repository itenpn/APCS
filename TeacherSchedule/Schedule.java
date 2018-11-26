import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.*;

public class Schedule{

    public static void main(String[] args) throws IOException{
        Salary[] s = new Salary[20];
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 30));

        if (JOptionPane.showConfirmDialog(null, "Would you like to upload an old file?", "Should I load?",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            s = Load();
            LoadOption(s);
        } 
        else{
            noLoadOption(s);
        }        
    }

    public static void LoadOption(Salary[] s) throws IOException{
        int years = Integer.parseInt(JOptionPane.showInputDialog("How many years have you worked in education"));
        Object[] options = {"ba", "ma", "phd"};
        int edu = JOptionPane.showOptionDialog(null, "What is your education level?","Education",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        Save(s);
        if (edu == 0){
            JOptionPane.showMessageDialog(null, "Your salary is: " + Integer.toString(s[years - 1].getBA()));
        }
        else if (edu == 1){
            JOptionPane.showMessageDialog(null, "Your salary is: " + Integer.toString(s[years - 1].getMA()));
        }
        else {
            JOptionPane.showMessageDialog(null, "Your salary is: " + Integer.toString(s[years - 1].getPHD()));
        }
    }

    public static void noLoadOption(Salary[] s) throws IOException{
        int years = Integer.parseInt(JOptionPane.showInputDialog("How many years have you worked in education"));
        Object[] options = {"ba", "ma", "phd"};
        int edu = JOptionPane.showOptionDialog(null, "What is your education level?","Education",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        int start = Integer.parseInt(JOptionPane.showInputDialog("What was your starting salary?"));
        if (edu == 0){
            s[0] = new Salary(1, start, start + 10000, start + 20000);
        }
        else if (edu == 1){
            s[0] = new Salary(1, start - 10000, start, start + 10000);
        }
        else{
            s[0] = new Salary(1, start - 20000, start - 10000, start);
        }
        for (int i = 1; i < 20; i++){
            s[i] = new Salary(1 + i, (int)(s[i-1].getBA() * 1.01), (int)(s[i-1].getMA() * 1.03), (int)(s[i-1].getPHD() * 1.05));
        }
        Save(s);
        if (edu == 0){
            JOptionPane.showMessageDialog(null, "Your salary is: " + Integer.toString(s[years - 1].getBA()));
        }
        else if (edu == 1){
            JOptionPane.showMessageDialog(null, "Your salary is: " + Integer.toString(s[years - 1].getMA()));
        }
        else {
            JOptionPane.showMessageDialog(null, "Your salary is: " + Integer.toString(s[years - 1].getPHD()));
        }
    }

    public static void Save(Salary[] s) throws IOException{
        File file = new File("chart.txt");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("|-------------------------------|");
        bw.newLine();
        bw.write("| #  | B.A.   | M.A.   | PhD    |");
        for (int i = 0; i < 20; i++){
            bw.newLine();
            bw.write("|-------------------------------|");
            bw.newLine();
            bw.write(s[i].toString());
        }
        bw.newLine();
        bw.write("|-------------------------------|");
        bw.close();
    }

    public static Salary[] Load() throws IOException{
        Salary[] s = new Salary[20];
        File file = new File("chart.txt");
        Scanner reader = new Scanner(file);
        reader.nextLine();
        reader.nextLine();
        for (int i = 0; i < 20; i++){
            String str = reader.nextLine();
            String test = str.substring(1,2);
            if (test.equals("-"))
                str = reader.nextLine();
            s[i] = new Salary(str);
        }
        reader.close();
        return s;
    }

}