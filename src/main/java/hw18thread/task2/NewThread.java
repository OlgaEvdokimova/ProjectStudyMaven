package hw18thread.task2;

public class NewThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 10 == 0){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
