package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Reader extends Echoer{
    public Reader(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        System.out.println("Reader thread of server Executed");
        try {
            BufferedReader input=new BufferedReader(new InputStreamReader(super.socket.getInputStream()));
            while (true){
                String echostring=input.readLine();
                InetAddress addr = socket.getInetAddress();
                String ip=addr.getHostAddress();
                System.out.println("Message From Client:"+ip+":"+echostring);
                if(echostring.equals("close")){
                    break;
                }
        }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }}
