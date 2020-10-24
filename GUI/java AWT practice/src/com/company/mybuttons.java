package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mybuttons extends Frame implements ActionListener {
    Panel panel;
    Label label;
    Button yes,no,maybe;

    mybuttons(){
        addWindowListener(new mywindowadpater());
        panel = new Panel();
        yes= new Button("Yes");
        no=new Button("No");
        maybe=new Button("May be");
        label = new Label("Press a button");

        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);
        panel.add(yes);
        panel.add(no);
        panel.add(maybe);
        panel.add(label);
        add(panel);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
    String str =e.getActionCommand();
    if (str.equals("Yes")){
        label.setText("You have pressed YES");
    }
    else if (str.equals("No")){
        label.setText("You have pressed NO");
    }
    else {
        label.setText("You have pressed Undecided");
    }
    repaint();
    }
}
