package producerConsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author tuhin
 * @project javaSocketProgramming
 * @createdAt 7/10/21 at 10:13 PM
 **/

public class Producer implements Runnable{

    String name;
    BlockingQueue<String> queue;
    Thread thread;

    public Producer(BlockingQueue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
        thread = new Thread(this, name);
        thread.start();

    }

    @Override
    public void run() {
        System.out.println("Thread Started....");

        int i = 0;
        while (true) {
            try {
                if (queue.size() >= 4) {
                    System.out.println(name+" Queue is full:...");
                    Thread.sleep(2000);
                }

                queue.put("cake: "+i);
                System.out.println(name +" crated cake: "+(i+1));
                i++;
                Thread.sleep(300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
