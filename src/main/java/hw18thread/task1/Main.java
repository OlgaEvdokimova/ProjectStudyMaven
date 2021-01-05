package hw18thread.task1;

public class Main {
    /**
     Создать класс NewThread расширяющий Thread. Переопределить метод run(). В цикле for
     вывести на консоль символ 100 раз. Создать экземпляр класса и запустить новый поток.
     */
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
