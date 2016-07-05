/*
Classe que contém os processos de encriotação e decriptação
 */

package testeaes;


public class Cifra {
    
    MetodosAES met = new MetodosAES();
    
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
        //System.out.printf("\n\n\nApos RounKey 1\n\n");
        //met.printMat(estado);
        //-----------------------------------------------------------
        for(int a = 4; a < 37; a = a+4){
            estado = met.subBytes(estado);
            //System.out.printf("\n\n\nApos SubBytes\n\n");
            // met.printMat(estado);
            estado = met.ShiftRows(estado);
            //System.out.printf("\n\n\nApos ShiftRows\n\n");
            //met.printMat(estado);
            estado = met.mixColumns(estado);
            // System.out.printf("\n\n\nApos MIxColuns\n\n");
            //met.printMat(estado);
            estado = met.addRoundKey(met.retornaChaveRodada(roundKeys,a), estado);
            //System.out.printf("\n\n\nChave da Rodada\n\n");
            //met.printMat(met.retornaChaveRodada(roundKeys,a));
            //System.out.printf("\n\n\nApos RounKey \n\n");
            //met.printMat(estado);
        }
        //System.out.printf("\n\n\nApos SubBytes\n\n");
        estado = met.subBytes(estado);
        //met.printMat(estado);
        //System.out.printf("\n\n\nApos ShiftRows\n\n");
        estado = met.ShiftRows(estado);
        //met.printMat(estado);
        //System.out.printf("\n\n\nFinal\n\n");
        estado = met.addRoundKey(met.retornaChaveRodada(roundKeys,40), estado);
        //met.printMat(estado);
        
        return estado;
    }
    
   
}
