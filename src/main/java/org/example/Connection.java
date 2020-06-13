package org.example;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection extends Thread {

    Socket socket;

    public Connection(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            InputStream inputStream = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String content = "";

            while ((content = reader.readLine()) != null){
                System.out.println(content);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
