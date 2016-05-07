import java.util.Scanner;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */  
public class aes {

    static String iv = "arnidcearrsdoonf";//vetor de inicialização
    static String palavra;
    static String chaveencriptacao = "0123456789abcdef";
    
    public static void main(String[] args) {
        System.out.println("Qual o texto?");
        Scanner scanner = new Scanner(System.in);
        palavra = scanner.nextLine();
        
        try {
            long tempInicial = System.currentTimeMillis();  
            byte[] textoencriptado = criptografar(palavra, chaveencriptacao);

            System.out.print("Texto Encriptado: ");

            for (int i = 0; i < textoencriptado.length; i++) {
                System.out.print(new Integer(textoencriptado[i]) + " ");
            }
            System.out.print("\n");
            
            String textodecriptado = decriptografar(textoencriptado, chaveencriptacao);

            System.out.printf("Texto Decriptado: %s\n", textodecriptado);
            
            long tempFinal = System.currentTimeMillis();
            System.out.printf("Tempo de execução: %.5f ms\n", (tempFinal - tempInicial) / 1000d);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] criptografar(String txt, String chave) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chave.getBytes("UTF-8"), "AES");//Conversão
        encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv.getBytes("UTF-8")));//conversão
        return encripta.doFinal(txt.getBytes("ASCII"));
    }

    public static String decriptografar(byte[] textoencriptado, String chaveencriptacao) throws Exception {
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");//conversão
        decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv.getBytes("UTF-8")));//conversão
        return new String(decripta.doFinal(textoencriptado), "ASCII");
    }

}
