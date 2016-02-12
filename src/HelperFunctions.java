import java.security.SecureRandom;
import java.util.Random;

public class HelperFunctions {

	Random r = new Random();
	
	public byte[][] generateRandomHexMatrix(String s){
		int length =32;
		StringBuffer sb = new StringBuffer();
		while(sb.length() < length){
			sb.append(Integer.toHexString(r.nextInt()));
		}
		//String s1="6745431628aed2a6abf7158809cf4f3c";
		 String s1=(s.substring(0, length));
		//System.out.println("string s1:"+s1);
		int len = 32;
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s1.charAt(i), 16) << 4)
	                             + Character.digit(s1.charAt(i+1), 16));
	       // System.out.print(Integer.toHexString(data[i/2] & 0xFF));
	    }
	    int k=0;
	    byte[][] a =new byte[4][4];
	    System.out.println("Message matrix generated: ");
	    for(int i =0;i<4;i++){
	    	for(int j=0;j<4;j++)
	    	{
	    		a[i][j]=data[k];
	    		k++;
	    		System.out.print(Integer.toHexString(a[i][j] & 0xFF)+" ");
	    		
	    	}
	    System.out.println();
	}
	    
	    
	    return a;
		
	}
	
	public byte[] generateKey(int length){
		
		StringBuffer sb = new StringBuffer();
		while(sb.length() < length){
			sb.append(Integer.toHexString(r.nextInt()));
		}
		//String s1=(sb.toString().substring(0, length));
		String s1="2b7e151628aed2a6abf7158809cf4f3c";
	int len = length;
    byte[] data = new byte[len / 2];
    System.out.println("Generated Key: ");
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s1.charAt(i), 16) << 4)
                             + Character.digit(s1.charAt(i+1), 16));
        System.out.print(Integer.toHexString(data[i/2] & 0xFF));
    }
    System.out.println();
    return data;
	}
	
	
	
	
	
	
}
