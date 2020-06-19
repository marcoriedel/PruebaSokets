package org;

import java.io.*;
import java.net.Socket;

public class Connection extends Thread {

    Socket socket;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
    }

    public void run(){
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(1);


            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String content = "";

            while ((content = reader.readLine()) != null){
                System.out.println("From "+socket.getInetAddress().getHostName()+": "+content);
            }


            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
