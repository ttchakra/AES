import java.security.SecureRandom;


public class AES_Runner {

	HelperFunctions hf= new HelperFunctions(); 
	AES_Encryption_Functions aef= new AES_Encryption_Functions();
	AES_Decryption_Functions adf = new AES_Decryption_Functions();
	SecureRandom sr = new SecureRandom();
	
	byte[] key1,key2,key3,key4,key5,key6,key7,key8,key9,key10;
	//byte[][] a;
	
	protected byte[][] Encrypt(byte[][] a, byte[] key){
		a=aef.AddRoundKeyFirst(a, key);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key1=aef.GenerateRoundKey(a, key, 1);
		a=aef.AddRoundKey(a, key1);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key2=aef.GenerateRoundKey(a, key1, 2);
		a=aef.AddRoundKey(a, key2);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key3=aef.GenerateRoundKey(a, key2, 3);
		a=aef.AddRoundKey(a, key3);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key4=aef.GenerateRoundKey(a, key3, 4);
		a=aef.AddRoundKey(a, key4);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key5=aef.GenerateRoundKey(a, key4, 5);
		a=aef.AddRoundKey(a, key5);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key6=aef.GenerateRoundKey(a, key5, 6);
		a=aef.AddRoundKey(a, key6);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key7=aef.GenerateRoundKey(a, key6, 7);
		a=aef.AddRoundKey(a, key7);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key8=aef.GenerateRoundKey(a, key7, 8);
		a=aef.AddRoundKey(a, key8);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		a=aef.MixColumns(a);
		key9=aef.GenerateRoundKey(a, key8, 9);
		a=aef.AddRoundKey(a, key9);
		a=aef.SubBytes(a);
		a=aef.ShiftRows(a);
		//a=aef.MixColumns(a);
		key10=aef.GenerateRoundKey(a, key9, 10);
		a=aef.AddRoundKey(a, key10);
		System.out.println("--------------Encryption ends---------------------");
		return a;
		
	}
	
	
	protected void Decrypt(byte[][]a,byte[] key)
	{
		
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
	//System.out.println("Your plain text is :");
	a=aef.AddRoundKeyFirst(a, key);
	System.out.println("-----------------Decryption ends------------------");
	
	
	
	
}
	
	
	
	
	
	
	
}
