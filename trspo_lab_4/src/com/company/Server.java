package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static ServerSocket server;
    public static Socket socket;
    public static BufferedReader reader;
    public static BufferedWriter writer;

    public static void main(String[] args) {
        try{

            try{
                server = new ServerSocket(4004); //Server listen port 0
                //Server is running
                socket = server.accept(); //accept() wait for new connection

                try{
                    //thread output\input for connect server & client
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Accept messages
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //Sent messages
                    writer.flush(); //out buffer
                } finally {
                    //close threads and socket
                    socket.close();
                    reader.close();
                    writer.close();
                }

            } finally {
                server.close();
            }

        }catch (IOException ie){
            System.err.println(ie);
        }

    }
}
