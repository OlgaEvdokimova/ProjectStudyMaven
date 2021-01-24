package freeIt.hw19.task2;
import java.util.concurrent.Semaphore;

public class Port {
    private int capacity;
    private int currentCapacity;
    private int dockCount;
    private static Semaphore semaphore = new Semaphore(1);

    public Port(int capacity, int currentCapacity, int dockCount) {
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
        this.dockCount = dockCount;
    }

    public void getPermission() {
        try {

                if (dockCount > 0 && dockCount <= 3) {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " got permission from dock " + dockCount);
                    dockCount--;
                }

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public void addContainer(){
        currentCapacity++;
    }
    public void removeContainer(){
        currentCapacity--;
    }

    public void returnPermission() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        dockCount++;
        System.out.println(Thread.currentThread().getName() + " is leaving dock.");
        semaphore.release();

    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getDockCount() {
        return dockCount;
    }

    public void setDockCount(int dockCount) {
        this.dockCount = dockCount;
    }

    @Override
    public String toString() {
        return "Port{" +
                "capacity=" + capacity +
                ", currentCapacity=" + currentCapacity +
                ", dockCount=" + dockCount +
                '}';
    }
}
