import java.security.MessageDigest;

public class StringUtil{
    
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
