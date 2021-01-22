package freeIt.hw19.task3.variant2;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class ConsumerWaitNotify implements Runnable{
    private Queue<Integer> queue;

    public ConsumerWaitNotify(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
               while (queue.size() == 0){
                   try {
                       wait();
                   } catch (InterruptedException e) {
                       System.out.println("Thread is interrupted");
                   }
               }
                System.out.println("Take " + queue.poll());
                System.out.println("Queue size is " + queue.size());
                System.out.println(queue);
                this.notify();
            }

        }
    }


}
