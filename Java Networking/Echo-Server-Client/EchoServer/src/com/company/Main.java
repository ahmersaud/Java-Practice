package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try(ServerSocket serverSocket=new ServerSocket(5000)){
            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");
                Echoer echoer=new Echoer(socket);
                echoer.start();
            }
      }catch(IOException e){
            System.out.println("Server Exception:"+e.getMessage());
        }

    }
}
