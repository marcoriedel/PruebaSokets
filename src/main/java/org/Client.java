package org;

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

        try {
            InputStream stream = System.in;
            Scanner scanner = new Scanner(stream);
            System.out.println("IP/Server Name:");
            String host = scanner.next();

            System.out.println("Puerto:");
            String port = scanner.next();
            System.out.println("Conectando al Server:" + host + " Port: " + port);

            Socket socket = new Socket(host, Integer.parseInt(port));
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            int rta =in.read();
            if(rta > 0)
            System.out.println("Conexion Realizada a " + socket.getInetAddress().getHostName());
            System.out.println("Mensaje:");
            String msj = scanner.next();

            out.write(msj.getBytes());

            socket.close();

        }catch (Exception ex){
            System.out.println("Error de conexion valide host o puerto ingresado.");;
        }

    }
}
