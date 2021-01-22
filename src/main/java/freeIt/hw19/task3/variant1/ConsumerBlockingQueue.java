package freeIt.hw19.task3.variant1;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ConsumerBlockingQueue implements Runnable {
    private BlockingQueue<Integer> queue;

    public ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                    System.out.println("Take " + queue.take());
                    System.out.println("Queue size is " + queue.size());
                    System.out.println(queue);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
