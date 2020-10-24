package com.company;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //   SwingDemo swingDemo=new SwingDemo();  //general method of creating an object of a class

        //Creating the frame on event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login ();
            }
        });

        //Swing event handling code runs on a special thread known as the event dispatch thread.
        // Most code that invokes Swing methods also runs on this thread.
        // This is necessary because most Swing object methods are not "thread safe": invoking them
        // from multiple threads risks thread interference or memory consistency errors.
        // Some Swing component methods are labelled "thread safe" in the API specification;
        // these can be safely invoked from any thread.
        // All other Swing component methods must be invoked from the event dispatch thread.
        // Programs that ignore this rule may function correctly most of the time, but are subject
        // to unpredictable errors that are difficult to reproduce.
    }
}
