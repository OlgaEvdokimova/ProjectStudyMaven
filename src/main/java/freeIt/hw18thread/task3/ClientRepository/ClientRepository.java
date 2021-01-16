package freeIt.hw18thread.task3.ClientRepository;

import freeIt.hw18thread.task3.Client.Client;
import freeIt.hw18thread.task3.Purchase.Purchase;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void addClient(Client client);
    List<Purchase> getPurchaseListById(String id);
    Optional<Client> getByEmail(String email);
}
