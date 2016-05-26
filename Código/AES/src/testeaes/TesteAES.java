
package testeaes;

import java.util.Scanner;


public class TesteAES {

    
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
        
    }

 
}
