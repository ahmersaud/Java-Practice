package com.company;
import javax.swing.*;
import java.awt.FlowLayout;      //this class is just used to keep all the components visible on the canvas


public class SwingDemo {


    SwingDemo(){
        //create a new JFrame container             //consider it as a canvas
        JFrame jFrame=new JFrame("DEMO SWING");

        //specify flow layout for layout manager
        jFrame.setLayout(new FlowLayout());  //passing an object of class FlowLayout

        //Give it a size
        jFrame.setSize(270,100);

        //Jlabel is used to add text to the Jframe
        JLabel jLabel=new JLabel("HelloWorld");

        //Adding JLabel to JFrame
        jFrame.add(jLabel);

        //JButton class is used to create buttons
        JButton jButton=new JButton("Click!!");

        //Adding the button to Jframe
        jFrame.add(jButton);

        //terminate the program when user closes the application
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        //show it
        jFrame.setVisible(true);
    }

}
