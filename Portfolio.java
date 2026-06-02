package model;

import java.util.HashMap;

public class Portfolio {

    private HashMap<String, Integer> holdings =
            new HashMap<>();

    public void buyStock(String symbol, int qty) {

        holdings.put(symbol,
                holdings.getOrDefault(symbol, 0) + qty);
    }

    public void sellStock(String symbol, int qty) {

        if (holdings.containsKey(symbol)) {

            int currentQty = holdings.get(symbol);

            if (currentQty >= qty) {

                holdings.put(symbol,
                        currentQty - qty);
            }
        }
    }

    public void displayPortfolio() {

        System.out.println("\n===== Portfolio =====");

        for (String stock : holdings.keySet()) {

            System.out.println(
                    stock +
                    " : " +
                    holdings.get(stock)
            );
        }
    }
}