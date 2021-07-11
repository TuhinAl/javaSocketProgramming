package TCPmultithreding;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * @author tuhin
 * @project javaSocketProgramming
 * @createdAt 7/11/21 at 7:03 AM
 **/

public class WriterThread implements Runnable{

    ObjectOutputStream outputStream;
    String name;

    public WriterThread(ObjectOutputStream outputStream, String name) {
        this.outputStream = outputStream;
        this.name = name;
        new Thread(this).start();

    }

    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            String msg = sc.nextLine();
            try {
                outputStream.writeObject(msg);
                System.out.println("Message sent");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
