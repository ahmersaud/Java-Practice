package com.company;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingButtons implements  ActionListener{
    JLabel jLabel;
    SwingButtons(){

        //creating the frame
        JFrame jFrame=new JFrame("Buttons");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(250,150);



        //creating buttons
        JButton up=new JButton("UP");
        JButton down=new JButton("DOWN");

        /* adding Event Listener to the buttons           method # 1 */ //instead of this method the SwingButtons class implement the Actionlistener interface
                                                                 // and then override the actionperformed method inside the constructor
//        up.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Up clicked");
//            }
//        });
//        down.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Down Clicked");
//            }
//        });

        //adding Event Listener to the buttons          method#2
        up.addActionListener(this);
        down.addActionListener(this);

        jLabel=new JLabel("NO Button Pressed");

        //adding buttons to the frame
        jFrame.add(up);
        jFrame.add(down);

        jFrame.add(jLabel);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("UP")){

            jLabel.setText("UP button is pressed");
        }
        else
        {

            jLabel.setText("DOWN button is pressed");
        }
    }
}
