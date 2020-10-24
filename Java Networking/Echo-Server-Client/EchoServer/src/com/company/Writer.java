package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Writer extends Echoer {
    String Message;
    public Writer(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        System.out.println("Writer thread of server Executed");
        try {

            PrintWriter output=new PrintWriter(super.socket.getOutputStream(),true);
            while (true){
                System.out.print("Message to Client No."+clientid+" :");
                Scanner scanner=new Scanner(System.in);
                Message=scanner.nextLine();
                output.println(Message);
                if(Message.equals("close")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
