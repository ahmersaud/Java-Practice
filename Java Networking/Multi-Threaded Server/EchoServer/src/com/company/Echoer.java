package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread{  //this class is created to create a multithreaded server responding to more than one clients
    private Socket socket;
    public  Echoer(Socket socket){
        this.socket=socket;
    }


    @Override
    public void run() {
        try{

            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output=new PrintWriter(socket.getOutputStream(),true);
            while(true){
            String echostring=input.readLine();
            String ip=socket.getRemoteSocketAddress().toString(); //getting the ip of the client
                System.out.println("Received Client Input:From "+ip+":"+ echostring);
            if(echostring.equals("exit")){
                break;
            }
            output.println("Echo from Server:"+echostring);

        }}
        catch (IOException e ){
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
                System.out.println("Client Disconnected" );
            }catch (IOException e){
                System.out.println("Error in Disconnecting the client");
            }
        }
    }
}
