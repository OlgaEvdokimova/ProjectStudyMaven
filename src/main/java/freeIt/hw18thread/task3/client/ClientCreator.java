package freeIt.hw18thread.task3.client;
import freeIt.hw18thread.task3.clientRepository.ClientRepositoryImp;
import freeIt.hw18thread.task3.purchase.Purchase;
import freeIt.hw18thread.task3.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class ClientCreator {

    public static Client createClient(String name, String email, List<String> purchaseListString) {
        List<Client> listOfClients = ClientRepositoryImp.getClients();
        Client client = new Client();
        client.setId((String.valueOf(listOfClients.size() + 1)));
        client.setName(name);
        while (true) {

            Validator.validEmail(email);
            client.setEmail(email);
            List<Purchase> purchaseList = new ArrayList<>();
            int a = purchaseListString.size();
            while (a != 0) {
                purchaseList.add(new Purchase(purchaseListString.get(a - 1)));
                a--;
            }
            client.setPurchaseList(purchaseList);
            return client;
        }


    }
}

