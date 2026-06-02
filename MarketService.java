package service;

import model.Stock;

import java.util.HashMap;
import java.util.Random;

public class MarketService {

    private HashMap<String, Stock> market =
            new HashMap<>();

    public MarketService() {

        market.put("TCS",
                new Stock("TCS", 3500));

        market.put("INFY",
                new Stock("INFY", 1600));

        market.put("RELIANCE",
                new Stock("RELIANCE", 2800));
    }

    // Simulate price changes
    public void updatePrices() {

        Random random = new Random();

        for (Stock stock : market.values()) {

            double change =
                    -50 + random.nextDouble() * 100;

            stock.setPrice(
                    stock.getPrice() + change);
        }
    }

    public void displayMarket() {

        System.out.println("\n===== Market Prices =====");

        for (Stock stock : market.values()) {

            System.out.println(
                    stock.getSymbol()
                    + " : ₹"
                    + String.format("%.2f",
                    stock.getPrice()));
        }
    }

    public Stock getStock(String symbol) {

        return market.get(symbol);
    }
}