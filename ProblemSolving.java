import java.util.LinkedHashSet;

/**
 * @author Andrea
 * @implNote Hacker Rank implementations
 * 
 * https://www.hackerrank.com/domains/algorithms?filters%5Bstatus%5D%5B%5D=unsolved&badge_type=problem-solving
 * 
 */

public class ProblemSolving {

    /**
     * https://www.hackerrank.com/challenges/mark-and-toys/problem
     * @param prices
     * @param k
     * @return
     */
    static int maximumToys(int[] prices, int k) {

        int affordable[] = java.util.Arrays.stream(prices).filter(x -> x <= k).toArray();
        java.util.Arrays.sort(affordable);

        int loopSum = 0;
        int counter = 0;

        for ( int index = 0; index < affordable.length; index++ ) {

            loopSum += affordable[index];            
            if (loopSum > k) {
                break;
            }

            counter++;

        }

        return counter;
    }

    /**
     * https://www.hackerrank.com/challenges/grading/problem?h_r=internal-search
     * 
     * @param grades
     * @return
     */
    public static java.util.List<Integer> gradingStudents(java.util.List<Integer> grades) {
        // Write your code here

        java.util.List<Integer> results = new java.util.ArrayList<Integer>();

        for ( Integer currentGrade : grades ) {

            if ( currentGrade < 38 ) {
                results.add(currentGrade);
                continue;
            }

            if ( currentGrade % 5 == 0 ) {
                results.add(currentGrade);
            } else {
                results.add(5 - currentGrade %5 < 3 ? currentGrade + ( 5 - currentGrade %5) : currentGrade);
            }

        }

        return results;

    }

    /**
     * https://www.hackerrank.com/challenges/reduced-string/problem
     * 
     * @param s
     * @return
     */
    static String superReducedString(String s) {

        StringBuilder sb = new StringBuilder(s);

        int index = 0;
        while ( index < sb.length() - 1) {

            if ( sb.charAt(index) == sb.charAt(index + 1) ) {
                sb.deleteCharAt(index + 1);
                sb.deleteCharAt(index);
                index = 0;
            } else {
                index ++;
            }
        }

        if ( sb.length() == 0 ) {
            return "Empty String";
        } else {
            return sb.toString();
        }

    }

    /**
     * https://www.hackerrank.com/challenges/strong-password/problem
     * 
     * @param n
     * @param password
     * @return
     */
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        String lowercase = ".*[a-z]+.*";
        String uppercase = ".*[A-Z]+.*";
        String num = ".*[0-9]+.*";
        String specialchar = ".*[-!@#$%^&*()+]+.*"; 

        int counter = 0;

        if ( !password.matches(lowercase) ) {
            counter++;
        }

        if ( !password.matches(uppercase) ) {
            counter++;
        }

        if ( !password.matches(num) ) {
            counter++;
        }

        if ( !password.matches(specialchar)) {
            counter++;
        }

        if( (6 - password.length() ) > 0 && counter <= (6 - password.length()) ) {
            return (6 - password.length() );
        }
    
        return counter;

    }

    private static java.util.LinkedHashSet<String> allSubStrings(String s) {

        LinkedHashSet<String> substrings = new LinkedHashSet<String>();

        for ( int index = 0; index < s.length(); index ++ ) {

            for ( int inner_index = index + 1; inner_index <= s.length(); inner_index ++ ) {
                substrings.add(s.substring(index, inner_index));
            }

        }

        return substrings;

    }

    /**
     * https://www.hackerrank.com/challenges/common-child/problem
     * 
     * @param s1
     * @param s2
     * @return
     */
    static int commonChild(String s1, String s2) {

        // java.util.LinkedHashSet<String> substrings = new java.util.LinkedHashSet<String>();
        // String workiString = new String();

        // if ( s1.length() < s2.length() ) {
        //     substrings = allSubStrings(s1);
        //     workiString = s2;
        // } else {
        //     substrings = allSubStrings(s2);
        //     workiString = s1;
        // }

        // int max

        return 0;
        
    }

    static void combinationUtil(int arr[], int data[], int start, 
                                int end, int index, int r) 
    { 
        // Current combination is ready to be printed, print it 
        if (index == r) 
        { 
            for (int j=0; j<r; j++) 
                System.out.print(data[j]+" "); 
            System.out.println(""); 
            return; 
        } 
  
        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = arr[i]; 
            combinationUtil(arr, data, i+1, end, index+1, r); 
        } 
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static void printCombination(int arr[], int n, int r) 
    { 
        // A temporary array to store all combination one by one 
        int data[]=new int[r]; 
  
        // Print all combination using temprary array 'data[]' 
        combinationUtil(arr, data, 0, n-1, 0, r); 
    } 


    public static void main(String[] args) {
        
        // gradingStudents(java.util.Arrays.asList(73, 67, 38, 33));
        // System.out.println(superReducedString("aa"));

        printCombination(new int[] {1, 2, 3, 4, 5, 6}, 6, 6); 

    }

}

