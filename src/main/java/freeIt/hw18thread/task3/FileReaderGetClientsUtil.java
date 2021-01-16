package freeIt.hw18thread.task3;

import freeIt.hw18thread.task3.Client.Client;
import freeIt.hw18thread.task3.Purchase.Purchase;
import freeIt.hw18thread.task3.exceptions.FileNotFoundExceptionOrOtherProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderGetClientsUtil {
    public static final String PATH = "D:\\Java\\IdeaProjects\\ProjectStudyMaven\\src\\main\\java\\freeIt\\hw18thread\\task3\\files\\list.txt";

    private static final int NAME = 1;
    private static final int ID = 0;
    private static final int EMAIL = 2;
    public static List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        String line;
        try (BufferedReader bf = new BufferedReader(new FileReader(PATH))) {
            while ((line = bf.readLine()) != null) {
                List<Purchase> purchaseList = new ArrayList<>();
                String[] splitLine = line.split("[^\\w@\\.-]+");
                Client client = new Client();
                client.setId(splitLine[ID]);
                client.setName(splitLine[NAME]);
                client.setEmail(splitLine[EMAIL]);
                if (splitLine.length > 3) {
                    for (int j = 3; j < splitLine.length; j++) {
                        purchaseList.add(new Purchase(splitLine[j]));
                    }
                }
                client.setPurchaseList(purchaseList);
                clients.add(client);

            }
        } catch (IOException e) {
            System.out.println("Problem with reading");
            throw new FileNotFoundExceptionOrOtherProblem("File not found , check your file");
        }
        return clients;
    }
}
