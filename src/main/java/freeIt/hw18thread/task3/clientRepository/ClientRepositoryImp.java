package freeIt.hw18thread.task3.clientRepository;

import freeIt.hw18thread.task3.client.Client;
import freeIt.hw18thread.task3.FileReaderGetClientsUtil;
import freeIt.hw18thread.task3.purchase.Purchase;

import java.io.*;
import java.util.*;

public class ClientRepositoryImp implements ClientRepository {
    public static final String PATH = "D:\\Java\\IdeaProjects\\ProjectStudyMaven\\src\\main\\java\\freeIt\\hw18thread\\task3\\files\\list.txt";


    @Override
    public void addClient(Client client) {
        List<Client> clientList = FileReaderGetClientsUtil.getClients();
        try (FileWriter fw = new FileWriter(PATH)) {
            for (Client s : clientList) {
                fw.write(s.toString());
                fw.write("\n");
            }
            fw.write(client.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public  List<Purchase> getPurchaseListById(String id) {
        List<Client> clientList = FileReaderGetClientsUtil.getClients();
        List<Purchase> purchaseList = clientList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst().orElseThrow(() -> new NoSuchElementException("No client with id: " + id)).getPurchaseList();
        if (purchaseList.size() == 0) {
            System.out.println("no purchases");
        }
        return purchaseList;
    }

    @Override
    public  Optional<Client> getByEmail(String email) {
        Client client;
        List<Client> clientList = FileReaderGetClientsUtil.getClients();
        return Optional.ofNullable(clientList.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst().orElse(null));
    }
}

// email regex [\w+\-\.]+@\w+\.\w{2,4}
// [\w+@?\-\.]+ any pattern in line
