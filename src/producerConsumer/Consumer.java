package producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author tuhin
 * @project javaSocketProgramming
 * @createdAt 7/10/21 at 10:26 PM
 **/

public class Consumer implements Runnable{

    String name;
    BlockingQueue<String> queue;
    Thread thread;

    public Consumer(BlockingQueue<String> queue, String name) {
        thread = new Thread(this,name);
        this.name = name;
        this.queue = queue;
        thread.start();

    }

    @Override
    public void run() {


        while (true) {
            try {
                if (queue.size() == 0) {
                    System.out.println( "There is no food: ");
                    Thread.sleep(2000);

                }
                System.out.println(name + " eat " + queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
