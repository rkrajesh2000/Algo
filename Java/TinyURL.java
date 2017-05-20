package Algo.Test;

public class TinyURL {

    private static final String ALPHABET_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" ;
    private static final int BASE = ALPHABET_MAP.length() ;
  
    public static String encode ( int IndexNum ) {
        StringBuilder sb = new StringBuilder() ;

        while ( IndexNum > 0 ) {
            sb.append(ALPHABET_MAP.charAt(IndexNum % BASE )) ;
            IndexNum /= BASE ;
        }
        return sb.reverse().toString() ;
    }

    public static int decode(String str) {
        int Num = 0 ;

        for ( int i = 0, len = str.length(); i < len; i++ ) {
            //Num = Num * BASE + ALPHABET_MAP.indexOf(str.charAt(i)) ;
            Num = Num + (ALPHABET_MAP.indexOf(str.charAt(i)) * (int)Math.pow((double)BASE, (double)(len-1-i)));
        }
        return Num ;
    }
    
    public static void main ( String[] args ) {

        System.out.println(encode(123));
        System.out.println(encode(123123));
        System.out.println(encode(1231233));
        System.out.println(decode("b9"));
    }    
}
