
package testeaes;

import java.util.Scanner;


public class TesteAES {
    
    //bloco utilizado para testes
    public static int  bloco [][] = {{0xD4,0xE0,0xB8,0xE1},
                                     {0xBF,0xB4,0x41,0x27},
                                     {0x5D,0x52,0x11,0x98},
                                     {0x30,0xAE,0xF1,0xE5}};
    /*
    public static int  bloco [][] = {{0x32,0x88,0x31,0xE0},
                              {0x43,0x5A,0x31,0x37},
                              {0xF6,0x30,0x98,0x07},
                              {0xA8,0x8D,0xA2,0x34}}
    */
    public static int chave [][] = {{0x2B,0x28,0xAB,0x09},
                              {0x7E,0xAE,0xF7,0xCF},
                              {0x15,0xD2,0x15,0x4F},
                              {0x16,0xA6,0x88,0x3C}};
    
    public static int [][] novoBloco = new int [4][4];
    
    public static void main(String[] args) {
        /*
        Conversoes conversoes = new Conversoes();
        Scanner scan = new Scanner(System.in);
        String texto,bytes;
        
        System.out.println("Digite o text a ser encriptado:");
        texto = scan.nextLine();
        bytes = conversoes.converteTextoParaBytes(texto);
        System.out.println(bytes);
        
        texto = conversoes.converteBytesparaTexto(bytes);
        System.out.println(texto);
        
        MetodosAES met = new MetodosAES();
        met.printMat(bloco);
        System.out.printf("\n-----------------------------------------------------\n");
        novoBloco = met.ShiftRows(bloco);
        met.printMat(novoBloco);
       
        System.out.printf("\n-----------------------------------------------------\n");
        novoBloco = met.addRoundKey(chave, bloco);
        met.printMat(novoBloco);
      
        System.out.printf("\n-----------------------------------------------------\n");
        novoBloco = met.subBytes(bloco);
        met.printMat(novoBloco);
        
        System.out.printf("\n-----------------------------------------------------\n");
        novoBloco = met.micColumns(bloco);
        met.printMat(novoBloco);
        
        System.out.printf("\n-----------------------------------------------------\n");
        System.out.printf("\n---------------------CIFRA--------------------------------\n");
        System.out.printf("\n-----------------------------------------------------\n");
        
        Cifra cod = new Cifra();
        System.out.printf("\nBloco ORIGINAL\n\n");
        met.printMat(bloco);
        System.out.printf("\nCHAVE ORIGINAL\n\n");
        met.printMat(chave);
        System.out.printf("\nNovoBloco ORIGINAL\n\n");
        met.printMat(novoBloco);
        novoBloco = cod.Encriptar(bloco, chave);
        System.out.printf("\n\n\nNOVO BLOCO CIFRADOOO\n\n");
        met.printMat(novoBloco);
        
        
        
        MetodosAES met = new MetodosAES();
        novoBloco = met.micColumns(bloco);
        System.out.printf("\n\n\nNOVO BLOCO CIFRADOOO\n\n");
        met.printMat(novoBloco);
        */
        MetodosAES met = new MetodosAES();
        met.printMat(chave);
        novoBloco = met.rotacionaPalavra(chave);
        System.out.printf("\n\n-----------------------------\n\n");
        met.printMat(novoBloco);
    }

 
}
