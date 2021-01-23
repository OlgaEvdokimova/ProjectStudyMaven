package freeIt.hw19.task3.variant2;
import java.util.Queue;

public class ConsumerWaitNotify implements Runnable{
    private Queue<Integer> queue;

    public ConsumerWaitNotify(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
               while (queue.size() <= 0){
                   try {
                       queue.wait();
                   } catch (InterruptedException e) {
                       System.out.println("Thread is interrupted");
                   }
               }
                System.out.println("Take " + queue.poll());
                System.out.println("Queue size is " + queue.size());
                System.out.println(queue);
                queue.notify();
            }

        }
    }


}
