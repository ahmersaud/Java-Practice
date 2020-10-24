package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread{
    public static int clientNumber=0;
    protected int clientid;
    protected Socket socket;
    public Echoer(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        clientNumber++;
        clientid=clientNumber;
        System.out.println("Client Number:"+clientNumber+" connected");
        Echoer echoer1=new Reader(this.socket);
        Echoer echoer2=new Writer(this.socket);
        echoer1.start();
        echoer2.start();

//        try{
//            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter output=new PrintWriter(socket.getOutputStream(),true);
//
//            while (true){
//                String echostring=input.readLine();
//                if(echostring.equals("exit")){
//                    break;
//                }
//                output.println("Echo from Server:"+echostring);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
