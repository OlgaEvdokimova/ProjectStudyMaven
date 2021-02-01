package testTasks.taskUrl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.function.Consumer;

public class Request implements Runnable {
    private String url;
    public Consumer<byte[]> callback;

    public Request(String url) {
        this.url = url;
    }

    public void execute() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Google", url);
            ByteArrayInputStream bf = new ByteArrayInputStream(connection.getInputStream().readAllBytes());
            ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
            int result;
            while ((result = bf.read()) != -1) {
                byteArrayOS.write((byte) result);
            }
            byte[] byteArray = byteArrayOS.toByteArray();
            callback.accept(byteArray);

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
