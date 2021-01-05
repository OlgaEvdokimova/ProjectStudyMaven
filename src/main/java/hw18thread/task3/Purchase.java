package hw18thread.task3;

import java.util.Objects;

public class Purchase {
    private String purchaseName;

    public Purchase(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(purchaseName, purchase.purchaseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseName);
    }

    @Override
    public String toString() {
        return purchaseName;
    }
}
