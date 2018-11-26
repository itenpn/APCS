import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class KeyListen implements java.awt.event.KeyListener{

    private Canvas Parent;

    public KeyListen(Canvas x){
        Parent = x;
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e){
            Parent.handleDisplay();
            Parent.clicked();
    }
    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}
}