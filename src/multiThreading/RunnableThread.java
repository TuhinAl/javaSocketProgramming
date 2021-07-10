package multiThreading;

class NewThread implements Runnable {

    Thread thread;
    int threadNo;

    public NewThread(int threadNo) {
        thread = new Thread(this, "Runnable Thread: ");
         this.threadNo = threadNo;
        thread.start();

    }

    @Override
    public void run() {
        for (int n = 5; n > 0; n--) {
            System.out.println(threadNo +" Thread value: " + n);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.out.println(threadNo +" Child thread interrupted");

            }
        }
        System.out.println("Thread Exit: ");

    }
}


public class RunnableThread {
    public static void main(String[] args) {
        System.out.println("Main thread started ");
        NewThread newThread = new NewThread(1);
        NewThread newThread2 = new NewThread(2);
        System.out.println("Main thread exited: " + newThread.thread.isAlive());
        System.out.println("Thread 1 is alive: "+ newThread2.thread.isAlive());

        try {
            newThread.thread.join();
            newThread2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
