package model;

public class Transaction {

    private String type;
    private String stock;
    private int quantity;
    private double total;

    public Transaction(String type,
                       String stock,
                       int quantity,
                       double total) {

        this.type = type;
        this.stock = stock;
        this.quantity = quantity;
        this.total = total;
    }

    @Override
    public String toString() {

        return type +
                " | " +
                stock +
                " | Qty: " +
                quantity +
                " | ₹" +
                total;
    }
}