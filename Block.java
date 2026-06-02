package blockchain;

import transaction.Transaction;
import utils.SHA256Helper;

import java.util.ArrayList;
import java.util.Date;

public class Block {

    private String hash;

    private String previousHash;

    private ArrayList<Transaction> transactions;

    private long timeStamp;

    private int nonce;

    public Block(String previousHash) {

        this.previousHash = previousHash;

        this.transactions = new ArrayList<>();

        this.timeStamp = new Date().getTime();

        this.hash = calculateHash();
    }

    // Calculate Hash
    public String calculateHash() {

        String data =
                previousHash +
                timeStamp +
                nonce +
                transactions.toString();

        return SHA256Helper.hash(data);
    }

    // Add Transaction
    public void addTransaction(Transaction transaction) {

        transactions.add(transaction);

        hash = calculateHash();
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}