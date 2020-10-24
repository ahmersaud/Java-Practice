package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Writer extends Echoer {
    public Writer(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        System.out.println("Writer thread of client Executed");
        try{
            PrintWriter output = new PrintWriter(super.socket.getOutputStream(),true);

            String Message;
            while (true){
                Scanner scanner=new Scanner(System.in);
                System.out.println("Message to the Server");
                Message=scanner.nextLine();
                if(Message.equals("close")){
                    break;
                }
                output.println(Message);


            }

        }catch (IOException e){}
    }
}
