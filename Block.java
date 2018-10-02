import java.util.Date;
import java.security.MessageDigest;

public class Block extends time_encrypto{

    public String hash;
    public String previousHash;
    private String data;
    private String timeStamp;
    private int nonce;

    public Block(String data, String previousHash){
        
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = time_encrypto.gettime();
        this.hash = calculateHash();
        System.out.println("String for blocks : " + data + previousHash + timeStamp); 
    }

    public String calculateHash(){
	    
        String calculatedhash = applySha256( previousHash + timeStamp + Integer.toString(nonce) + data );
	    return calculatedhash;
    }
    
    public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}

    public static String applySha256(String input){

        try{
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < hash.length; i++){

                String Hex = Integer.toHexString(0xff & hash[i]);
                if(Hex.length() == 1) 
                    hexString.append('0');
                hexString.append(Hex);
            }
            return hexString.toString();
        }
        catch(Exception e){

            throw new RuntimeException(e);            
        }
    } 
}
