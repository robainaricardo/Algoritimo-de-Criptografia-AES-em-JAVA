package testeaes;

public class Conversoes {

    public byte[] ASCIIparaByteArray(String s, boolean padding) { //static pra não ter que instancia a classe
        int tam, i; //tamanho do padding
        byte p;

        if (padding) {
            tam = s.length() % 16;
            if (tam == 0) {
                tam = 16;
            }
        } else {
            tam = 0; //se ñ tem padding, nao acrescenta nada
        }
        byte[] array = new byte[s.length() + tam];
        for (i = 0; i < s.length(); i++) {
            array[i] = (byte) s.charAt(i);
        }

        p = (byte) tam;
        for (i = s.length(); i < s.length() + tam; i++) {
            array[i] = p;
        }

        return array;
    }

    public  String ByteArrayParaStringH(byte[] q){
        int i;
        char hexa[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        
        StringBuilder buf = new StringBuilder();
        for(i=0; i<q.length; i++){
          buf.append(hexa[(q[i]>>4) & 0x0f]);
          buf.append(hexa[q[i] & 0x0f]);
        }
     return buf.toString();   
    }

    //Eu que fiz
    public String converteTextoParaBytes(String text){
	String txtH = this.ByteArrayParaStringH(this.ASCIIparaByteArray(text, true));
	return txtH;
    }
    
    //arrumar isso imprime carcteres aleatorios no fim NO WINDOWS NÂO ESTA DANDO ESTE ERRO
    public String converteBytesparaTexto(String bytes) {        
    String str = "";
    for(int i=0;i<bytes.length();i+=2)
    {
        String s = bytes.substring(i, (i + 2 ));
        int decimal = Integer.parseInt(s, 16);
        str = str + (char) decimal;
    }       
    return str;
    }
    
    public byte[] StringHparaByteArray(String p){
        
        byte[] resulArray = p.getBytes();
        
  
    return resulArray;    
    }
    
    
    
}
