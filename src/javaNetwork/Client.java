package javaNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        /**
         * crate a socket with destination server IP 7 port
         *
         */
        System.out.println("Client Started..");
        Socket socket = new Socket("127.0.0.1", 22222);
        System.out.println("Client connected..");

        ObjectOutputStream clientOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream clientInputStream = new ObjectInputStream(socket.getInputStream());


        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        // send to server
        clientOutputStream.writeObject(message);


        //Object fromServer = null;
        try {
            // receive from server
            Object fromServer = clientInputStream.readObject();
            System.out.println("Finally Get from Server: " + (String) fromServer);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
