package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Textfield implements ActionListener {
    JTextField jTextField;
    JButton reverseButton;
    JLabel promptLabel;
    JLabel contentLabel;

    Textfield(){
        JFrame jFrame=new JFrame("TextField");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(250,120);

        //creating a text field
        jTextField=new JTextField(10);
        jTextField.setActionCommand("textfield");
        jTextField.addActionListener(this);

        reverseButton=new JButton("reverse");
        reverseButton.addActionListener(this);

        promptLabel=new JLabel("Enter Text:");
        contentLabel=new JLabel("");

        //add to jFrame
        jFrame.add(promptLabel);
        jFrame.add(jTextField);
        jFrame.add(reverseButton);
        jFrame.add(contentLabel);

        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("reverse")){
            //reverse the string
            String original=jTextField.getText();
            String holder = "";

            for (int i = original.length()-1;i>=0;i--){
                holder += original.charAt(i);
            }
            contentLabel.setText("Reversed text: "+ holder);

        }else{
            contentLabel.setText("You have presses Enter and the Text is :"+jTextField.getText());

        }

    }
}
