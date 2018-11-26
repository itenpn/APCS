import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index{

    public static void main(String[] args){
        Font f = new Font("TimesRoman", Font.PLAIN, 30); 
        JFrame GUI = new JFrame();
        GUI.setTitle("Complex Numbers");
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setSize(500,500);
        Container pane = GUI.getContentPane();
        pane.setLayout(new GridLayout(0,2));
        JLabel output = new JLabel("");
        output.setSize(500,200);
        JLabel info1 = new JLabel("First Complex");
        info1.setFont(f);
        JLabel info2 = new JLabel("Second Complex");
        info2.setFont(f);
        JTextField input1 = new JTextField();
        input1.setFont(f);
        JTextField input2 = new JTextField();
        input2.setFont(f);
        pane.add(info1);
        pane.add(info2);
        pane.add(input1);
        pane.add(input2);
        JButton addBut = new JButton("+");
        JButton subBut = new JButton("-");
        JButton multBut = new JButton("x");
        JButton divBut = new JButton("/");
        JButton powBut = new JButton("^");
        JButton rootBut = new JButton("root");
        JButton copyBut = new JButton("copy");
        JButton dataBut = new JButton("conj");
        addBut.setFont(f);
        subBut.setFont(f);
        multBut.setFont(f);
        divBut.setFont(f);
        powBut.setFont(f);
        rootBut.setFont(f);
        copyBut.setFont(f);
        dataBut.setFont(f);
        output.setFont(f);
        addBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                CompNum c2 = new CompNum(input2.getText());
                output.setText(c1.add(c2).toString());
            }
        });
        subBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                CompNum c2 = new CompNum(input2.getText());
                output.setText(c1.sub(c2).toString());
            }
        });
        multBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                CompNum c2 = new CompNum(input2.getText());
                output.setText(c1.mult(c2).toString());
            }
        });
        divBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                CompNum c2 = new CompNum(input2.getText());
                output.setText(c1.div(c2).toString());
            }
        });
        powBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                double c2 = Double.parseDouble(input2.getText());
                output.setText(c1.pow(c2).toString());
            }
        });
        rootBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                double c2 = Double.parseDouble(input2.getText());
                c2 = 1 / c2;
                output.setText(c1.pow(c2).toString());
            }
        });
        copyBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                CompNum c2 = new CompNum(c1);
                input2.setText(c2.toString());
            }
        });
        dataBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                input2.setText("");
                output.setText(c1.conjugate().toString());
            }
        });
        pane.add(addBut);
        pane.add(subBut);
        pane.add(multBut);
        pane.add(divBut);
        pane.add(powBut);
        pane.add(rootBut);
        pane.add(copyBut);
        pane.add(dataBut);
        pane.add(output);
        GUI.setVisible(true);
    }

}
