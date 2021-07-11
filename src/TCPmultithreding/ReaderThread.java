package TCPmultithreding;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;

/**
 * @author tuhin
 * @project javaSocketProgramming
 * @createdAt 7/11/21 at 6:52 AM
 **/

public class ReaderThread implements Runnable{

    String name;
    ObjectInputStream inputStream;
    Thread thread;


    public ReaderThread(ObjectInputStream inputStream, String name) {
        this.inputStream = inputStream;
        this.name = name;
         new Thread(this).start();;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // read from server
                Object fromServer = inputStream.readObject();
                System.out.println(name+"  got " + (String) fromServer);
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }


    }
}
