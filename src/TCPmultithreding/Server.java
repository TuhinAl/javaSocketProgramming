package TCPmultithreding;

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

        ServerSocket serverSocket = new ServerSocket(22223);
        System.out.println("server started");

        /**
         * kew jodi server socket er sathe connect hoite chai taile server socket accept krbe and
         * dedicated socket create krbe
         * Server jeno ekbar data send kore boshe na thake tai eta while loop e rakhbo
         */

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected..");
            // new Server Thread Started ...
            new ServerThread(socket);

        }
    }
}

class ServerThread implements Runnable {

    // Socket pass korar jonno constructor create krte hbe

    Socket clientSocket;
    Thread thread;

    public ServerThread(Socket socketClient) {
        clientSocket = socketClient;
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        // new Server Thread Start


        /**
         * all incoming InputStream and OutputStream coming from client side took in server side
         *
         */


        /**
         * and read the message from input stream
         *
         */
        try {
            // jotokkhon prjnto client er sathe connected ache totokkhon prjnto ei kaj gula krte thakbe

            while (true) {
                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

                Object clientMessage = inputStream.readObject();
                if (clientMessage == null) {
                    break;
                }
                System.out.println("from client message: " + (String) clientMessage);

                String msg = (String) clientMessage;

                msg = msg.toUpperCase();

                /**
                 * send to Client
                 */

            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
