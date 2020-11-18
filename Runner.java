import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrea
 * @implNote Hacker Rank implementations
 * 
 */
public class Runner {

    /**
     * 
     */
    public static String getSmallestAndLargest(String s, int k) {
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
       
        java.util.SortedSet<String> array = new java.util.TreeSet<String>();
           
        for (int index = 0; index <= (s.length() - k); index ++ ) {
            array.add(s.substring(index, index + k));
        }
        
        String smallest = array.first();
        String largest = array.last();
        
        return smallest + "\n" + largest;
       
    }
   
    /*
     * Check if a string is Palindrome
     */
    public static String isPalindrome(String S) {
        
        char array[] = S.toCharArray();		 
        int arrayLength = S.length() - 1;
        
        for (int index = 0; index < S.length(); index++ ) {
            
            if ( array[index] != array[arrayLength - index] ) {
                return "No";
            }
            
        }
        
        return "Yes";
        
    }
    
    /*
     * Check if a string is Anagram
     */
    public static String isAnagram(String a, String b) {
        
        if ( ( a.length() < 1 && a.length() > 50 ) || ( b.length() < 1 && b.length() > 50 ) || ( a.length() != b.length() )){ 
            return "Not Anagrams";
        }
        
        char[] s1Array = a.toLowerCase().toCharArray();		 
        char[] s2Array = b.toLowerCase().toCharArray();

        //Sorting both s1Array and s2Array

        java.util.Arrays.sort(s1Array);
        java.util.Arrays.sort(s2Array);

        //Checking whether s1Array and s2Array are equal

        if ( java.util.Arrays.equals(s1Array, s2Array) ) {
            return "Anagrams";
        } else {
            return "Not Anagrams";
        }
        
    }
    
    
    /*
     * Tokenize 	  
     */
    public void tokenize(String s) {
        
        if ( s.trim().equals("") ) {
            System.out.println("0");
            return;
        } else if(s.length() > 400000){
            return;
        } 

        String[] tokens = s.trim().split("[_@ !,?.']+");
        
        System.out.println(tokens.length);
        
        for ( int index = 0; index < tokens.length; index++ ) {
            System.out.println(tokens[index]);
        }
        
    }
    
    public void isRegEx(String pattern) {
        
        try { 
            
            if ( java.util.regex.Pattern.compile(pattern) != null ) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        
        } catch (Exception ex) {
            System.out.println("Invalid");
        }
    }

    /* Sock merchant */
    public int sockMerchant(int n, int[] ar) {
        
        boolean stop = false;
        int pairs = 0;
        
        do {
            
            int leftSock = 0;
            
            for ( int index = 0; index < ar.length; index++ ) {				 
                
                
                // Find sock if left sock exists
                if ( leftSock > 0 && leftSock == ar[index] ) {
                    pairs++;
                    ar[index] = 0;
                    break;
                } else if ( leftSock > 0 ) {
                    // Serach sock mode
                    continue;
                }
                
                // Halt control
                if ( leftSock > 0 && index == ( ar.length -1) ) {
                    break;
                } 
                
               // Halt control
                if ( leftSock == 0 && index == ( ar.length -1) ) {
                    stop = true;
                    break;
                } 
                
                // Pick a left sock
                if ( ar[index] != 0 ) {
                    leftSock = ar[index];
                    ar[index] = 0;
                    continue;
                }		 
                
            }
            
        } while (!stop);
        
        return pairs;
        
    }
    
    /* Fibonacci */
    public int fibonacci(int n) {
        
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    
    /**
     * Work in progress 
     * @param s
     * @return
     */
    static String isValid(String s) {
        
        java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();
        
        // in case of a aa aaa or aab or abc it works
        if (s.length() <= 3) {
            return "YES";
        }	
        
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        
        for ( int index = 0; index < s.length(); index++ ) {
            if ( !map.containsKey(chars[index]) ) {
                map.put(chars[index], 1);
            } else {
                map.put(chars[index], map.get(chars[index]) + 1);
            }
        }

        return map.toString();
        
    }

    public static int evaluateBinary(BigInteger binary, int counter) {

        if ( binary.equals(BigInteger.ZERO) ) {
            return counter;
        }

        if ( binary.mod(BigInteger.TWO).equals(BigInteger.ZERO) ) {
            return evaluateBinary(binary.divide(BigInteger.TWO), ++counter);
        } else {
            return evaluateBinary(binary.subtract(BigInteger.ONE), ++counter);
        }

    }

    /**
     * Given string S of length N which encodes a non-negative number V in a binary for. 
     * If V is odd, substract 1
     * If V is even, divide it by 2
     * The formula is: <number of ones> + <number of digits> - <index of left most one> - 1
     * 
     * The idea is that the division operation really is a digit-shift to the right, with the rightmost zero dropping off. It reduces the number of digits by 1. 
     * It is also the only way to reduce the number of digits. So you need as many divisions as there are digits in your input, with two exceptions:
     * We should not count pre-padded zeroes.
     * When only one significant digit is left over (a 1-digit), no division will be needed: just a subtraction will be enough.
     * So this means we will need to discount prepadded zeroes (or find the position of the first 1-digit) and count the number of digits from there on, 
     * and subtract one to compensate for the final operation which will not involve a division.
     * 
     * On top of that we need one subtraction operation for any 1-digit in the input: all 1-digits will sooner or later get shifted into the right most position 
     * at which moment a subtraction is necessary to get rid of it.
     * 
     * @param s
     * @return
     */
    public static int solution(String s) {
        int firstOneAt = s.indexOf("1");
        return firstOneAt == -1 ? 0 : s.replace("0", "").length() + s.length() - firstOneAt - 1;
    }

    /**
     * Particle Velocity quiz
     * @param A
     * @return
     */
    public static int stableVelocity(int[] A) {

        if ( A.length < 3 ) {
            return 0;
        }

        int totalPeriods = 0;
        int delta = A[1] - A[0];
        int sameDelta = 0;

        for ( int index = 2; index < A.length; index++ ) {

            if ( A[index] - A[index - 1] == delta ) {
                totalPeriods += 1 + sameDelta;
                sameDelta++;
            } else {
                sameDelta = 0;
                delta = A[index] - A[index - 1];
            }

        }

        return totalPeriods < 1000000000 ? totalPeriods : -1;

    }

    public static void main(String[] args) {
        
		// System.out.println(getSmallestAndLargest("welcometojava", 3));
		
		// System.out.println(isPalindrome("AABBCBBAAA"));
		
		// System.out.println(isAnagram("CAT", "TAC"));
		// tokenize("                        ");
		
		// isRegEx("[AZ[a-z](a-z)");
		// System.out.println(sockMerchant(20, new int[] {4, 5, 5, 5, 6, 6, 4, 1, 4, 4, 3, 6, 6, 3, 6, 1, 4, 5, 5, 5}));
		
		// System.out.println(fibonacci(100));
		
        // System.out.println(isValid("aabbccddeefghi"));
        
        System.out.println(stableVelocity(new int[] {4, 5, 5, 5, 6, 6, 4, 1, 4, 4, 3, 6, 6, 3, 6, 1, 4, 5, 5, 5}));

        System.out.println(solution("1111010101111"));


    }

}