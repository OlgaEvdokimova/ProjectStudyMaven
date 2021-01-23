package freeIt.hw19.task3.variant2;
import java.util.Queue;
import java.util.Random;

public class ProducerWaitNotify implements Runnable{
    private Queue<Integer> queue;
    private static final int CAPACITY = 10;

    public ProducerWaitNotify(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            synchronized (queue) {
                while (queue.size() >= CAPACITY){
                    try {
                       queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Thread is interrupted");
                    }
                }
                queue.offer(random.nextInt(11));
                System.out.println(queue);
                queue.notify();

            }
        }
    }
}
