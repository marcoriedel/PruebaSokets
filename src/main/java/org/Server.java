package org;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main (String args[]) throws IOException{
        new Server().run();
    }

    ServerSocket serverSocket;

    public void run() throws IOException {
        serverSocket = new ServerSocket(3000);
        System.out.println("Esperando conexiones");

        while (true) {
           Socket socket = serverSocket.accept();
           System.out.println("Nueva Conexion" + socket.getInetAddress().getHostName());
           Connection client = new Connection(socket);
           client.start();
        }

    }
}
