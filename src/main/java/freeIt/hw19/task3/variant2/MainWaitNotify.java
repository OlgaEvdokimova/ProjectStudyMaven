package freeIt.hw19.task3.variant2;
import java.util.LinkedList;
import java.util.Queue;

public class MainWaitNotify {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        ProducerWaitNotify p = new ProducerWaitNotify(queue);
        ConsumerWaitNotify c = new ConsumerWaitNotify(queue);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
        }
    }
}
