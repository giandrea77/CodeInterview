package probelmSolving;

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

        java.util.LinkedHashSet<String> substrings = new java.util.LinkedHashSet<String>();

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


    /**
     * https://www.hackerrank.com/challenges/arrays-ds/problem
     * 
     * @param a
     * @return
     */
    static int[] reverseArray(int[] a) {

        int[] output  = new int[a.length];
        int outIndex = 0;

        for ( int index = (a.length - 1); index >= 0; index--) {
            output[outIndex] = a[index];
            outIndex++;
        }

        return output ;

    }


    /**
     * https://www.hackerrank.com/challenges/dynamic-array/problem
     * 
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     *
     * @param n
     * @param queries
     * @return
     */
    public static java.util.List<Integer> dynamicArray(int n, java.util.List<java.util.List<Integer>> queries) {

        int lastAnswer = 0;
        java.util.List<Integer> returns = new java.util.ArrayList<>();
        java.util.List<java.util.List<Integer>> oList = new java.util.ArrayList<java.util.List<Integer>>();

        for ( int index = 0; index < n; index++ ) {
            oList.add(new java.util.ArrayList<>());
        }

        for ( java.util.List<Integer> query : queries ) {

            int index = ( query.get(1) ^ lastAnswer ) % n;

            if ( query.get(0) == 1 ) {    
                oList.get(index).add(query.get(2));
            } else {
                int innerIndex = query.get(2) % oList.get(index).size();
                lastAnswer  = oList.get(index).get(innerIndex);
                returns.add(lastAnswer);
            }

        }

        return returns;
    }

    public static java.util.List<java.util.List<Integer>> initializeData() {

        java.util.List<java.util.List<Integer>> output = new java.util.ArrayList<>();
        output.add(java.util.Arrays.asList(new Integer[] {1, 0, 5}));
        output.add(java.util.Arrays.asList(new Integer[] {1, 1, 7}));
        output.add(java.util.Arrays.asList(new Integer[] {1, 0, 3}));
        output.add(java.util.Arrays.asList(new Integer[] {2, 1, 0}));
        output.add(java.util.Arrays.asList(new Integer[] {2, 1, 1}));

        return output;

    }

    /**
     * https://www.hackerrank.com/challenges/array-left-rotation/problem
     * 
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     * @param d
     * @param arr
     * @return
     */
    public static java.util.List<Integer> rotateLeft(int d, java.util.List<Integer> arr) {
        
        // Write your code here
        Integer[] output = new Integer[arr.size()];

        for ( int index = 0; index < arr.size(); index++ ) {

            int newIndex = ( index - d + arr.size() ) % arr.size();
            output[newIndex] = arr.get(index);

        }

        return java.util.Arrays.asList(output);
    
    }

    /**
     * https://www.hackerrank.com/challenges/sparse-arrays/problem
     * 
     * @param strings
     * @param queries
     * @return
     */
    static int[] matchingStrings(String[] strings, String[] queries) {

        java.util.List<Integer> output = new java.util.ArrayList<>();

        java.util.List<String> strings_l = java.util.Arrays.asList(strings);
        java.util.List<String> queries_l = java.util.Arrays.asList(queries);

        for ( String query : queries_l ) {

            int counter = 0;

            for ( String string : strings_l ) {
                if ( query.equals(string)) {
                    counter++;
                }
            }
            
            output.add(counter);
            
        }

        int[] output_a = output.stream().mapToInt(i -> i).toArray();

        return output_a;

    } 

    /**
     * https://www.hackerrank.com/challenges/crush/problem
     * 
     * @param n
     * @param queries
     * @return
     */
    static long arrayManipulation(int n, int[][] queries) {

        long[] sums = new long[n + 1];
        long max_value = 0;

        for ( int index = 0; index < queries.length; index++  ) {

            int a = queries[index][0];
            int b = queries[index][1];
            int k = queries[index][2];

            sums[a-1] += k;
            sums[b] += k * -1;

        }
        
        long sum = 0;
        for ( int index = 0; index < n; index++ ) {
            
            sum += sums[index];
            sums[index] = sum;

            if ( sum > max_value ) {
                max_value = sum;
            }

        }

        return max_value;

    }


    /**
     * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
     * 
     * @param head
     */
    static void printLinkedList(SinglyLinkedListNode head) {

        if ( head == null ) {
            return;
        }

        System.out.println(head.data);
        printLinkedList(head.next);
        
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
    
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    /**
     * 
     * 
     * @param head
     * @param data
     * @return
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
        head.next = singlyLinkedListNode;

        return head;

    }

    /**
     * 
     * 
     * @param llist
     * @param data
     * @return
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        return null;
    }

    public static void main(String[] args) {
        
        // gradingStudents(java.util.Arrays.asList(73, 67, 38, 33));
        // System.out.println(superReducedString("aa"));

        // printCombination(new int[] {1, 2, 3, 4, 5, 6}, 6, 6); 

        // reverseArray(new int[] {1, 2, 3, 4, 5, 6});

        // *** https://www.hackerrank.com/challenges/dynamic-array/problem *** 
        // java.util.List<Integer> output = dynamicArray(2, initializeData());
        // output.forEach(System.out::println);

        // *** https://www.hackerrank.com/challenges/array-left-rotation/problem
        // java.util.List<Integer> output = rotateLeft(4, Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        // output.forEach(System.out::println);

        // *** https://www.hackerrank.com/challenges/sparse-arrays/problem
        // int[] output = matchingStrings(new String[] {"aba", "baba", "aba", "xzxb"}, new String[] {"aba", "xzxb", "ab"});

        // *** https://www.hackerrank.com/challenges/crush/problem
        // System.out.println(arrayManipulation(5, new int[][]{{1,2,100}, {2,5,100},{3,4,100}}));

        // *** https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
        // SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode();
        // singlyLinkedListNode.data = 13;

        // SinglyLinkedListNode nextSinglyLinkedListNode = new SinglyLinkedListNode();
        // nextSinglyLinkedListNode.data = 16;

        // singlyLinkedListNode.next = nextSinglyLinkedListNode;
        // printLinkedList(singlyLinkedListNode);

    }

}


