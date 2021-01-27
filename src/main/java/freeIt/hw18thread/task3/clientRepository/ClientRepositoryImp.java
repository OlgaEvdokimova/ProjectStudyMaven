package freeIt.hw18thread.task3.clientRepository;

import freeIt.hw18thread.task3.client.Client;

import freeIt.hw18thread.task3.purchase.Purchase;
import freeIt.hw18thread.task3.validator.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class ClientRepositoryImp implements ClientRepository {
    public static final String PATH = "D:\\Java\\IdeaProjects\\ProjectStudyMaven\\src\\main\\java\\freeIt\\hw18thread\\task3\\files\\list.txt";
    public static Logger logger = LoggerFactory.getLogger(ClientRepositoryImp.class.getName());

    private static final int NAME = 1;
    private static final int ID = 0;
    private static final int EMAIL = 2;

    public static List<Client> getClients() {  // static because I use it in ClientCreator
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
            logger.error("Check your file" + e.getMessage());

        }
        return clients;
    }

    @Override
    public void addClient(Client client) {
        List<Client> clientList = getClients();
        try (FileWriter fw = new FileWriter(PATH)) {
            for (Client s : clientList) {
                fw.write(s.toString());
                fw.write("\n");
            }
            fw.write(client.toString());
            logger.info(client.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Purchase> getPurchaseListById(String id) {
        Validator.parseInt(id);
        List<Client> clientList = getClients();
        return clientList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst().orElseThrow(() -> new NoSuchElementException("No client with id: " + id)).getPurchaseList();

    }

    @Override
    public Optional<Client> getByEmail(String email) {
        Validator.validEmail(email);
        List<Client> clientList = getClients();
        return Optional.ofNullable(clientList.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst().orElse(null));

    }
}

// email regex [\w+\-\.]+@\w+\.\w{2,4}
// [\w+@?\-\.]+ any pattern in line

