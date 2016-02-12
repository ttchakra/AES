import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;


final public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		byte[] b = "shkjdhkd".getBytes();
		String s= Hex.encodeHexString(b);
		//System.out.println(s);
		
		char[] a = "0201".toCharArray();
		//byte[] row= decodeHex(a);
			Random r = new Random();
	        StringBuffer sb = new StringBuffer();
	        while(sb.length() < 32){
	            sb.append(Integer.toHexString(r.nextInt()));
	        }
	        String[][] s2 = new String[4][4];
	        int count=0;
	      String s1=(sb.toString().substring(0, 32));
	      //System.out.println(sb.toString().substring(0,32));
	      byte a1[];
	      byte b1[];

	      
	      //byte c[] = outputStream.toByteArray( );
	      byte m= (byte)0xbf;
	      byte n = (byte)0x02;
	      byte x=(byte)((m*n)^(0x1b));
	      byte y=(byte) ((n>> 7)& 0x01);
	      //System.out.println(Integer.toHexString((y) & 0xFF));
	      byte temp =(byte) ((m>> 7)& 0x01);
			System.out.println("temp: "+(Integer.toHexString(temp & 0xFF)) );
			if(temp==1)
				System.out.println("Success");
			
			
			
	    for(int i =0;i<4;i++)
	    	for(int j =0;j<4;j++){
	    		s2[i][j]=s1.substring(count,count+2);
	    		count=count+2;
	    		}
	    for(int i =0;i<4;i++)
	    	for(int j =0;j<4;j++){
	    		System.out.println(s2[i][j]);
	}}

}
