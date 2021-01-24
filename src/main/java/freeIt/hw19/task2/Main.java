package freeIt.hw19.task2;

public class Main {
    /**
     * Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров,
     * находящихся в текущий момент в порту и на корабле, должно быть неотрицательным и
     * превышающим заданную грузоподъемность судна и вместимость порта. В порту работает
     * несколько причалов. У одного причала может стоять один корабль. Корабль может
     * загружаться у причала, разгружаться или выполнять оба действия.
     */
    public static void main(String[] args) {
        Port port = new Port(1000, 0, 3);
        Thread ship1 = new Thread(new Ship(port, 300, 0));
        Thread ship2 = new Thread(new Ship(port, 250, 0));
        Thread ship3 = new Thread(new Ship(port, 200, 0));
        Thread ship4 = new Thread(new Ship(port, 300, 0));
        Thread ship5 = new Thread(new Ship(port, 150, 0));

        Thread ship6 = new Thread(new Ship(port, 80, 10));
        Thread ship7 = new Thread(new Ship(port, 200, 150));
        Thread ship8 = new Thread(new Ship(port, 0, 250));
        Thread ship9 = new Thread(new Ship(port, 0, 300));
        Thread ship10 = new Thread(new Ship(port, 80, 0));

        ship1.start();
        ship2.start();
        ship3.start();
        ship4.start();
        ship5.start();
        ship6.start();
        ship7.start();
        ship8.start();
        ship9.start();
        ship10.start();

        try {
            ship1.join();
            ship2.join();
            ship3.join();
            ship4.join();
            ship5.join();
            ship6.join();
            ship7.join();
            ship8.join();
            ship9.join();
            ship10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All ships have finished their task");
    }

}
// вывод
//Thread-0 got permission from dock 3
//Thread-0 has finished, current capacity100
//Thread-0 is leaving dock.
//Thread-1 got permission from dock 3
//Thread-1 has finished, current capacity350
//Thread-1 is leaving dock.
//Thread-2 got permission from dock 3
//Thread-2 has finished, current capacity550
//Thread-2 is leaving dock.
//Thread-3 got permission from dock 3
//Thread-3 has finished, current capacity850
//Thread-3 is leaving dock.
//Thread-4 got permission from dock 3
//Thread-4 has finished, current capacity1000
//Thread-4 is leaving dock.
//Thread-5 got permission from dock 3
//Thread-5 is waiting                       <-- здесь перегруз, ждем
//Thread-5 is leaving dock.
//Thread-6 got permission from dock 3
//Thread-6 is waiting                       <-- здесь перегруз, ждем
//Thread-6 is leaving dock.
//Thread-7 got permission from dock 3
//Thread-7 has finished, current capacity750
//Thread-7 is leaving dock.
//Thread-8 got permission from dock 3
//Thread-8 has finished, current capacity450
//Thread-8 is leaving dock.
//Thread-9 got permission from dock 3
//Thread-9 has finished, current capacity530
//Thread-9 is leaving dock.
//Thread-5 got permission from dock 3
//Thread-5 has finished, current capacity600
//Thread-5 is leaving dock.
//Thread-6 got permission from dock 3
//Thread-6 has finished, current capacity650
//Thread-6 is leaving dock.
//All ships have finished their task
