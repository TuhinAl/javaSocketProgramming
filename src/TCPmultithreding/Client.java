package TCPmultithreding;

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
        Socket socket = new Socket("127.0.0.1", 2222);
        System.out.println("Client connected..");

        ObjectOutputStream clientOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream clientInputStream = new ObjectInputStream(socket.getInputStream());


        new ReaderThread(clientInputStream, "Client1");
        new WriterThread(clientOutputStream, "Client1");

      /*  while (true) {
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();
            if (message.equals("exit")) {
                break;
            }
            // send to server
            clientOutputStream.writeObject(message);
        }*/


        // loop theke ber hye ashbe
        socket.close();

    }
}
