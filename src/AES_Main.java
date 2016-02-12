import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;


final public class AES_Main {

	public static void main(String[] args) throws IOException {
		
		HelperFunctions hf= new HelperFunctions(); 
		AES_Encryption_Functions aef= new AES_Encryption_Functions();
		AES_Decryption_Functions adf = new AES_Decryption_Functions();
		SecureRandom sr = new SecureRandom();
		AES_Runner aes=new AES_Runner();
		
		//generate the random byte matrix
		byte[][] a=new byte[4][4];
		System.out.println("Enter a plaintext you want to encrypt--- ");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		a=hf.generateRandomHexMatrix(s);
		
		//String s="2b7e151628aed2a6abf7158809cf4f3c";
		
		byte[] key = hf.generateKey(32);
		
		a[0][0]=(byte)0x32;a[0][1]=(byte)0x88;a[0][2]=(byte)0x31;a[0][3]=(byte)0xe0;
		a[1][0]=(byte)0x43;a[1][1]=(byte)0x5a;a[1][2]=(byte)0x31;a[1][3]=(byte)0x37;
		a[2][0]=(byte)0xf6;a[2][1]=(byte)0x30;a[2][2]=(byte)0x98;a[2][3]=(byte)0x07;
		a[3][0]=(byte)0xa8;a[3][1]=(byte)0x8d;a[3][2]=(byte)0xa2;a[3][3]=(byte)0x34;
			//32 43 f6 a8 88 5a 30 8d 31 31 98 a2 e0 37 07 34
		System.out.println(" ");
		System.out.println("----------------Message Matrix------------------");	
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++)
					System.out.print(Integer.toHexString(a[i][j] & 0xff)+ " ");
				System.out.println();
			}
			
		a=aes.Encrypt(a, key);
		key = hf.generateKey(32);
		System.out.println("Do you wish to decrypt? (y/n)");
		String answer = br.readLine();
		System.out.println("Enter the key for decryption-----");
		String entered_key = br.readLine();
		aes.Decrypt(a, key);
		/*if(answer.equalsIgnoreCase("y")){
			System.out.println("Enter the key for decryption-----");
			String entered_key = br.readLine();
			if(entered_key.length()!=32){
				System.out.println("Invalid key length!!!! Exiting...");	
			
			}
*/
	
		}
			/*
		a=aef.AddRoundKeyFirst(a, key);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key1=aef.GenerateRoundKey(a, key, 1);
		a=aef.AddRoundKey(a, key1);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key2=aef.GenerateRoundKey(a, key1, 2);
		a=aef.AddRoundKey(a, key2);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key3=aef.GenerateRoundKey(a, key2, 3);
		a=aef.AddRoundKey(a, key3);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key4=aef.GenerateRoundKey(a, key3, 4);
		a=aef.AddRoundKey(a, key4);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key5=aef.GenerateRoundKey(a, key4, 5);
		a=aef.AddRoundKey(a, key5);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key6=aef.GenerateRoundKey(a, key5, 6);
		a=aef.AddRoundKey(a, key6);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key7=aef.GenerateRoundKey(a, key6, 7);
		a=aef.AddRoundKey(a, key7);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key8=aef.GenerateRoundKey(a, key7, 8);
		a=aef.AddRoundKey(a, key8);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		byte[] key9=aef.GenerateRoundKey(a, key8, 9);
		a=aef.AddRoundKey(a, key9);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		//a=aef.MixColumns(a);
		byte[] key10=aef.GenerateRoundKey(a, key9, 10);
		a=aef.AddRoundKey(a, key10);
		System.out.println("--------------Encryption ends---------------------");
		*/
		/*	
		//Decryption
		//key=hf.generateKey(32);
		a=aef.AddRoundKeyFirst(a, key10);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 9);
		a=aef.AddRoundKey(a, key9);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 8);
		a=aef.AddRoundKey(a, key8);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 7);
		a=aef.AddRoundKey(a, key7);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 6);
		a=aef.AddRoundKey(a, key6);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 5);
		a=aef.AddRoundKey(a, key5);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 4);
		a=aef.AddRoundKey(a, key4);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 3);
		a=aef.AddRoundKey(a, key3);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 2);
		a=aef.AddRoundKey(a, key2);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		//key=aef.GenerateRoundKey(a, key, 1);
		a=aef.AddRoundKey(a, key1);
		a=adf.InvMixColumns(a);
		a=adf.InvShiftRows(a);
		a=adf.InvSubBytes(a);
		a=aef.AddRoundKeyFirst(a, key);
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//key=aef.GetRoundKeyPrev(key);
		//a = aef.ShiftRows(msg);
		//a = adf.InvShiftRows(a);
		//a=adf.InvSubBytes(a);
		//a=aef.SubBytes(a);
		//a=aef.ShiftRows(a);
		//a=aef.MixColumns(a);
		
		//a=aef.AddRoundKey(a, key, iteration)
		/*for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				System.out.print(Integer.toHexString(a[i][j] & 0xff)+ " ");
			System.out.println();
		}*/	
		}
	
	
	


