package com.company;

import java.net.Socket;

public class Echoer extends Thread {

    protected Socket socket;
    public Echoer(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {

        Echoer echoer1=new Reader(this.socket);
        Echoer echoer2=new Writer(this.socket);
        echoer1.start();
        echoer2.start();




}}
