package freeIt.hw19.task3.variant1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainBlockingQueue {
    /**
     * Имеются один или несколько производителей, генерирующих данные некоторого типа
     * (например, числа) и помещающих их в коллекцию, а также единственный потребитель,
     * который извлекает помещенные в коллекцию элементы по одному. Необходимо
     * организовать безоопасный доступ к коллекции.
     */
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        ProducerBlockingQueue producer = new ProducerBlockingQueue(queue);
        ConsumerBlockingQueue consumer = new ConsumerBlockingQueue(queue);
        Thread t1 = new Thread(producer);
        t1.start();
        Thread t2 = new Thread(consumer);
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
        }


    }
}
