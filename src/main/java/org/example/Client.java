package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) throws IOException {
        new Client().runClient();
    }

    public void runClient() throws IOException {

        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        System.out.println("IP/ServerName:");
        String host = scanner.next();

        System.out.println("Puerto:");
        String port = scanner.next();
        System.out.println("Server:" + host + " Port: " + port);

        Socket socket = new Socket(host, Integer.parseInt(port));
        OutputStream out = socket.getOutputStream();


        System.out.println("Mensaje:");
        String msj = scanner.next();

        out.write(msj.getBytes());
        socket.close();
    }
}
