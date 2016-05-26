
package testeaes;

import java.util.Scanner;


public class TesteAES {
    
    public static byte  bloco [][] = {{0x01,0x02,0x03,0x04},
                              {0x05,0x06,0x07,0x08},
                              {0x09,0x0a,0x0b,0x0c},
                              {0x0d,0x0e,0x0f,0x1a}};
    public static byte [][] novoBloco = new byte [4][4];
    
    public static void main(String[] args) {
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
        novoBloco = met.ShiftRows(bloco);
        met.printMat(novoBloco);
        
    }

 
}
