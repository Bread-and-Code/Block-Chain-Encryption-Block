import java.io.*;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
    public static int difficulty;

	public static void main(String[] args)throws IOException {	
	
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Block1: ");
        String b1 = r.readLine();
        System.out.println("Block2: ");
        String b2 = r.readLine();
        System.out.println("Block3: ");
        String b3 = r.readLine();
        System.out.println("Enter Difficulty Level: ");
        difficulty = Integer.parseInt(r.readLine());

        blockchain.add(new Block(b1, "0"));	
        System.out.println("Trying to Mine block 1... ");
        blockchain.get(0).mineBlock(difficulty);
        	
        blockchain.add(new Block(b2, blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block(b3, blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(difficulty);
        
        System.out.println("\nBlockchain is Valid: " + isChainValid());

		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);
    }
    
    public static Boolean isChainValid() {
        Block currentBlock; 
        Block previousBlock;
        
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //registered hash =? calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");			
                return false;
            }
            //previous hash =? registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
