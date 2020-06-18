package org;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main (String args[]) throws IOException{
        new Server().run();
    }

    ServerSocket serverSocket;

    public void run() throws IOException {

        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        System.out.println("En que puerto escuchara el server:");
        String port = scanner.next();
        serverSocket = new ServerSocket( Integer.parseInt(port));
        System.out.println("Esperando conexiones en el puerto "+port);

        while (true) {
           Socket socket = serverSocket.accept();
           System.out.println("Nueva Conexion " + socket.getInetAddress().getHostName());
           Connection connection = new Connection(socket);
           connection.start();

        }

    }
}
