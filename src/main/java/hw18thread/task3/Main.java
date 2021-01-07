package hw18thread.task3;

import hw18thread.task3.exceptions.EmptyFileException;
import hw18thread.task3.exceptions.NotNumberException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class gitMain {
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
//достаю список(Стринг) из файла
        Optional<List<Client>> clientListOpt = Optional.ofNullable(ClientRepository.getClients(PATH));
        List<Client> clientList = clientListOpt.get();
        if (clientList.size() == 0) {
           throw new EmptyFileException("File is empty");
        } else {
// достаю клиентов из списка
            for (Client c : clientList) {
                System.out.println(c);
            }
//добавляю Клиента в список Клиентов
           // ClientRepository.addClient(clientList);

            System.out.println("Input ID");
            Scanner sc = new Scanner(System.in);
            try {
                int n = Integer.parseInt(sc.nextLine());
                List<Purchase> purchaseList = ClientRepository.getById(n,clientList);
                System.out.print("List of purchase of client with id " + n  + " : ");
                for (Purchase p : purchaseList){
                    System.out.print(p + " ");
                }
            } catch (NumberFormatException e){
                throw new NotNumberException(" Not a number, input a number");
            }

        }
    }
}
