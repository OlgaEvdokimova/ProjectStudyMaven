package hw18thread.task3;

import hw18thread.task3.exceptions.EmptyFileException;
import hw18thread.task3.exceptions.NotNumberException;
import hw18thread.task3.exceptions.WrongEmailException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Optional<List<Client>> clientListOpt = Optional.ofNullable(ClientRepository.getClients(PATH));
        List<Client> clientList = clientListOpt.get();
        if (clientList.size() == 0) {
            throw new EmptyFileException("File is empty");
        } else {
// достаю клиентов из списка
            for (Client c : clientList) {
                System.out.println(c);
            }
            System.out.println("1 - добавить нового покупателя со списком покупок ");
            System.out.println("2 - по id покупателя найти список его покупок");
            System.out.println("3 - по email найти покупателя");
            Scanner sc = new Scanner(System.in);
            String c = sc.nextLine();
            switch (c) {
                case "1":
                    ClientRepository.addClient(PATH);
                    break;
                case "2":

                    System.out.println("Input ID");
                    try {
                        String id = sc.nextLine();
                        int n = Integer.parseInt(id);
                        Optional<List<Purchase>> purchaseList = ClientRepository.getPurchaseListById(id, PATH);
                        System.out.print("List of purchase of client with id " + n + " : ");
                        purchaseList.ifPresent(System.out::println);
                    } catch (NumberFormatException e) {
                        throw new NotNumberException(" Not a number, input a number");
                    }
                    break;
                case "3":
                    System.out.println("Input Email");
                    String email = sc.next();
                    Pattern pattern = Pattern.compile("[\\w+\\-\\.]+@\\w+\\.\\w{2,4}");
                    Matcher matcher = pattern.matcher(email);
                    if (!matcher.find()) {
                        throw new WrongEmailException("wrong email: login consists from [A-Za-z][0-9] . - _");
                    }
                    Optional<Client> clientByEmail = ClientRepository.getByEmail(email, PATH);
                    clientByEmail.ifPresent(System.out::println);
                    break;
            }


        }
    }
}
