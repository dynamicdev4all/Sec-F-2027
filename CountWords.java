public class CountWords {
    public static void main(String[] args) {
        String s =  "THis is rdec sec f";
        int whiteSpace = 0;
        for  (int  i  =   0 ; i < s.length( ); i++) {
            if (s.charAt(i) == ' ') {
                whiteSpace++;
            }
        }
    }
}
