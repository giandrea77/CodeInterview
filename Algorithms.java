import java.util.Arrays;
import java.util.List;

/**
 * The time complexity of an algorithm estimates how much time the algorithm will use for a given input.
 * A time complexity is denoted O(...) where the three dots represent some func- tion. Usually, the 
 * variable n denotes the input size.
 * 
 * O(1)         The running time of a constant-time algorithm does not depend on the input size.
 * O(logn)      A logarithmic algorithm often halves the input size at each step. The running time of such an 
 *              algorithm is logarithmic, because log2 n equals the number of times n must be divided by 2 to get 1.
 * O(sqrt_n)    A square root algorithm is slower than O(log n) but faster than O(n).
 * O(n)         A linear algorithm goes through the input a constant number of times. 
 * O(n log n)   This time complexity often indicates that the algorithm sorts the input, because the time complexity 
 *              of efficient sorting algorithms is O(n log n). Another possibility is that the algorithm uses a 
 *              data structure where each operation takes O(log n) time.
 * O(n^2)       A quadratic algorithm often contains two nested loops.
 * O(n^3)       A cubic algorithm often contains three nested loops.
 * O(2^n)       This time complexity often indicates that the algorithm iterates through all subsets of the input elements.
 *              For example, the subsets of {1, 2, 3} are ∅, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, and {1, 2, 3}.
 * O(n!)        This time complexity often indicates that the algorithm iterates through all permutations of the input elements. 
 *              For example, the permutations of {1, 2, 3} are (1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), and (3,2,1).
 * 
 * NP-hard problems are an important set of problems, for which no polynomial algorithm is known.
 * 
 */
public class Algorithms {

    // private int max(Integer[] set) {

    //     if ( set.length == 1 ) {
    //         return set[0];
    //     } else if ( set.length == 2 ) {
    //         return set[0] >= set[1] ? set[0] : set[1];
    //     } else {

            

    //     }



    // }

    /**
     * Bubble sort: O(n^2) because in the worst case, O(n2) swaps are required for sorting the array.
     * 
     * @param input
     * @return
     */
    private static List<Integer> bubbleSort(Integer[] input) {

        for ( int index = 0; index < input.length; index++ ) {

            for ( int inner_index = 0; inner_index < input.length - 1; inner_index++ ) {

                if ( input[inner_index] > input[inner_index+1] ) {

                    int tmp = input[inner_index+1];
                    input[inner_index+1] = input[inner_index];
                    input[inner_index] = tmp;

                }

            }
        }

        return Arrays.asList(input);

    }



    public static void main(String[] args) {

        List<Integer> output = bubbleSort(new Integer[] {1, 3, 5, 5, 2, 3, 4, 5, 6});
        output.forEach(System.out::println);
        
    }

}