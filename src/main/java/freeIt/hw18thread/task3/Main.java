package freeIt.hw18thread.task3;

import freeIt.hw18thread.task3.Client.Client;
import freeIt.hw18thread.task3.Client.ClientCreator;
import freeIt.hw18thread.task3.Purchase.Purchase;
import freeIt.hw18thread.task3.ClientRepository.ClientRepositoryImp;
import freeIt.hw18thread.task3.exceptions.NotNumberException;
import freeIt.hw18thread.task3.exceptions.WrongEmailException;
import freeIt.hw18thread.task3.scannerUtil.ScannerUtil;
import freeIt.hw18thread.task3.validator.Validator;

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


    public static void main(String[] args) {
        ClientRepositoryImp clientRepositoryImp = new ClientRepositoryImp();
        Optional<List<Client>> clientListOpt = Optional.ofNullable(FileReaderGetClientsUtil.getClients());
        List<Client> clientList = clientListOpt.get();
        if (Validator.clientListSizeNotEmpty(clientList)) {
// достаю клиентов из списка
            for (Client c : clientList) {
                System.out.println(c);
            }
        }
        System.out.println("1 - добавить нового покупателя со списком покупок ");
        System.out.println("2 - по id покупателя найти список его покупок");
        System.out.println("3 - по email найти покупателя");
        switch (ScannerUtil.scannerString()) {
            case "1":
                clientRepositoryImp.addClient(ClientCreator.createClient());
                break;
            case "2":

                System.out.println("Input ID");
                String id = ScannerUtil.scannerString();
                if (Validator.parseInt(id)) {
                    List<Purchase> purchaseList = clientRepositoryImp.getPurchaseListById(id);
                    purchaseList.forEach(System.out::println);
                }
                break;
            case "3":
                System.out.println("Input Email");
                String email = ScannerUtil.scannerString();
                if (Validator.validEmail(email)) {
                    Optional<Client> clientByEmail = clientRepositoryImp.getByEmail(email);
                    if (clientByEmail.isPresent()) {
                        System.out.println(clientByEmail.get());
                    } else {
                        System.out.println("No such client");
                    }
                }
                break;
        }

    }
}

