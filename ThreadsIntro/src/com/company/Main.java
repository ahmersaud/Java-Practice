package com.company;

public class Main {

    public  static void main(String[] args) {
	// write your code here
        System.out.println("Main Thread Starting");
        mythread thread1=new mythread("Thread #1");
//        Thread thread=new Thread(thread1);   already did this in constructor of mythread
//        thread.start();
        mythread thread2=new mythread("Thread #2");

        for(int i =0;i<=10;i++){

            System.out.println("........");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }

}
