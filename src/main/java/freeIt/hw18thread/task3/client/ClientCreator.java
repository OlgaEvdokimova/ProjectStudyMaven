package freeIt.hw18thread.task3.client;

import freeIt.hw18thread.task3.FileReaderGetClientsUtil;
import freeIt.hw18thread.task3.purchase.Purchase;
import freeIt.hw18thread.task3.scannerUtil.ScannerUtil;
import freeIt.hw18thread.task3.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class ClientCreator {

    public static Client createClient(){
        List<Client> listOfClients = FileReaderGetClientsUtil.getClients();
        Client client = new Client();
        client.setId((String.valueOf(listOfClients.size() + 1)));
        System.out.println("New client name");
        client.setName(ScannerUtil.scannerString());
        System.out.println("Email");
        String email = ScannerUtil.scannerString();
        if (Validator.validEmail(email)) {
            client.setEmail(email);
        }
        List<Purchase> purchaseList = new ArrayList<>();
        while (true) {
            System.out.println("Do u wanna add purchase (add + or -)");
            if (ScannerUtil.scannerString().equalsIgnoreCase("+")) {
                System.out.println("Write purchase");
                purchaseList.add(new Purchase(ScannerUtil.scannerString()));
            } else {
                break;
            }
        }
        client.setPurchaseList(purchaseList);
        return client;
    }
}
