package hw18thread.task3;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Client {
    private String id;
    private String name;
    private String email;
    private List<Purchase> purchaseList;

    public Client() {
    }

    public Client(String id, String name, String email, List<Purchase> purchaseList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.purchaseList = purchaseList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(purchaseList, client.purchaseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, purchaseList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(" ").append(name).append(" ").append(email).append(": ");
        for (Purchase p : purchaseList){
            sb.append(p).append(", ");
        }
        return sb.toString();
    }
}
