package blockchain;

import java.util.ArrayList;

public class Blockchain {

    private ArrayList<Block> chain;

    public Blockchain() {

        chain = new ArrayList<>();

        // Genesis Block
        chain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {

        return new Block("0");
    }

    // Get latest block
    public Block getLatestBlock() {

        return chain.get(chain.size() - 1);
    }

    // Add new block
    public void addBlock(Block newBlock) {

        chain.add(newBlock);
    }

    // Validate Blockchain
    public boolean isChainValid() {

        Block currentBlock;

        Block previousBlock;

        for (int i = 1; i < chain.size(); i++) {

            currentBlock = chain.get(i);

            previousBlock = chain.get(i - 1);

            // Validate current hash
            if (!currentBlock.getHash()
                    .equals(currentBlock.calculateHash())) {

                return false;
            }

            // Validate previous hash link
            if (!currentBlock.getPreviousHash()
                    .equals(previousBlock.getHash())) {

                return false;
            }
        }

        return true;
    }

    // Display Blockchain
    public void displayChain() {

        for (Block block : chain) {

            System.out.println("\n====================");

            System.out.println(
                    "Previous Hash: "
                    + block.getPreviousHash());

            System.out.println(
                    "Current Hash: "
                    + block.getHash());

            System.out.println("Transactions:");

            block.getTransactions()
                    .forEach(System.out::println);
        }
    }
}