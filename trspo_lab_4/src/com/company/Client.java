package com.company;

import java.io.*;
import java.net.Socket;

public class Client {

    public static Socket socket;
    public static BufferedReader reader;
    public static BufferedReader accept;
    public static BufferedWriter writer;

    public static void main(String[] args) {
        try {
            try {
                socket = new Socket("localhost", 4004); //call server
                accept = new BufferedReader(new InputStreamReader(System.in)); //accept for server connection
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //accept messages
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //sent messages
                writer.flush(); //out buffer
            } finally {
                //closed thread and socket
                socket.close();
                reader.close();
                writer.close();
            }
        } catch (IOException ie) {
            System.err.println(ie);
        }
    }
}
