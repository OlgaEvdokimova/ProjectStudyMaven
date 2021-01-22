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
//заполняется коллекция и как будто монитор не отпускается, висит,
// Consumer не может элемент взять. Не понимаю почему/ Я запускала много раз
        // и 1 раз словила, элементы взялись до пустой коллекции и снова повисло
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
        }
    }
}
//вот оно заполнилось и начинает удадялть
// интересен момент стрелкой отмеченный ( я ловила такое несколько раз)
//[5]
//[5, 4]
//[5, 4, 6]
//[5, 4, 6, 3]
//[5, 4, 6, 3, 10]
//[5, 4, 6, 3, 10, 5]
//[5, 4, 6, 3, 10, 5, 10]
//[5, 4, 6, 3, 10, 5, 10, 8]
//[5, 4, 6, 3, 10, 5, 10, 8, 6]
//[5, 4, 6, 3, 10, 5, 10, 8, 6, 6]
//Take 10                             <----- какое take 10 откуда оно?
//Queue size is 10
//[5, 4, 6, 3, 10, 5, 10, 8, 6, 6]
//Take 5                             <----- тут take 5 с головы понятно
//Queue size is 9
