/*
Classe que contém os processos de encriotação e decriptação
 */

package testeaes;


public class Cifra {
    
    MetodosAES met = new MetodosAES();
    
    
    public static int chave [][] = {{0x2B,0x28,0xAB,0x09},
                                    {0x7E,0xAE,0xF7,0xCF},
                                    {0x15,0xD2,0x15,0x4F},
                                    {0x16,0xA6,0x88,0x3C}};
    
    public static int  bloco [][] = {{0xD4,0xE0,0xB8,0xE1},
                                     {0xBF,0xB4,0x41,0x27},
                                     {0x5D,0x52,0x11,0x98},
                                     {0x30,0xAE,0xF1,0xE5}};
    private int x;
    
    
    public int[][] Encriptar(int[][] entrada, int[][] chave) {
        int[][] estado;
        int [][] roundKeys = new int [4][44];
        //int [][] chaveRodada = new int [4][4];
        
        roundKeys = met.ExChave(chave);
        
        //for(x = 0 ; x < 44; x = x+4){
          //  chaveRodada = met.retornaChaveRodada(roundKeys,x);
           // System.out.printf("\n\n\nResultado expChave %d\n\n",x);
            //met.printMat(chaveRodada);
       // }
        
        //-----------------------------------------------------------
        estado = met.addRoundKey(met.retornaChaveRodada(roundKeys,x), entrada);
        System.out.printf("\n\n\nApos RounKey 1\n\n");
        met.printMat(estado);
        //-----------------------------------------------------------
        for(int a = 4; a < 37; a = a+4){
            estado = met.subBytes(estado);
            System.out.printf("\n\n\nApos SubBytes\n\n");
        met.printMat(estado);
            estado = met.ShiftRows(estado);
            System.out.printf("\n\n\nApos ShiftRows\n\n");
        met.printMat(estado);
            estado = met.mixColumns(estado);
            System.out.printf("\n\n\nApos MIxColuns\n\n");
        met.printMat(estado);
            estado = met.addRoundKey(met.retornaChaveRodada(roundKeys,a), estado);
            System.out.printf("\n\n\nChave da Rodada\n\n");
        met.printMat(met.retornaChaveRodada(roundKeys,a));
            System.out.printf("\n\n\nApos RounKey \n\n");
        met.printMat(estado);
        }
        System.out.printf("\n\n\nApos SubBytes\n\n");
        estado = met.subBytes(estado);
        met.printMat(estado);
        System.out.printf("\n\n\nApos ShiftRows\n\n");
        estado = met.ShiftRows(estado);
        met.printMat(estado);
        System.out.printf("\n\n\nFinal\n\n");
        estado = met.addRoundKey(met.retornaChaveRodada(roundKeys,40), estado);
        met.printMat(estado);
        
        return estado;
    }
    
    public int[][] Decriptar(int[][] stado, int chave) {
        int[][] aux = new int[4][4];
        //algoritmo de decriptação
        return aux;
    }
}
