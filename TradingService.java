package service;

import model.Portfolio;
import model.Stock;
import model.Transaction;

import java.util.ArrayList;

public class TradingService {

    private Portfolio portfolio =
            new Portfolio();

    private ArrayList<Transaction> history =
            new ArrayList<>();

    public void buyStock(Stock stock, int qty) {

        double total =
                stock.getPrice() * qty;

        portfolio.buyStock(
                stock.getSymbol(),
                qty);

        history.add(
                new Transaction(
                        "BUY",
                        stock.getSymbol(),
                        qty,
                        total));

        System.out.println(
                "Bought " + qty +
                " shares of " +
                stock.getSymbol());
    }

    public void sellStock(Stock stock, int qty) {

        double total =
                stock.getPrice() * qty;

        portfolio.sellStock(
                stock.getSymbol(),
                qty);

        history.add(
                new Transaction(
                        "SELL",
                        stock.getSymbol(),
                        qty,
                        total));

        System.out.println(
                "Sold " + qty +
                " shares of " +
                stock.getSymbol());
    }

    public void showPortfolio() {

        portfolio.displayPortfolio();
    }

    public void showHistory() {

        System.out.println(
                "\n===== Transaction History =====");

        history.forEach(System.out::println);
    }
}