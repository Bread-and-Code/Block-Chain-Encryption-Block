import java.util.Date;
import java.security.MessageDigest;

public class Block{

    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;

    public Block(String data, String previousHash){
        
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash(){
	    
        String calculatedhash = applySha256( previousHash + Long.toString(timeStamp) + data );
	    return calculatedhash;
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