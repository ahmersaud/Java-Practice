package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     try (Socket socket=new Socket("127.0.0.1",5555)){
        try{
         socket.setSoTimeout(15000); //if the socket did not get a response from the server till 15 seconds then the control will be shifted to catch method i-e socketTimeoutException
         // declaring the IO's
         BufferedReader echoes=new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter stringtoecho = new PrintWriter(socket.getOutputStream(),true);

         //declaring the scanners to get client's  and message from the console
         Scanner scanner1=new Scanner(System.in);
         String echostring;
         String response; // this string is used to get the response from the server


         do{
             System.out.println("Enter the String to be Echoed");
             echostring=scanner1.nextLine(); //getting the client's message

             stringtoecho.println( echostring);
             if(!echostring.equals("exit")){   // this condition is used to terminate the thread for this client in server
                 response=echoes.readLine();
                 System.out.println(response);
            }
         }while(!echostring.equals("exit"));} // this condition is used to terminate the thread for this client in server
        catch (SocketTimeoutException e ){
            System.out.println("Socket Timed Out");
        }
     }catch (IOException e){
         System.out.println("Failed to establish a connection");
     }
    }
}
