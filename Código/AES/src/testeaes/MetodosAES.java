package testeaes;


public class MetodosAES {
    
    //Sbox utilizada para a excpanção da chave
                                //     0     1     2     3     4     5     6     7     8     9     A     B     C     D     E     F   
    private static int[][] sbox = { {0x63, 0x7C, 0x77, 0x7B, 0xF2, 0x6B, 0x6F, 0xC5, 0x30, 0x01, 0x67, 0x2B, 0xFE, 0xD7, 0xAB, 0x76},   // 0
                                    {0xCA, 0x82, 0xC9, 0x7D, 0xFA, 0x59, 0x47, 0xF0, 0xAD, 0xD4, 0xA2, 0xAF, 0x9C, 0xA4, 0x72, 0xC0},   // 1
                                    {0xB7, 0xFD, 0x93, 0x26, 0x36, 0x3F, 0xF7, 0xCC, 0x34, 0xA5, 0xE5, 0xF1, 0x71, 0xD8, 0x31, 0x15},   // 2
                                    {0x04, 0xC7, 0x23, 0xC3, 0x18, 0x96, 0x05, 0x9A, 0x07, 0x12, 0x80, 0xE2, 0xEB, 0x27, 0xB2, 0x75},   // 3
                                    {0x09, 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A, 0xA0, 0x52, 0x3B, 0xD6, 0xB3, 0x29, 0xE3, 0x2F, 0x84},   // 4
                                    {0x53, 0xD1, 0x00, 0xED, 0x20, 0xFC, 0xB1, 0x5B, 0x6A, 0xCB, 0xBE, 0x39, 0x4A, 0x4C, 0x58, 0xCF},   // 5
                                    {0xD0, 0xEF, 0xAA, 0xFB, 0x43, 0x4D, 0x33, 0x85, 0x45, 0xF9, 0x02, 0x7F, 0x50, 0x3C, 0x9F, 0xA8},   // 6
                                    {0x51, 0xA3, 0x40, 0x8F, 0x92, 0x9D, 0x38, 0xF5, 0xBC, 0xB6, 0xDA, 0x21, 0x10, 0xFF, 0xF3, 0xD2},   // 7
                                    {0xCD, 0x0C, 0x13, 0xEC, 0x5F, 0x97, 0x44, 0x17, 0xC4, 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73},   // 8
                                    {0x60, 0x81, 0x4F, 0xDC, 0x22, 0x2A, 0x90, 0x88, 0x46, 0xEE, 0xB8, 0x14, 0xDE, 0x5E, 0x0B, 0xDB},   // 9
                                    {0xE0, 0x32, 0x3A, 0x0A, 0x49, 0x06, 0x24, 0x5C, 0xC2, 0xD3, 0xAC, 0x62, 0x91, 0x95, 0xE4, 0x79},   // A
                                    {0xE7, 0xC8, 0x37, 0x6D, 0x8D, 0xD5, 0x4E, 0xA9, 0x6C, 0x56, 0xF4, 0xEA, 0x65, 0x7A, 0xAE, 0x08},   // B
                                    {0xBA, 0x78, 0x25, 0x2E, 0x1C, 0xA6, 0xB4, 0xC6, 0xE8, 0xDD, 0x74, 0x1F, 0x4B, 0xBD, 0x8B, 0x8A},   // C
                                    {0x70, 0x3E, 0xB5, 0x66, 0x48, 0x03, 0xF6, 0x0E, 0x61, 0x35, 0x57, 0xB9, 0x86, 0xC1, 0x1D, 0x9E},   // D
                                    {0xE1, 0xF8, 0x98, 0x11, 0x69, 0xD9, 0x8E, 0x94, 0x9B, 0x1E, 0x87, 0xE9, 0xCE, 0x55, 0x28, 0xDF},   // E
                                    {0x8C, 0xA1, 0x89, 0x0D, 0xBF, 0xE6, 0x42, 0x68, 0x41, 0x99, 0x2D, 0x0F, 0xB0, 0x54, 0xBB, 0x16} }; // F
    
    
    private static int [][] matMix = {{0x02,0x03,0x01,0x01},
                                      {0x01,0x02,0x03,0x01},
                                      {0x01,0x01,0x02,0x03},
                                      {0x03,0x01,0x01,0x02}};
    
    //Matriz utilizada na expanção da chave
    private static int [][] matExpKey = {{0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80,0x1B,0x36},
                                         {0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00},
                                         {0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00},
                                         {0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00}};
    

    //bloco utilizado para testes
    public int  bloco [][] = {{0x32,0x88,0x31,0xE0},
                              {0x43,0x5A,0x31,0x37},
                              {0xF6,0x30,0x98,0x07},
                              {0xA8,0x8D,0xA2,0x34}};
    
    public int  chave [][] = {{0x2B,0x28,0xAB,0x09},
                              {0x7E,0xAE,0xF7,0xCF},
                              {0x15,0xD2,0x15,0x4F},
                              {0x16,0xA6,0x88,0x3C}};
    
    final static int[] LogTable = {
		0,   0,  25,   1,  50,   2,  26, 198,  75, 199,  27, 104,  51, 238, 223,   3,
		100,   4, 224,  14,  52, 141, 129, 239,  76, 113,   8, 200, 248, 105,  28, 193,
		125, 194,  29, 181, 249, 185,  39, 106,  77, 228, 166, 114, 154, 201,   9, 120,
		101,  47, 138,   5,  33,  15, 225,  36,  18, 240, 130,  69,  53, 147, 218, 142,
		150, 143, 219, 189,  54, 208, 206, 148,  19,  92, 210, 241,  64,  70, 131,  56,
		102, 221, 253,  48, 191,   6, 139,  98, 179,  37, 226, 152,  34, 136, 145,  16,
		126, 110,  72, 195, 163, 182,  30,  66,  58, 107,  40,  84, 250, 133,  61, 186,
		43, 121,  10,  21, 155, 159,  94, 202,  78, 212, 172, 229, 243, 115, 167,  87,
		175,  88, 168,  80, 244, 234, 214, 116,  79, 174, 233, 213, 231, 230, 173, 232,
		44, 215, 117, 122, 235,  22,  11, 245,  89, 203,  95, 176, 156, 169,  81, 160,
		127,  12, 246, 111,  23, 196,  73, 236, 216,  67,  31,  45, 164, 118, 123, 183,
		204, 187,  62,  90, 251,  96, 177, 134,  59,  82, 161, 108, 170,  85,  41, 157,
		151, 178, 135, 144,  97, 190, 220, 252, 188, 149, 207, 205,  55,  63,  91, 209,
		83,  57, 132,  60,  65, 162, 109,  71,  20,  42, 158,  93,  86, 242, 211, 171,
		68,  17, 146, 217,  35,  32,  46, 137, 180, 124, 184,  38, 119, 153, 227, 165,
		103,  74, 237, 222, 197,  49, 254,  24,  13,  99, 140, 128, 192, 247, 112,   7};
        
        
        final static int[] AlogTable = {
		1,   3,   5,  15,  17,  51,  85, 255,  26,  46, 114, 150, 161, 248,  19,  53,
		95, 225,  56,  72, 216, 115, 149, 164, 247,   2,   6,  10,  30,  34, 102, 170,
		229,  52,  92, 228,  55,  89, 235,  38, 106, 190, 217, 112, 144, 171, 230,  49,
		83, 245,   4,  12,  20,  60,  68, 204,  79, 209, 104, 184, 211, 110, 178, 205,
		76, 212, 103, 169, 224,  59,  77, 215,  98, 166, 241,   8,  24,  40, 120, 136,
		131, 158, 185, 208, 107, 189, 220, 127, 129, 152, 179, 206,  73, 219, 118, 154,
		181, 196,  87, 249,  16,  48,  80, 240,  11,  29,  39, 105, 187, 214,  97, 163,
		254,  25,  43, 125, 135, 146, 173, 236,  47, 113, 147, 174, 233,  32,  96, 160,
		251,  22,  58,  78, 210, 109, 183, 194,  93, 231,  50,  86, 250,  21,  63,  65,
		195,  94, 226,  61,  71, 201,  64, 192,  91, 237,  44, 116, 156, 191, 218, 117,
		159, 186, 213, 100, 172, 239,  42, 126, 130, 157, 188, 223, 122, 142, 137, 128,
		155, 182, 193,  88, 232,  35, 101, 175, 234,  37, 111, 177, 200,  67, 197,  84,
		252,  31,  33,  99, 165, 244,   7,   9,  27,  45, 119, 153, 176, 203,  70, 202,
		69, 207,  74, 222, 121, 139, 134, 145, 168, 227,  62,  66, 198,  81, 243,  14,
		18,  54,  90, 238,  41, 123, 141, 140, 143, 138, 133, 148, 167, 242,  13,  23,
		57,  75, 221, 124, 132, 151, 162, 253,  28,  36, 108, 180, 199,  82, 246,   1};
    
    
    //metodo que realiza a expanção da chave e retorna a matriz com a chave expandida!
    public int [][] ExChave(int [][] chave){
        int[][] roundKey = new int[4][44];
        int[][] aux = new int[4][4];
        for (int c = 0; c < 4; c++) {
            aux = this.rotacionaPalavra(chave);
            aux = this.subBytesPalavra(chave);
            //tavez esses metodos não sejam aqui dentro
            
        }
        return roundKey;
    }
    
    
    
    //funcionando
    public int[][] ShiftRows(int[][] stado) {
        int[][] aux = new int[4][4];
        for (int l = 0; l < 4; l++) {
            for (int c = 0; c < 4; c++){
                aux[l][c] = stado [l][(c + l) % 4];
            }
        }
        return aux;
    }
    
    //Funcionando só que preciso deixae a saida em hexadecimal / ta saindo em decimal
    public int[][] addRoundKey(int[][] chave, int[][] estado ){
        int[][] aux = new int[4][4];
        for (int l = 0; l < 4; l++) {
            for (int c = 0; c < 4; c++){
                aux[l][c] =  (estado[l][c] ^ chave[l][c]);
            }
        }
        return aux;
    }
    
    //Funcionando!!! 
    public int [][] subBytes(int[][] estado){
        int [][] aux = new int [4][4];
        for (int l = 0; l < 4; l++) {
            for (int c = 0; c < 4; c++){
                aux[l][c] =  (sbox[this.retornaLinha(estado[l][c])][this.retornaColuna(estado[l][c])]);
            }
        }
        return aux;
    }
    
    
    
    
           
        //Funcionando
	public int [][] mixColumns (int [][] estado) 
	{
            int tmp [][] = new int [4][4];
	    
	   
	    //copy of cipherTemp[.][c]
	    for (int c = 0; c < 4; c++){
                tmp[0][c] = (mul(2,estado[0][c])) ^ (mul(3,estado[1][c])) ^ (mul(1,estado[2][c])) ^ (mul(1,estado[3][c]));
                tmp[1][c] = (mul(1,estado[0][c])) ^ (mul(2,estado[1][c])) ^ (mul(3,estado[2][c])) ^ (mul(1,estado[3][c]));
                tmp[2][c] = (mul(1,estado[0][c])) ^ (mul(1,estado[1][c])) ^ (mul(2,estado[2][c])) ^ (mul(3,estado[3][c]));
                tmp[3][c] = (mul(3,estado[0][c])) ^ (mul(1,estado[1][c])) ^ (mul(1,estado[2][c])) ^ (mul(2,estado[3][c]));
            }
            return tmp;
	}
	
        
	
	private int mul (int a, int b) 
	{
		int inda = (a < 0) ? (a + 256) : a;
		int indb = (b < 0) ? (b + 256) : b;

		if ( (a != 0) && (b != 0) ) {
			int index = (LogTable[inda] + LogTable[indb]);
			int val = (AlogTable[ index % 255 ] );
			return val;
		}
		else
			return 0;
	}
    
    
    //método para imprimir matrz em forma de bloco aes
    public void printMat(int [][] bloco){
        for(int a = 0; a < 4; a++){
            for(int b = 0; b < 4; b++){
                System.out.print(Long.toString(bloco[a][b],16));
                System.out.printf(" | ");
            }
            System.out.printf("\n\n");
        }
    }
    
    public int retornaColuna(int x){
        int a;
        a = x & 0x0F;
        return a;
    }
    
    public int retornaLinha(int x){
        int a;
        a = (x>>4) & 0x0f;
        return a;
    }
    
    //Funcionando!! Testado!
    public int [][] rotacionaPalavra(int [][] chave){
        int [][] aux = new int [4][4];
        //aux = chave;
        for(int l = 0; l < 4; l++){
            for(int c = 0; c < 3; c++){
                aux[l][c] = chave[l][c];
            } 
        }
        for(int l = 0; l < 4; l++){
           aux[l][3] = chave [(l+1) % 4][3];
        }
        return aux;
    }
    
    //FUNCIONANDO!! Testado!
    public int [][] subBytesPalavra(int [][] chave){
        int [][] aux = new int [4][4];
        //aux = chave;
        for(int l = 0; l < 4; l++){
            for(int c = 0; c < 3; c++){
                aux[l][c] = chave[l][c];
            } 
        }
        for(int l = 0; l < 4; l++){
           aux[l][3] =  (sbox[this.retornaLinha(chave[l][3])][this.retornaColuna(chave[l][3])]);
        }
        return aux;
    }
    
    
}
