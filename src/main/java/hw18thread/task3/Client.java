package hw18thread.task3;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Client {
    private int id;
    private String name;
    private List<Purchase> purchaseList;

    public Client() {
    }

    public Client(int id, String name, List<Purchase> purchaseList) {
        this.id = id;
        this.name = name;
        this.purchaseList = purchaseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(purchaseList, client.purchaseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, purchaseList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(" ").append(name).append(": ");
        for (Purchase p : purchaseList){
            sb.append(p).append(", ");
        }
        return sb.toString();
    }
}
