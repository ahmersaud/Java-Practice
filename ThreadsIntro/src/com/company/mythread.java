package com.company;

public class mythread implements Runnable{
    private String mythreadmsg;
    private Thread thread;
    public mythread(String mythreadmsg) {
        this.mythreadmsg = mythreadmsg;
        thread=new Thread(this,mythreadmsg);
        thread.start();

    }


    @Override
    public void run() {
        System.out.println("Starting " +mythreadmsg);
        for (int count = 0;count<10;count++){
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(mythreadmsg+" counting "+count);
        }
        System.out.println(mythreadmsg+" terminated");

    }
}
