package producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author tuhin
 * @project javaSocketProgramming
 * @createdAt 7/10/21 at 10:27 PM
 **/

public class ProducerConsumerApplication {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(4);
        Producer producerOne = new Producer(queue,"Sheff 1");
        Producer producerTwo = new Producer(queue,"Sheff 2");
        Consumer consumerOe = new Consumer(queue, "Consumer1");
        Consumer consumerTwo = new Consumer(queue, "Consumer2");
        Consumer consumerThree = new Consumer(queue, "Consumer3");


    }
}
