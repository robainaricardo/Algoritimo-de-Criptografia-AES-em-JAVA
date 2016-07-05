
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
    
    
    public static int  bloco2 [][] =  {{0x32,0x88,0x31,0xe0},
                                       {0x43,0x5a,0x31,0x37},
                                       {0xf6,0x30,0x98,0x07},
                                       {0x8a,0x8d,0xa2,0x34}};
            
    public static int chave [][] = {{0x2B,0x28,0xAB,0x09},
                                    {0x7E,0xAE,0xF7,0xCF},
                                    {0x15,0xD2,0x15,0x4F},
                                    {0x16,0xA6,0x88,0x3C}};
     
    public static int chave2 [][] = {{0xa0,0x88,0x23,0x2a},
                                     {0xfa,0x54,0xa3,0x6c},
                                     {0xfe,0x2c,0x39,0x76},
                                     {0x17,0xb1,0x39,0x05}};
    
    public static int [][] novoBloco = new int [4][4];
    public static int [][] roundKeys = new int [4][44];
    
    //Variavel que altera o numero de blocos utilizada para testes
    public static int nBloco = 1000000000; 
    
    public static void main(String[] args) {
      
        

        MetodosAES met = new MetodosAES();
        Cifra cif = new Cifra();
        
        //Variavel que armazena o tempo inicial da execução
        long inicio = System.currentTimeMillis();
        
        new Thread() {
            public void run() {
                long ini = System.currentTimeMillis();
		System.out.println("\n\n Inicio Thread 1: " + ini);
                for(int n = 0; n < (nBloco/8); n++){
            
                novoBloco = cif.Encriptar(bloco, chave);
                 bloco2 = novoBloco;
                //System.out.printf("\n\nBloco %d\n\n",n);
                //met.printMat(novoBloco);
                }		
		System.out.println("\n\n Fim Thread 1: " + (System.currentTimeMillis() - ini));		
            }
	}.start();
        
        new Thread() {
            public void run() {
		long ini = System.currentTimeMillis();
		System.out.println("\n\n Inicio Thread 2: " + ini);
                for(int n = 0; n < (nBloco/8); n++){
            
            novoBloco = cif.Encriptar(bloco2, chave);
            bloco2 = novoBloco;
            //System.out.printf("\n\nBloco %d\n\n",n);
            //met.printMat(novoBloco);
                }		
		System.out.println("\n\n Fim Thread 2: " + (System.currentTimeMillis() - ini));			
            }
	}.start();
        
        
        new Thread() {
            public void run() {
		long ini = System.currentTimeMillis();
		System.out.println("\n\n Inicio Thread 3: " + ini);
                for(int n = 0; n < (nBloco/8); n++){
            
            novoBloco = cif.Encriptar(bloco3, chave);
            bloco2 = novoBloco;
            //System.out.printf("\n\nBloco %d\n\n",n);
            //met.printMat(novoBloco);
                }		
		System.out.println("\n\n Fim Thread 3: " + (System.currentTimeMillis() - ini));			
            }
	}.start();
        
        new Thread() {
            public void run() {
		long ini = System.currentTimeMillis();
		System.out.println("\n\n Inicio Thread 4: " + ini);
                for(int n = 0; n < (nBloco/8); n++){
            
            novoBloco = cif.Encriptar(chave2, chave);
            bloco2 = novoBloco;
            //System.out.printf("\n\nBloco %d\n\n",n);
            //met.printMat(novoBloco);
                }		
		System.out.println("\n\n Fim Thread 4: " + (System.currentTimeMillis() - ini));			
            }
	}.start();
        
        new Thread() {
            public void run() {
                long ini = System.currentTimeMillis();
		System.out.println("\n\n Inicio Thread 5: " + ini);
                for(int n = 0; n < (nBloco/8); n++){
            
                novoBloco = cif.Encriptar(bloco, chave);
                 bloco2 = novoBloco;
                //System.out.printf("\n\nBloco %d\n\n",n);
                //met.printMat(novoBloco);
                }		
		System.out.println("\n\n Fim Thread 5: " + (System.currentTimeMillis() - ini));		
            }
	}.start();
        
        new Thread() {
            public void run() {
		long ini = System.currentTimeMillis();
		System.out.println("\n\n Inicio Thread 6: " + ini);
                for(int n = 0; n < (nBloco/8); n++){
            
            novoBloco = cif.Encriptar(bloco2, chave);
            bloco2 = novoBloco;
            //System.out.printf("\n\nBloco %d\n\n",n);
            //met.printMat(novoBloco);
                }		
		System.out.println("\n\n Fim Thread 6: " + (System.currentTimeMillis() - ini));			
            }
	}.start();
        
        
        new Thread() {
            public void run() {
		long ini = System.currentTimeMillis();
		System.out.println("\n\n Inicio Thread 7: " + ini);
                for(int n = 0; n < (nBloco/8); n++){
            
            novoBloco = cif.Encriptar(bloco2, chave);
            bloco2 = novoBloco;
            //System.out.printf("\n\nBloco %d\n\n",n);
            //met.printMat(novoBloco);
                }		
		System.out.println("\n\n Fim Thread 7: " + (System.currentTimeMillis() - ini));			
            }
	}.start();
        
        new Thread() {
            public void run() {
		long ini = System.currentTimeMillis();
		System.out.println("\n\n Inicio Thread 8: " + ini);
                for(int n = 0; n < (nBloco/8); n++){
            
            novoBloco = cif.Encriptar(chave, chave);
            bloco2 = novoBloco;
            //System.out.printf("\n\nBloco %d\n\n",n);
            //met.printMat(novoBloco);
                }		
		System.out.println("\n\n Fim Thread 8: " + (System.currentTimeMillis() - ini));			
            }
	}.start();
        
        
        //Variavel que armazena o tempo inicial da execução
        long fim = System.currentTimeMillis();
        //Tempo médio
        long tempoTotal = fim - inicio;
        System.out.println("\n\nTempo TOTAL : " + tempoTotal);
        
        
        
    }

 
}
