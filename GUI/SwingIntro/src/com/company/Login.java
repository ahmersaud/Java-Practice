package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener{
    private JPanel panel1;
    private JTextField textField1;

    private JButton loginButton;

    Login (){
   JFrame jFrame=new JFrame();
   jFrame.setTitle("Login");
   jFrame.setLayout(new FlowLayout());
   jFrame.setSize(200,250);


        textField1.addActionListener(this);

        loginButton.addActionListener((ActionListener) this);
        jFrame.add(panel1);
        jFrame.add(textField1);

        jFrame.add(loginButton);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

    }
}
