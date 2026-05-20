package model;

public class Expense {

    private String title;
    private double amount;
    private String category;
    private String type;

    public Expense(String title, double amount,
                   String category, String type) {

        this.title = title;
        this.amount = amount;
        this.category = category;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }
}