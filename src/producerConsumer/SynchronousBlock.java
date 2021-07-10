package producerConsumer;

/**
 * @author tuhin
 * @project javaSocketProgramming
 * @createdAt 7/11/21 at 12:55 AM
 **/
class Printer {
    void printAssignments(Person person) {
        System.out.println("Printing started...");

        for (int i = 0; i < person.page; i++) {
            System.out.println(person.name + " ---->Printing..--->" + (i + 1));
        }
        System.out.println("Printing Completed");
    }

}

class Person implements Runnable {
    String name;
    int page;
    final Printer printer;
    Thread thread;

    public Person(String name, Printer printer, int page) {
        this.name = name;
        this.printer = printer;
        this.page = page;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {

        synchronized (printer) {
            printer.printAssignments(this);
        }


    }


}

public class SynchronousBlock {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Person tanvir = new Person("Tanvir", printer, 5);
        Person saima = new Person("Saima", printer, 7);
    }

}
