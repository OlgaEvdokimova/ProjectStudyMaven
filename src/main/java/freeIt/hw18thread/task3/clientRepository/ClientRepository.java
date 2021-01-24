package freeIt.hw18thread.task3.clientRepository;

import freeIt.hw18thread.task3.client.Client;
import freeIt.hw18thread.task3.purchase.Purchase;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void addClient(Client client);
    List<Purchase> getPurchaseListById(String id);
    Optional<Client> getByEmail(String email);
}
