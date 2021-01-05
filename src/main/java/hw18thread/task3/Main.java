package hw18thread.task3;

import hw18thread.task3.exceptions.EmptyFileException;

import java.util.List;
import java.util.Optional;

public class Main {
    /**
     * В текстовом файле лежат данные о покупателях и их покупках (в любом удобном формате).
     * Создать классы Клиент (покупатель) и Покупка. Создать класс ClientRepository, в котором
     * разместить методы для работы с файлом: добавить нового покупателя со списком покупок, по
     * id покупателя найти список его покупок, по email найти покупателя (учитывать то, что
     * покупателя с нужным id или email может не быть, использовать Optional для возвращаемых
     * значений методов). Написать класс main с использованием методов класса ClientRepository.
     */
    public static final String PATH = "D:\\Java\\IdeaProjects\\ProjectStudyMaven\\src\\main\\java\\hw18thread\\task3\\list.txt";

    public static void main(String[] args) {
        List<String> stringList = null;
//достаю список(Стринг) из файла
        Optional<List<String>> list = Optional.ofNullable(ClientRepository.readFile(PATH));
        if (list.isEmpty()) {
           throw new EmptyFileException("File is empty");
        } else {
            stringList = list.get();

// достаю клиентов из списка
            List<Client> clientList = ClientRepository.getClients(stringList);
            for (Client c : clientList) {
                System.out.println(c);
            }
//добавляю Клиента в список Клиентов
            ClientRepository.addClient(clientList);

        }
    }
}
