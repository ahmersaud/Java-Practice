package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader extends Echoer{
    public Reader(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        System.out.println("Reader thread of client executed");
        try {
            BufferedReader input=new BufferedReader(new InputStreamReader(super.socket.getInputStream()));
            String response;
            while (true){
                response=input.readLine();
                System.out.println("Message from Server: "+response);
                if(response.equals("close")){
                    break;
                }
            }
        }catch (IOException e){

        }
    }
}
