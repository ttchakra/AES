
final public class AES_Decryption_Functions {

	
	int getInt(char chr) {
	    return Character.digit(chr, 16);
	}

	char getChar(int val) {
	    return Character.forDigit(val, 16);
	}

	//This function shifts the 2nd, 3rd and 4th row of the matrix by 3,2,1 places to the right respectively.
	//It returns the transformed rows matrix
		
	 byte[][] InvShiftRows(byte[][] a){
		
		//copying the array into a temporary array 'temp' for circular shifting 
		try {
			byte[][] temp = new byte[4][4];
			for(int i=0;i<4;i++)
				for (int j=0;j<4;j++)
					temp[i][j]=a[i][j];
			
			//2nd row is moved by 3 element to the right. That is aij  becomes ai(j+3)
			for(int i=0;i<4;i++){
			a[1][i] = temp[1][(i+3)%4];
			}
			
			//3rd row is moved by 2 elements to the right. That is aij  becomes ai(j+2)
			for(int i=0;i<4;i++){
				a[2][i] = temp[2][(i+2)%4];
				}
			
			//4th row is moved by 1 element to the right. That is aij  becomes ai(j+1)
			for(int i=0;i<4;i++){
				a[3][i] = temp[3][(i+1)%4];
				}
			
			//printing the shifted matrix
			System.out.println("-------------------Inverting shifted rows--------------------------");
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++)
						System.out.print(Integer.toHexString(a[i][j] & 0xff)+ " ");
					System.out.println();
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Decryption failed!! Try again!!");
		}	
		
	
		return a;
		
	}

	byte[][] InvSubBytes(byte[][] a){
	
	try {
		byte[][] sbox = new byte[16][16];
		sbox[0][0]=(byte)0x52;sbox[0][1]=(byte)0x09;sbox[0][2]=(byte)0x6a;sbox[0][3]=(byte)0xd5;sbox[0][4]=(byte)0x30;sbox[0][5]=(byte)0x36;sbox[0][6]=(byte)0xa5;sbox[0][7]=(byte)0x38;sbox[0][8]=(byte)0xbf;sbox[0][9]=(byte)0x40;sbox[0][10]=(byte)0xa3;sbox[0][11]=(byte)0x9e;sbox[0][12]=(byte)0x81;sbox[0][13]=(byte)0xf3;sbox[0][14]=(byte)0xd7;sbox[0][15]=(byte)0xfb;
		sbox[1][0]=(byte)0x7c;sbox[1][1]=(byte)0xe3;sbox[1][2]=(byte)0x39;sbox[1][3]=(byte)0x82;sbox[1][4]=(byte)0x9b;sbox[1][5]=(byte)0x2f;sbox[1][6]=(byte)0xff;sbox[1][7]=(byte)0x87;sbox[1][8]=(byte)0x34;sbox[1][9]=(byte)0x8e;sbox[1][10]=(byte)0x43;sbox[1][11]=(byte)0x44;sbox[1][12]=(byte)0xc4;sbox[1][13]=(byte)0xde;sbox[1][14]=(byte)0xe9;sbox[1][15]=(byte)0xcb;
		sbox[2][0]=(byte)0x54;sbox[2][1]=(byte)0x7b;sbox[2][2]=(byte)0x94;sbox[2][3]=(byte)0x32;sbox[2][4]=(byte)0xa6;sbox[2][5]=(byte)0xc2;sbox[2][6]=(byte)0x23;sbox[2][7]=(byte)0x3d;sbox[2][8]=(byte)0xee;sbox[2][9]=(byte)0x4c;sbox[2][10]=(byte)0x95;sbox[2][11]=(byte)0x0b;sbox[2][12]=(byte)0x42;sbox[2][13]=(byte)0xfa;sbox[2][14]=(byte)0xc3;sbox[2][15]=(byte)0x4e;
		sbox[3][0]=(byte)0x08;sbox[3][1]=(byte)0x2e;sbox[3][2]=(byte)0xa1;sbox[3][3]=(byte)0x66;sbox[3][4]=(byte)0x28;sbox[3][5]=(byte)0xd9;sbox[3][6]=(byte)0x24;sbox[3][7]=(byte)0xb2;sbox[3][8]=(byte)0x76;sbox[3][9]=(byte)0x5b;sbox[3][10]=(byte)0xa2;sbox[3][11]=(byte)0x49;sbox[3][12]=(byte)0x6d;sbox[3][13]=(byte)0x8b;sbox[3][14]=(byte)0xd1;sbox[3][15]=(byte)0x25;
		sbox[4][0]=(byte)0x72;sbox[4][1]=(byte)0xf8;sbox[4][2]=(byte)0xf6;sbox[4][3]=(byte)0x64;sbox[4][4]=(byte)0x86;sbox[4][5]=(byte)0x68;sbox[4][6]=(byte)0x98;sbox[4][7]=(byte)0x16;sbox[4][8]=(byte)0xd4;sbox[4][9]=(byte)0xa4;sbox[4][10]=(byte)0x5c;sbox[4][11]=(byte)0xcc;sbox[4][12]=(byte)0x5d;sbox[4][13]=(byte)0x65;sbox[4][14]=(byte)0xb6;sbox[4][15]=(byte)0x92;
		sbox[5][0]=(byte)0x6c;sbox[5][1]=(byte)0x70;sbox[5][2]=(byte)0x48;sbox[5][3]=(byte)0x50;sbox[5][4]=(byte)0xfd;sbox[5][5]=(byte)0xed;sbox[5][6]=(byte)0xb9;sbox[5][7]=(byte)0xda;sbox[5][8]=(byte)0x5e;sbox[5][9]=(byte)0x15;sbox[5][10]=(byte)0x46;sbox[5][11]=(byte)0x57;sbox[5][12]=(byte)0xa7;sbox[5][13]=(byte)0x8d;sbox[5][14]=(byte)0x9d;sbox[5][15]=(byte)0x84;
		sbox[6][0]=(byte)0x90;sbox[6][1]=(byte)0xd8;sbox[6][2]=(byte)0xab;sbox[6][3]=(byte)0x00;sbox[6][4]=(byte)0x8c;sbox[6][5]=(byte)0xbc;sbox[6][6]=(byte)0xd3;sbox[6][7]=(byte)0x0a;sbox[6][8]=(byte)0xf7;sbox[6][9]=(byte)0xe4;sbox[6][10]=(byte)0x58;sbox[6][11]=(byte)0x05;sbox[6][12]=(byte)0xb8;sbox[6][13]=(byte)0xb3;sbox[6][14]=(byte)0x45;sbox[6][15]=(byte)0x06;
		sbox[7][0]=(byte)0xd0;sbox[7][1]=(byte)0x2c;sbox[7][2]=(byte)0x1e;sbox[7][3]=(byte)0x8f;sbox[7][4]=(byte)0xca;sbox[7][5]=(byte)0x3f;sbox[7][6]=(byte)0x0f;sbox[7][7]=(byte)0x02;sbox[7][8]=(byte)0xc1;sbox[7][9]=(byte)0xaf;sbox[7][10]=(byte)0xbd;sbox[7][11]=(byte)0x03;sbox[7][12]=(byte)0x01;sbox[7][13]=(byte)0x13;sbox[7][14]=(byte)0x8a;sbox[7][15]=(byte)0x6b;
		sbox[8][0]=(byte)0x3a;sbox[8][1]=(byte)0x91;sbox[8][2]=(byte)0x11;sbox[8][3]=(byte)0x41;sbox[8][4]=(byte)0x4f;sbox[8][5]=(byte)0x67;sbox[8][6]=(byte)0xdc;sbox[8][7]=(byte)0xea;sbox[8][8]=(byte)0x97;sbox[8][9]=(byte)0xf2;sbox[8][10]=(byte)0xcf;sbox[8][11]=(byte)0xce;sbox[8][12]=(byte)0xf0;sbox[8][13]=(byte)0xb4;sbox[8][14]=(byte)0xe6;sbox[8][15]=(byte)0x73;
		sbox[9][0]=(byte)0x96;sbox[9][1]=(byte)0xac;sbox[9][2]=(byte)0x74;sbox[9][3]=(byte)0x22;sbox[9][4]=(byte)0xe7;sbox[9][5]=(byte)0xad;sbox[9][6]=(byte)0x35;sbox[9][7]=(byte)0x85;sbox[9][8]=(byte)0xe2;sbox[9][9]=(byte)0xf9;sbox[9][10]=(byte)0x37;sbox[9][11]=(byte)0xe8;sbox[9][12]=(byte)0x1c;sbox[9][13]=(byte)0x75;sbox[9][14]=(byte)0xdf;sbox[9][15]=(byte)0x6e;
		sbox[10][0]=(byte)0x47;sbox[10][1]=(byte)0xf1;sbox[10][2]=(byte)0x1a;sbox[10][3]=(byte)0x71;sbox[10][4]=(byte)0x1d;sbox[10][5]=(byte)0x29;sbox[10][6]=(byte)0xc5;sbox[10][7]=(byte)0x89;sbox[10][8]=(byte)0x6f;sbox[10][9]=(byte)0xb7;sbox[10][10]=(byte)0x62;sbox[10][11]=(byte)0x0e;sbox[10][12]=(byte)0xaa;sbox[10][13]=(byte)0x18;sbox[10][14]=(byte)0xbe;sbox[10][15]=(byte)0x1b;
		sbox[11][0]=(byte)0xfc;sbox[11][1]=(byte)0x56;sbox[11][2]=(byte)0x3e;sbox[11][3]=(byte)0x4b;sbox[11][4]=(byte)0xc6;sbox[11][5]=(byte)0xd2;sbox[11][6]=(byte)0x79;sbox[11][7]=(byte)0x20;sbox[11][8]=(byte)0x9a;sbox[11][9]=(byte)0xdb;sbox[11][10]=(byte)0xc0;sbox[11][11]=(byte)0xfe;sbox[11][12]=(byte)0x78;sbox[11][13]=(byte)0xcd;sbox[11][14]=(byte)0x5a;sbox[11][15]=(byte)0xf4;
		sbox[12][0]=(byte)0x1f;sbox[12][1]=(byte)0xdd;sbox[12][2]=(byte)0xa8;sbox[12][3]=(byte)0x33;sbox[12][4]=(byte)0x88;sbox[12][5]=(byte)0x07;sbox[12][6]=(byte)0xc7;sbox[12][7]=(byte)0x31;sbox[12][8]=(byte)0xb1;sbox[12][9]=(byte)0x12;sbox[12][10]=(byte)0x10;sbox[12][11]=(byte)0x59;sbox[12][12]=(byte)0x27;sbox[12][13]=(byte)0x80;sbox[12][14]=(byte)0xec;sbox[12][15]=(byte)0x5f;
		sbox[13][0]=(byte)0x60;sbox[13][1]=(byte)0x51;sbox[13][2]=(byte)0x7f;sbox[13][3]=(byte)0xa9;sbox[13][4]=(byte)0x19;sbox[13][5]=(byte)0xb5;sbox[13][6]=(byte)0x4a;sbox[13][7]=(byte)0x0d;sbox[13][8]=(byte)0x2d;sbox[13][9]=(byte)0xe5;sbox[13][10]=(byte)0x7a;sbox[13][11]=(byte)0x9f;sbox[13][12]=(byte)0x93;sbox[13][13]=(byte)0xc9;sbox[13][14]=(byte)0x9c;sbox[13][15]=(byte)0xef;
		sbox[14][0]=(byte)0xa0;sbox[14][1]=(byte)0xe0;sbox[14][2]=(byte)0x3b;sbox[14][3]=(byte)0x4d;sbox[14][4]=(byte)0xae;sbox[14][5]=(byte)0x2a;sbox[14][6]=(byte)0xf5;sbox[14][7]=(byte)0xb0;sbox[14][8]=(byte)0xc8;sbox[14][9]=(byte)0xeb;sbox[14][10]=(byte)0xbb;sbox[14][11]=(byte)0x3c;sbox[14][12]=(byte)0x83;sbox[14][13]=(byte)0x53;sbox[14][14]=(byte)0x99;sbox[14][15]=(byte)0x61;
		sbox[15][0]=(byte)0x17;sbox[15][1]=(byte)0x2b;sbox[15][2]=(byte)0x04;sbox[15][3]=(byte)0x7e;sbox[15][4]=(byte)0xba;sbox[15][5]=(byte)0x77;sbox[15][6]=(byte)0xd6;sbox[15][7]=(byte)0x26;sbox[15][8]=(byte)0xe1;sbox[15][9]=(byte)0x69;sbox[15][10]=(byte)0x14;sbox[15][11]=(byte)0x63;sbox[15][12]=(byte)0x55;sbox[15][13]=(byte)0x21;sbox[15][14]=(byte)0x0c;sbox[15][15]=(byte)0x7d;
		
		
		for (int i=0;i<4;i++){
			for(int j=0;j<4;j++)
			{		
				String s= Integer.toHexString(a[i][j] & 0xff);
				
				if (s.length()==1)
					s="0"+s;
				
				//System.out.print(s+" ----> ");
				int n = getInt(s.charAt(0));
				//System.out.println(n);
				int m= getInt(s.charAt(1));
				//System.out.println(m);
				
				a[i][j]=sbox[n][m];
				//System.out.print(Integer.toHexString(a[i][j] & 0xff));
				//System.out.println();
			}}
		System.out.println();
		System.out.println("-----Inverting SubBytes-------");
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				System.out.print(Integer.toHexString(a[i][j] & 0xff)+ " ");
			System.out.println();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Decryption failed!! Try again!!");;
	}	

	
	return a;
}

	byte[][] InvMixColumns(byte[][] a){
		try {
			byte[][] mc= new byte[4][4];
			mc[0][0]=(byte)0x0e;mc[0][1]=(byte)0x0b;mc[0][2]=(byte)0x0d;mc[0][3]=(byte)0x09;
			mc[1][0]=(byte)0x09;mc[1][1]=(byte)0x0e;mc[1][2]=(byte)0x0b;mc[1][3]=(byte)0x0d;
			mc[2][0]=(byte)0x0d;mc[2][1]=(byte)0x09;mc[2][2]=(byte)0x0e;mc[2][3]=(byte)0x0b;
			mc[3][0]=(byte)0x0b;mc[3][1]=(byte)0x0d;mc[3][2]=(byte)0x09;mc[3][3]=(byte)0x0e;
			
			byte [][] a_new = new byte[4][4];
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					a_new[i][j]=a[i][j];
				}
			}
			
			//Column 0
			a[0][0]= (byte)(Multiply(a_new[0][0],mc[0][0])^Multiply(a_new[1][0],mc[0][1])^Multiply(a_new[2][0],mc[0][2])^Multiply(a_new[3][0],mc[0][3]));
			a[1][0]= (byte)(Multiply(a_new[0][0],mc[1][0])^Multiply(a_new[1][0],mc[1][1])^Multiply(a_new[2][0],mc[1][2])^Multiply(a_new[3][0],mc[1][3]));
			a[2][0]= (byte)(Multiply(a_new[0][0],mc[2][0])^Multiply(a_new[1][0],mc[2][1])^Multiply(a_new[2][0],mc[2][2])^Multiply(a_new[3][0],mc[2][3]));
			a[3][0]= (byte)(Multiply(a_new[0][0],mc[3][0])^Multiply(a_new[1][0],mc[3][1])^Multiply(a_new[2][0],mc[3][2])^Multiply(a_new[3][0],mc[3][3]));
			
			//Column 1
			a[0][1]= (byte)(Multiply(a_new[0][1],mc[0][0])^Multiply(a_new[1][1],mc[0][1])^Multiply(a_new[2][1],mc[0][2])^Multiply(a_new[3][1],mc[0][3]));
			a[1][1]= (byte)(Multiply(a_new[0][1],mc[1][0])^Multiply(a_new[1][1],mc[1][1])^Multiply(a_new[2][1],mc[1][2])^Multiply(a_new[3][1],mc[1][3]));
			a[2][1]= (byte)(Multiply(a_new[0][1],mc[2][0])^Multiply(a_new[1][1],mc[2][1])^Multiply(a_new[2][1],mc[2][2])^Multiply(a_new[3][1],mc[2][3]));
			a[3][1]= (byte)(Multiply(a_new[0][1],mc[3][0])^Multiply(a_new[1][1],mc[3][1])^Multiply(a_new[2][1],mc[3][2])^Multiply(a_new[3][1],mc[3][3]));
			
			//Column 2
			a[0][2]= (byte)(Multiply(a_new[0][2],mc[0][0])^Multiply(a_new[1][2],mc[0][1])^Multiply(a_new[2][2],mc[0][2])^Multiply(a_new[3][2],mc[0][3]));
			a[1][2]= (byte)(Multiply(a_new[0][2],mc[1][0])^Multiply(a_new[1][2],mc[1][1])^Multiply(a_new[2][2],mc[1][2])^Multiply(a_new[3][2],mc[1][3]));
			a[2][2]= (byte)(Multiply(a_new[0][2],mc[2][0])^Multiply(a_new[1][2],mc[2][1])^Multiply(a_new[2][2],mc[2][2])^Multiply(a_new[3][2],mc[2][3]));
			a[3][2]= (byte)(Multiply(a_new[0][2],mc[3][0])^Multiply(a_new[1][2],mc[3][1])^Multiply(a_new[2][2],mc[3][2])^Multiply(a_new[3][2],mc[3][3]));
			
			//Column 3
			a[0][3]= (byte)(Multiply(a_new[0][3],mc[0][0])^Multiply(a_new[1][3],mc[0][1])^Multiply(a_new[2][3],mc[0][2])^Multiply(a_new[3][3],mc[0][3]));
			a[1][3]= (byte)(Multiply(a_new[0][3],mc[1][0])^Multiply(a_new[1][3],mc[1][1])^Multiply(a_new[2][3],mc[1][2])^Multiply(a_new[3][3],mc[1][3]));
			a[2][3]= (byte)(Multiply(a_new[0][3],mc[2][0])^Multiply(a_new[1][3],mc[2][1])^Multiply(a_new[2][3],mc[2][2])^Multiply(a_new[3][3],mc[2][3]));
			a[3][3]= (byte)(Multiply(a_new[0][3],mc[3][0])^Multiply(a_new[1][3],mc[3][1])^Multiply(a_new[2][3],mc[3][2])^Multiply(a_new[3][3],mc[3][3]));
									
			
			for(int i =0;i<4;i++){
				for(int j=0;j<4;j++){
					System.out.print(Integer.toHexString(a[i][j] & 0xFF));
					System.out.print(" ");
				}
				System.out.println(" ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Decryption failed!! Try again!!");
		}
		
	
		return a;
	}
	
	byte Multiply(byte a, byte b){
		byte product=0x00;
		try {
			
			byte multiple =(byte)0x02;
			if(b==0x09){
				product=MultiplyBy2(a,multiple);
				product =MultiplyBy2(product,multiple);
				product=MultiplyBy2(product,multiple);
				product =(byte)(product^a);
				//System.out.println(Integer.toHexString(product & 0xff));
				
			}
			else if(b==0x0b){
				product =MultiplyBy2(a,multiple);
				product =MultiplyBy2(product,multiple);
				product =(byte)(product^a);
				product =MultiplyBy2(product,multiple);
				product =(byte)(product^a);
				//System.out.println(Integer.toHexString(product & 0xff));
			}
			else if(b==0x0d){
				product =MultiplyBy2(a,multiple);
				product =(byte)(product^a);
				product =MultiplyBy2(product,multiple);
				product =MultiplyBy2(product,multiple);
				product =(byte)(product^a);
				//System.out.println(Integer.toHexString(product & 0xff));
			}
			else if(b==0x0e){
				product =MultiplyBy2(a,multiple);
				product =(byte)(product^a);
				product =MultiplyBy2(product,multiple);
				product =(byte)(product^a);
				product =MultiplyBy2(product,multiple);
				//System.out.println(Integer.toHexString(product & 0xff));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Decryption failed!! Try again!!");
		}
		return product;
	}
	
	byte MultiplyBy2(byte a, byte b){
		//System.out.println("temp: "+((temp)) );
		byte product=0x00;
		try {
			byte temp =(byte) ((a>> 7)& 0x01);
			
			//System.out.println(Integer.toHexString(b & 0xff));
			if(b==2){
				if(temp==1){
					product=(byte)((a*b)^(0x1b));
				}
				else 
					product=(byte)(a*b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Decryption failed!! Try again!!");
		}
		
		return product;
		}
	
	}
