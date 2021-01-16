package freeIt.hw18thread.task1;

public class NewThread extends Thread{
    @Override
    public void run() {
       for (int i = 0; i < 100; i++){
           System.out.println(getName() + " " + i);
       }
    }
}
