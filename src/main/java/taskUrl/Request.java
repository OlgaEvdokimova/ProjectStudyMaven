package taskUrl;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.function.Consumer;

public class Request implements  Runnable{
    private  String url;
    public Consumer<byte[]> callback;

    public Request(String url) {
        this.url = url;
    }
    public void execute(){
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            URLConnection urlConnection = new URL(url).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
