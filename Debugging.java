/**
 * 
 */
public class Debugging {


    /**
     * 
        INPUT	OUTPUT
        A	B	A XOR B
        0	0	0
        0	1	1
        1	0	1
        1	1	0

     * @param s
     * @param t
     * @return
     */
    public static String stringsXOR(String s, String t) {

        StringBuilder res = new StringBuilder();

        for ( int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == t.charAt(i) ) {
                res.append("0");
            } else {
                res.append("1");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringsXOR("01010", "10101"));
    }

}