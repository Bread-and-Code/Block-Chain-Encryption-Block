import java.io.*;

public class NoobChain {

	public static void main(String[] args)throws IOException {
		
		String s1, s2, s3;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Block 1: ");
        s1 = r.readLine();
        System.out.println("Enter Block 2: ");
        s2 = r.readLine();
        System.out.println("Enter Block 3: ");
        s3 = r.readLine();
        
        Block genesisBlock = new Block(s1, "0");
		System.out.println("Hash for block 1 : " + genesisBlock.hash);
		
		Block secondBlock = new Block(s2, genesisBlock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		
		Block thirdBlock = new Block(s3, secondBlock.hash);
		System.out.println("Hash for block 3 : " + thirdBlock.hash);
		
	}
}