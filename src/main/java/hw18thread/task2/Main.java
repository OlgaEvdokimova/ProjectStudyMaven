package hw18thread.task2;

public class Main {
    /**
     * vСоздать класс, реализующий интерфейс Runnable. Переопределить run() метод. Создать
     * цикл for. В цикле распечатываем значения от 0 до 100 делящиеся на 10 без остатка.
     * Используем статический метод Thread.sleep() чтобы сделать паузу. Создать три потока,
     * выполняющих задачу распечатки значений.
     */
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new NewThread());
            thread.start();
        }
    }
}
