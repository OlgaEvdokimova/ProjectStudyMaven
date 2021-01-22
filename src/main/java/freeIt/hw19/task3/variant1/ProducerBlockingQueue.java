package freeIt.hw19.task3.variant1;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ProducerBlockingQueue implements Runnable{
    private BlockingQueue<Integer> queue;

    public ProducerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt(11));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
