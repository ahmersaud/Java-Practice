package com.company;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
  mybuttons win = new mybuttons();
  win.setTitle("Buttons");
  win.setSize(300,250);
  win.setVisible(true);

    }
}

class mywindowadpater extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e) {
       System.exit(0);
    }
}
