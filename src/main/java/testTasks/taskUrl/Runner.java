package testTasks.taskUrl;

import java.io.UnsupportedEncodingException;

public class Runner {
    /**
     реальная задача - асинхронный сетевой запрос. При помощи UrlConnection можно скачать, например,
     главную страницу гугла. Но сам этот запрос выполняется синхронно, то есть в потоке, который его вызывает.
     Вот делается отдельный класс, который инициализируется урлом, у него так же сть метод start с параметром лямбдой,
     которая будет принимать byte[] (любой ответ от сервера - это массив байт).
     Ну и этот запрос выполняется асинхронно в отдельном потоке и дёргает лямбду по завершению
     Лямбда - это поле запроса, ты запросу устанавливаешь лямбду, которая будет вызвана по его выполнению
     */
    public static void main(String[] args) throws InterruptedException {
        Request request = new Request("https://google.com");
        request.callback = (byte[] data) -> {
            try {
                System.out.println(new String(data, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        };
        request.execute();
        Thread.sleep(10000);

    }
}
