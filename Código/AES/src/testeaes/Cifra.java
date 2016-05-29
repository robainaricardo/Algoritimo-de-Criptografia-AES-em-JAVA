/*
Classe que contém os processos de encriotação e decriptação
 */

package testeaes;

public class Cifra {
    
    MetodosAES met = new MetodosAES();
    
    public int[][] Encriptar(int[][] entrada, int[][] chave) {
        int[][] estado;
        
        /*
            FaLta Fazer a Expanção da chave!!!
        */
        
        
        //-----------------------------------------------------------
        estado = met.addRoundKey(chave, entrada);
        //-----------------------------------------------------------
        for(int a = 0; a < 10; a++){
            estado = met.subBytes(estado);
            estado = met.ShiftRows(estado);
            estado = met.micColumns(estado);
            estado = met.addRoundKey(chave, estado);
        }
        //-----------------------------------------------------------
        estado = met.subBytes(estado);
        estado = met.ShiftRows(estado);
        estado = met.addRoundKey(chave, estado);
        //-----------------------------------------------------------
        return estado;
    }
    
    public int[][] Decriptar(int[][] stado, int chave) {
        int[][] aux = new int[4][4];
        //algoritmo de decriptação
        return aux;
    }
}
