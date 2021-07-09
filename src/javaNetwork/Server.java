package javaNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /**
         * (1) first need to create a server socket, for listen  with which port that socket open
         * (2) connection request come from client side and need to put this request in a Socket in Server
         * (3) may through exception cz socket may occupy/off/already in use
         */

        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("server started");

        /**
         * kew jodi server socket er sathe connect hoite chai taile server socket accept krbe and
         * dedicated socket create krbe
         * Server jeno ekbar data send kore boshe na thake tai eta while loop e rakhbo
         */

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected..");

            /**
             * all incoming InputStream and OutputStream coming from client side took in server side
             *
             */

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            /**
             * and read the message from input stream
             *
             */
            try {
                Object clientMessage = inputStream.readObject();
               System.out.println("from client message: " + (String) clientMessage);

                String msg = (String) clientMessage;

                msg = msg.toUpperCase();

                /**
                 * send to Client
                 */
                objectOutputStream.writeObject(msg);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
