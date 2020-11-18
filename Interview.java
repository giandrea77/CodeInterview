import java.util.List;

public class Interview {

    public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
 
        // Write your code here
 
        int totalBooks = 0;

        for ( int index = 0; index < bundleCosts.size(); index++ ) {

            if ( n < bundleCosts.get(index) ) {
                break;
            } 

            int boughtHere = n / bundleCosts.get(index);
            totalBooks = boughtHere * bundleQuantities.get(index);
            n = n % bundleCosts.get(index);

        }

        return totalBooks;

    }
    
    public static void main(String[] args) {
        System.out.println(budgetShopping(60, java.util.Arrays.asList(20, 19), java.util.Arrays.asList(24, 20)));
    }

}