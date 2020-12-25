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

    public static String replaceToken() {

        String P42 = "/api/products/imports/{0,number,#}?shop_id={1,number,#}";
        String output = java.text.MessageFormat.format(P42, new Object[] {12221222, 12333333});
        return output;

    }

/**
 * Print your Java Xmas tree :)
 * 
 * printTree(5) 
 * 
 *       *
 *      @**
 *     *@***
 *    *@*@@**
 *   @*****@*@
 *       #
 * 
 */
public static void printTree(int stars) {

    stars = stars % 2 == 0 ? stars++ : stars;
    int steps = 1;
    int whites = stars / 2;

    do {
        
        String decorationS = "*".repeat(steps);
        char decoration[] = decorationS.toCharArray();

        for ( int index = 0; index < ( decorationS.length()) ; index++ ) {
            int position = (int) (Math.random() * decorationS.length());
            decoration[position] = '@';
        }

        System.out.println(" ".repeat(whites) + new String(decoration));
        
        steps = steps + 2;
        whites--;

    } while ( steps <= stars );

    System.out.println(" ".repeat((stars / 2)) + "#");
}

    public static void main(String[] args) {
        // System.out.println(stringsXOR("01010", "10101"));
        // System.out.println(replaceToken());
        printTree(10);
    }

    

}