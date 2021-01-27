package freeIt.hw19.task1;

public class NewThread extends Thread {
    StringBuilder sb;

    NewThread(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void run() {

        synchronized (sb) {
            for (int i = 0; i < 100; i++) {
                System.out.print(sb);
            }
            System.out.println();
            char c = sb.substring(0, 1).charAt(0);
            c += 1;
            sb.setCharAt(0, c);
            //sb.replace(0, 1, String.valueOf(c));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
