import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andrea
 * @implNote Hacker Rank Java practice implementations
 * 
 *           https://www.hackerrank.com/domains/java
 */
public class JavaChallenge {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING. The function accepts following
     * parameters: 1. INTEGER month 2. INTEGER day 3. INTEGER year
     */
    public static String findDay(int month, int day, int year) {

        String[] strDays = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNSDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, day);
        return strDays[cal.get(java.util.Calendar.DAY_OF_WEEK) - 1];

    }

    /*
     * Check if a BigInteger is probably a prime number    
     * https://www.hackerrank.com/challenges/java-primality-test/problem    
     */
    public static String isPrime(String number) {

        return new java.math.BigInteger(number).isProbablePrime(100) ? "prime" : "not prime";
    }

    /**
     * add and multiply huge numbers! 
     * https://www.hackerrank.com/challenges/java-biginteger/problem
     */
    public static String calculateBigInteger(String numberOne, String numberTwo) {

        java.math.BigInteger one = new java.math.BigInteger(numberOne);
        java.math.BigInteger two = new java.math.BigInteger(numberTwo);

        return one.add(two) + "\n" + one.multiply(two);

    }

    public static final String regularExpression = "([a-zA-Z])(\\w){7,29}";

    /**
     * https://www.hackerrank.com/challenges/valid-username-checker/problem
     * @param args
     */
    public static String usernameValidator(String s) {

        if ( s.matches(regularExpression) ) {
            return "Valid";
        } else {
            return "Invalid";
        }

    }

    /**
     * https://www.hackerrank.com/challenges/tag-content-extractor/problem
     * 
     * Code challenge day #2
     * @param line
     */
    public static void tagContentExtractor(String line) {
    
        boolean matchFound = false;
        Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
        Matcher m = r.matcher(line);

        while (m.find()) {
            System.out.println(m.group(2));
            matchFound = true;
        }

        if ( ! matchFound) {
            System.out.println("None");
        }

    }

    public static void main(String[] args)  {
        
        // System.out.println(findDay(10, 9, 2019));
        // System.out.println(isPrime("12312873127836127833"));
        System.out.println(usernameValidator("aaaaaaa"));

        // tagContentExtractor("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>");

    }

}