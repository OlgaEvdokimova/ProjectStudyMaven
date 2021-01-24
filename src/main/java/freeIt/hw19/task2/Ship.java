package freeIt.hw19.task2;

public class Ship implements Runnable {

    private Port port;
    private int putBox;
    private int takeBox;

    public Ship(Port port, int putBox, int takeBox) {
        this.port = port;
        this.putBox = putBox;
        this.takeBox = takeBox;
    }

    @Override
    public void run() {
        try {
            // флаг отвечает за то, закончил ли корабль своб разобу(разгрузился и загрузился)
            boolean isFinished = false;

            while (true) {
                if (!isFinished) {
                    port.getPermission();
                }

                if (takeBox != 0 && putBox != 0) {                //если корабль загружается и разгружается
                    synchronized (port) {
                        if (port.getCapacity() >= (port.getCurrentCapacity() + putBox)) {  // если перегруз
                            putBox--;
                            port.addContainer();
                            takeBox--;
                            port.removeContainer();
                            isFinished = true;
                            port.notifyAll();
                        }
                    }
                } else {
                    if (putBox != 0) {            //если корабль  разгружается
                        synchronized (port) {
                            if (port.getCapacity() >= (port.getCurrentCapacity() + putBox)) { // если перегруз
                                putBox--;
                                port.addContainer();
                                isFinished = true;
                                //notify здесь не надо, т к мы только выгружаемся
                            }
                        }
                    } else if (takeBox != 0) {            //если корабль загружается
                        synchronized (port) {
                            if (port.getCapacity() >= (port.getCurrentCapacity() + putBox)) { // если перегруз
                                takeBox--;
                                port.removeContainer();
                                isFinished = true;
                                port.notifyAll();
                            }
                        }
                    } else {                   // если разгрузились и загрузились
                        synchronized (port) {
                            System.out.println(Thread.currentThread().getName() + " has finished" + ", current capacity" + port.getCurrentCapacity());
                            port.returnPermission();
                            port.notifyAll();
                            break;
                        }
                    }
                }

                if (isFinished) {                           // здесь , если еще остались контейнеры , то идем на след круг while
                    Thread.sleep(10);

                } else {                                    // если корабль получил разреш., но перегруз,т.е не попадаем ни в какой синхрониз. if, то отпускаем причал, и ждем.
                    synchronized (port) {
                        System.out.println(Thread.currentThread().getName() + " is waiting");
                        port.returnPermission();
                        port.wait();                                                          //ждем пока кто-то не заберет контейнеры и не вызовет notify

                    }
                }
            }

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public int getTakeBox() {
        return takeBox;
    }

    public void setTakeBox(int takeBox) {
        this.takeBox = takeBox;
    }

    public int getPutBox() {
        return putBox;
    }

    public void setPutBox(int putBox) {
        this.putBox = putBox;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "port=" + port +
                ", takeBox=" + takeBox +
                ", putBox=" + putBox +
                '}';
    }
}
