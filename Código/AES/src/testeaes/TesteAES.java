
package testeaes;

import java.util.Scanner;


public class TesteAES {
    
    //bloco utilizado para testes
    public static int  bloco [][] = {{0xD4,0xE0,0xB8,0xE1},
                                     {0xBF,0xB4,0x41,0x27},
                                     {0x5D,0x52,0x11,0x98},
                                     {0x30,0xAE,0xF1,0xE5}};
    
    public static int  bloco3 [][] = {{0x19,0xa0,0x9a,0xe9},
                                      {0x3d,0xf4,0xc6,0xf8},
                                      {0xe3,0xe2,0x8d,0x48},
                                      {0xbe,0x2b,0x2a,0x08}};
    
    
    public static int  bloco2 [][] =  {{0x04,0xe0,0x48,0x28},
                                       {0x66,0xcb,0xf8,0x06},
                                       {0x81,0x19,0xd3,0x26},
                                       {0x7a,0x9a,0x7a,0x4c}};
            
    public static int chave [][] = {{0x2B,0x28,0xAB,0x09},
                                    {0x7E,0xAE,0xF7,0xCF},
                                    {0x15,0xD2,0x15,0x4F},
                                    {0x16,0xA6,0x88,0x3C}};
     
    public static int chave2 [][] = {{0xa0,0x88,0x23,0x2a},
                                     {0xfa,0x54,0xa3,0x6c},
                                     {0xfe,0x2c,0x39,0x76},
                                     {0x17,0xb1,0x39,0x05}};
    
    public static int [][] novoBloco = new int [4][4];
    
    public static void main(String[] args) {
        
        MetodosAES met = new MetodosAES();
        System.out.printf("\n\n\nBloco Original\n\n");
        met.printMat(bloco2);
        
        System.out.printf("\n\n\nChave Original\n\n");
        met.printMat(chave2);
        System.out.printf("\n\n");
        
        novoBloco = met.addRoundKey(chave2,bloco2);
        System.out.printf("\n\n\nResultado AddRoundKey\n\n");
        met.printMat(novoBloco);
        
        
        novoBloco = met.subBytes(novoBloco);
        System.out.printf("\n\nResultado SubBytes\n\n");
        met.printMat(novoBloco);
        
        novoBloco = met.ShiftRows(novoBloco);
        System.out.printf("\n\n\nResultado ShiftRows\n\n");
        met.printMat(novoBloco);
        
        novoBloco = met.mixColumns(novoBloco);
        System.out.printf("\n\n\nResultado MixCoumns\n\n");
        met.printMat(novoBloco);
        
        int sd, sf, rt;
        sd = 0x48;
        sf = 0x23;
        rt = (byte) (sd ^ sf);
        System.out.print(Long.toString(rt,16));
        
    }

 
}
