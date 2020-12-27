import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Support class
 */
class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

/**
 * https://www.hackerrank.com/interview/interview-preparation-kit
 */
public class InterviewPreparation {

    /* Sock merchant */
    public static int sockMerchant(int n, int[] ar) {

        boolean stop = false;
        int pairs = 0;

        do {

            int leftSock = 0;

            for (int index = 0; index < ar.length; index++) {

                // Find sock if left sock exists
                if (leftSock > 0 && leftSock == ar[index]) {
                    pairs++;
                    ar[index] = 0;
                    break;
                } else if (leftSock > 0) {
                    // Serach sock mode
                    continue;
                }

                // Halt control
                if (leftSock > 0 && index == (ar.length - 1)) {
                    break;
                }

                // Halt control
                if (leftSock == 0 && index == (ar.length - 1)) {
                    stop = true;
                    break;
                }

                // Pick a left sock
                if (ar[index] != 0) {
                    leftSock = ar[index];
                    ar[index] = 0;
                    continue;
                }

            }

        } while (!stop);

        return pairs;

    }

    /* Fibonacci */
    public static int fibonacci(int n) {

        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /*
     * [Interview preparation] https://www.hackerrank.com/challenges/2d-array/problem
     * [Java training] https://www.hackerrank.com/challenges/java-2d-array/problem
     */
    public static int hourglassSum(int[][] arr) {

        int maxHourglassSum = -10000;

        for (int row = 1; row < 5; row++) {

            for (int col = 1; col < 5; col++) {

                int hourglassSum = arr[row - 1][col - 1] + arr[row - 1][col] + arr[row - 1][col + 1]
                        + arr[row][col] + arr[row + 1][col - 1] + arr[row + 1][col] + arr[row + 1][col + 1];

                if ( hourglassSum > maxHourglassSum) {
                    maxHourglassSum = hourglassSum;
                }
            }

        }

        return maxHourglassSum;

    }

    /*
     * Recursive Digit Sum
     * 
     * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
     */
    public static int superDigit(String n, int k) {

        if (n.length() == 1) {
            return Integer.valueOf(n);
        }

        if (k > 0) {
            n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";
        }

        int sum = 0;
        char[] numbers = n.replace("0", "").toCharArray();
        for (int index = 0; index < numbers.length; index++) {
            sum += Character.getNumericValue(numbers[index]);
        }

        return superDigit(String.valueOf(sum), 0);

    }

    /*
     * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&
     * playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
     * 
     */
    public static int minimumSwaps(int[] arr) {

        int index = 0, swap = 0;

        while (index < arr.length) {

            if (index + 1 == arr[index]) {
                // Right position
                index++;
                continue;
            } else {
                arr = swap(arr, index, arr[index] - 1);
                swap++;
                index = 0;
            }

        }

        return swap;

    }

    private static int[] swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
        return arr;
    }

    /**
     * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
     * 
     * @param a
     */
    public static void countSwaps(int[] a) {

        int counter = 0;

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    a = swap(a, j, j + 1);
                    counter++;
                }
            }

        }

        System.out.println("Array is sorted in " + counter + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);

    }

    public static int maximumToys(int[] prices, int k) {

        int affordable[] = java.util.Arrays.stream(prices).filter(x -> x <= k).toArray();
        java.util.Arrays.sort(affordable);

        int loopSum = 0;
        int counter = 0;

        for (int index = 0; index < affordable.length; index++) {

            loopSum += affordable[index];
            if (loopSum > k) {
                break;
            }

            counter++;

        }

        return counter;

    }

    private static boolean isAnagram(String string1, String string2) {

        if ( string1.length() != string2.length() ) {
            return false;
        }

        char[] chars1 = string1.toLowerCase().toCharArray();
        char[] chars2 = string2.toLowerCase().toCharArray();

        java.util.Arrays.sort(chars1);
        java.util.Arrays.sort(chars2);

        if ( Arrays.equals(chars1, chars2) ) {
            return true;
        }

        return false;

    }

    public static List<String> funWithAnagrams(List<String> s) {
        
        int index = 0;
        while ( index < s.size() ) {

            String[] stringArray = s.toArray(new String[0]);

            for ( int innerIndex = 0; innerIndex < stringArray.length; innerIndex++ ) {

                if ( innerIndex == index ) {
                    continue;
                }

                if ( stringArray[index].length() != stringArray[innerIndex].length() ) {
                    continue;
                }

                if ( isAnagram(stringArray[index], stringArray[innerIndex]) ) {
                    s.remove(stringArray[innerIndex]);
                    index = -1;
                    break;
                } 

            }

            index++;

        }

        String[] stringArray = s.toArray(new String[0]);
        Arrays.sort(stringArray);
        return Arrays.asList(stringArray);

    }

    public static boolean isPrime(int n) {

        if ( n == 1 || n == 2 ) {
            return true;
        }

        if ( n % 2 == 0) { 
            return false;
        }

        for ( int index = 3; index < n - 1; index ++ ) {

            if ( n % index == 0) {                
                return false;
            }

        }

        return true;

    }

    /**
     * https://www.hackerrank.com/challenges/ctci-big-o/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
     * 
     * @param n
     * @return
     */
    static String primality(long n) {

        if ( n == 1 ) {
            return "Not prime";    
        }

        if ( n < 4 || n == 5 ) {
            return "Prime";
        }

        if ( n % 2 == 0 || n % 3 == 0 || n % 5 == 0 ) { 
            return "Not prime";
        }

        long index = 3;
        while ( index <= (long) Math.sqrt(n) + 1 ) {

            if ( n % index == 0) {                
                return "Not prime";
            }

            index = index + 2;

        }

        return "Prime";
    }

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
     * 
     * @param s
     * @return
     */
    // static String isValid(String s) {
        
    // }

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
     * 
     * @param s
     * @return
     */
    static int sherlockAndAnagrams(String s) {
        
        StringBuffer sb = new StringBuffer(s);

        Vector<String> strings = new Vector<>();

        for ( int index = 0; index < s.length(); index++ ) {

            for ( int inner_index = index + 1; inner_index <= s.length(); inner_index++ ) {                
                
                strings.add(sb.substring(index, inner_index));                
                System.out.println(sb.substring(index, inner_index));

            }

        }

        int counter = 0;

        for ( int index = 0; index < strings.size(); index++ ) {

            for ( int inner_index = strings.size() - 1; inner_index > 0; inner_index-- ) {

                if ( index == inner_index ) {
                    break;
                }

                if (isAnagram(strings.get(index), strings.get(inner_index))) {
                    counter++;
                }

            }

        }

        return counter;

    }

    /**
     * https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
     */
    static int alternatingCharacters(String s) {

        StringBuilder sb = new StringBuilder(s);

        int index = 0;
        int removedChar = 0; 
        while ( index < sb.length() - 1) {
            if ( sb.charAt(index) == sb.charAt(index + 1 ) ) {
                sb.deleteCharAt(index + 1);
                removedChar++;
            } else {
                index++;
            }
        }

        return removedChar;

    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {        
        // System.out.println(fibonacci(100));
		// System.out.println(sockMerchant(20, new int[] {4, 5, 5, 5, 6, 6, 4, 1, 4, 4, 3, 6, 6, 3, 6, 1, 4, 5, 5, 5}));
        // System.out.println(hourglassSum(new int[][] { 
        //         // {1, 1, 1, 0, 0, 0}, 
        //         // {0, 1, 0, 0, 0, 0}, 
        //         // {1, 1, 1, 0, 0, 0}, 
        //         // {0, 0, 2, 4, 4, 0}, 
        //         // {0, 0, 0, 2, 0, 0}, 
        //         // {0, 0, 1, 2, 4, 0}
        //         // {-9, -9, -9, 1, 1, 1},
        //         // {0, -9, 0, 4, 3, 2},
        //         // {-9, -9, -9, 1, 2, 3},
        //         // {0, 0, 8, 6, 6, 0},
        //         // {0, 0, 0, -2, 0, 0},
        //         // {0, 0, 1, 2, 4, 0}    
                
        //         {-1, -1, 0, -9, -2, -2},
        //         {-2, -1, -6, -8, -2, -5},
        //         {-1, -1, -1, -2, -3, -4},
        //         {-1, -9, -2, -4, -4, -5},
        //         {-7, -3, -3, -2, -9, -9},
        //         {-1, -3, -1, -2, -4, -5}
        //     }));

        // System.out.print(superDigit("148",3));
        
        // System.out.println(minimumSwaps(new int[] {2, 3, 4, 1, 5}));

        // System.out.println(minimumSwaps(new int[] {974, 328, 380, 817, 304, 214, 787, 319, 291, 144, 393, 581, 838, 745, 946, 535, 61, 413, 441, 703, 901, 609, 114, 10, 972, 806, 218, 275, 300, 792, 249, 554, 407, 741, 979, 539, 164, 163, 874, 552, 428, 130, 480, 24, 746, 382, 306, 952, 766, 55, 423, 881, 813, 253, 203, 294, 467, 337, 368, 798, 281, 523, 311, 998, 518, 911, 309, 601, 782, 743, 479, 199, 930, 179, 727, 777, 707, 973, 595, 165, 633, 255, 639, 26, 532, 30, 400, 840, 252, 748, 737, 567, 562, 965, 825, 857, 791, 955, 716, 991, 142, 210, 886, 100, 408, 773, 174, 730, 91, 38, 759, 987, 313, 755, 483, 182, 833, 204, 119, 713, 21, 951, 781, 197, 71, 229, 702, 768, 361, 489, 731, 807, 941, 398, 495, 687, 75, 99, 624, 31, 153, 541, 647, 143, 508, 2, 405, 578, 982, 112, 152, 873, 525, 610, 329, 900, 856, 889, 357, 574, 51, 953, 537, 121, 470, 648, 835, 794, 14, 240, 348, 883, 421, 868, 454, 751, 16, 937, 507, 202, 243, 872, 438, 104, 80, 764, 645, 254, 804, 8, 637, 910, 772, 151, 653, 28, 515, 836, 132, 810, 996, 606, 544, 778, 655, 738, 880, 50, 97, 757, 921, 612, 187, 579, 430, 435, 896, 960, 843, 347, 148, 908, 723, 673, 346, 206, 821, 138, 585, 569, 43, 620, 656, 318, 137, 672, 841, 449, 822, 580, 76, 550, 213, 947, 231, 797, 63, 310, 117, 750, 516, 396, 641, 608, 823, 816, 514, 568, 614, 217, 783, 450, 377, 297, 340, 561, 73, 734, 136, 799, 162, 774, 559, 864, 205, 453, 23, 472, 892, 424, 140, 642, 924, 524, 909, 975, 596, 847, 760, 146, 317, 695, 186, 697, 172, 420, 805, 717, 170, 451, 372, 417, 780, 842, 485, 986, 375, 270, 322, 636, 227, 44, 201, 488, 267, 236, 410, 216, 983, 963, 771, 434, 719, 221, 37, 17, 33, 362, 519, 626, 762, 25, 993, 747, 302, 812, 191, 110, 93, 597, 828, 682, 819, 282, 312, 679, 869, 761, 367, 712, 351, 557, 345, 686, 859, 865, 749, 546, 167, 677, 861, 916, 1, 158, 314, 409, 326, 343, 464, 239, 12, 917, 257, 237, 383, 837, 926, 894, 528, 674, 553, 260, 139, 299, 74, 852, 635, 968, 887, 378, 77, 448, 888, 124, 854, 220, 211, 154, 141, 681, 978, 455, 419, 66, 126, 870, 127, 27, 827, 298, 970, 444, 815, 185, 366, 820, 264, 906, 700, 769, 107, 305, 57, 147, 534, 685, 928, 285, 334, 198, 316, 533, 664, 276, 878, 849, 591, 7, 666, 728, 529, 458, 277, 395, 629, 376, 560, 129, 551, 381, 200, 111, 935, 471, 244, 621, 994, 512, 944, 691, 790, 789, 494, 890, 90, 669, 262, 684, 920, 19, 95, 271, 195, 246, 307, 176, 287, 501, 20, 720, 209, 284, 330, 526, 785, 721, 359, 497, 352, 88, 948, 219, 715, 443, 565, 587, 161, 371, 358, 903, 68, 885, 456, 384, 323, 758, 689, 42, 705, 542, 251, 932, 86, 696, 22, 387, 134, 386, 517, 754, 15, 336, 447, 663, 177, 867, 676, 169, 9, 32, 196, 616, 113, 70, 593, 509, 826, 365, 575, 69, 289, 801, 997, 155, 505, 230, 775, 250, 957, 962, 288, 427, 333, 884, 594, 279, 500, 178, 607, 83, 829, 59, 47, 649, 536, 324, 452, 215, 690, 603, 971, 683, 120, 584, 64, 247, 48, 942, 283, 58, 466, 735, 82, 660, 652, 308, 412, 349, 511, 605, 89, 722, 46, 658, 339, 487, 81, 29, 72, 832, 431, 904, 92, 498, 611, 877, 266, 793, 905, 445, 228, 545, 803, 661, 54, 109, 699, 934, 36, 558, 13, 665, 320, 491, 929, 404, 222, 389, 5, 259, 98, 586, 954, 226, 156, 795, 740, 40, 234, 429, 265, 335, 476, 530, 238, 604, 897, 657, 753, 331, 390, 701, 62, 543, 776, 619, 11, 765, 65, 549, 893, 159, 602, 41, 876, 274, 956, 115, 232, 188, 131, 851, 898, 866, 439, 570, 521, 493, 360, 363, 788, 520, 85, 714, 469, 212, 985, 858, 736, 207, 379, 589, 183, 506, 461, 477, 388, 39, 980, 871, 907, 919, 855, 913, 492, 977, 615, 853, 415, 157, 149, 96, 327, 659, 355, 35, 102, 646, 292, 834, 411, 401, 710, 862, 927, 651, 680, 708, 625, 341, 667, 992, 698, 692, 671, 824, 573, 263, 711, 590, 171, 964, 87, 128, 332, 844, 984, 563, 6, 976, 194, 503, 693, 931, 600, 356, 496, 599, 742, 463, 638, 918, 945, 879, 538, 150, 369, 613, 891, 399, 640, 634, 739, 522, 566, 193, 915, 208, 296, 325, 571, 425, 397, 135, 504, 709, 391, 233, 961, 4, 863, 123, 831, 278, 106, 175, 969, 950, 426, 933, 811, 364, 474, 694, 547, 678, 78, 668, 422, 241, 486, 258, 1000, 116, 718, 414, 752, 767, 848, 160, 784, 922, 293, 478, 577, 502, 225, 943, 168, 630, 995, 839, 184, 374, 446, 850, 173, 786, 315, 662, 457, 949, 583, 654, 52, 989, 350, 242, 406, 105, 403, 468, 354, 392, 592, 618, 617, 733, 527, 45, 290, 133, 845, 49, 295, 846, 990, 548, 224, 576, 145, 442, 770, 190, 724, 181, 166, 402, 433, 484, 338, 118, 818, 531, 235, 988, 437, 344, 67, 261, 555, 385, 923, 966, 3, 510, 999, 796, 256, 875, 490, 280, 914, 459, 726, 588, 223, 643, 465, 981, 744, 627, 272, 936, 180, 248, 394, 675, 79, 499, 460, 53, 125, 353, 860, 732, 103, 779, 60, 84, 108, 473, 925, 122, 540, 373, 189, 808, 269, 814, 273, 582, 632, 622, 650, 725, 436, 18, 631, 475, 34, 101, 756, 321, 704, 556, 688, 342, 959, 895, 418, 432, 763, 899, 882, 729, 938, 912, 644, 482, 670, 94, 902, 303, 416, 967, 939, 56, 623, 802, 370, 572, 830, 301, 958, 513, 809, 268, 245, 286, 192, 564, 481, 462, 940, 628, 706, 800, 440, 598}));

        // countSwaps(new int[] {2, 3, 4, 1, 5});

        // System.out.println(maximumToys(new int[] {51403690, 6801342, 51823919, 7333805, 93468017, 85782415, 58118169, 30631790, 32727891, 83917600, 19839156, 37224683, 98232752, 29122289, 9105772, 36107106, 78312243, 453735, 8420576, 43854024, 49240721, 5861120, 36555031, 77979692, 43491918, 74255615, 45922216, 6141342, 24228750, 97424973, 106118, 28148792, 56742667, 4446390, 35482598, 50210684, 90228805, 46117119, 33358826, 75473048, 82551071, 53197983, 65214083, 80783823, 34836624, 26836208, 69407282, 13148867, 27289943, 30344210, 57002892, 76530664, 88721683, 46074275, 7026708, 84729953, 72846242, 52948924, 90871296, 97074992, 2890249, 90977414, 77740137, 12149268, 95423804, 13222735, 62359952, 38168961, 11856206, 95718779, 66158362, 94407278, 1433114, 31372445, 27707453, 36269738, 58208653, 49631087, 49418606, 38014949, 79975298, 58937850, 67061965, 21213333, 5012125, 74088674, 5943286, 30374720, 79553950, 96814582, 27449712, 34960552, 40308349, 57706201, 47109820, 88248505, 23445288, 61986125, 26417467, 35301495, 57704904, 92575829, 29708773, 59138018, 76464626, 9932578, 47924108, 87189632, 59563666, 49859066, 25204581, 92055316, 61313268, 92266546, 13268649, 18841746, 18871572, 19211935, 49216466, 98425523, 68542870, 29182530, 85902427, 8851219, 86888732, 33012247, 49616076, 10334020, 94998372, 76033543, 45635515, 5219628, 21125724, 27860640, 16873998, 50106703, 37793219, 64798107, 37296335, 97356885, 67173525, 15017268, 89412201, 28486794, 7283814, 55197202, 47328540, 26155387, 74409137, 96545006, 77097262, 95468359, 25727536, 15516041, 56835930, 12616268, 48528288, 6452007, 75466641, 96043013, 35001902, 21102156, 53778993, 8643979, 48962797, 70652992, 58750682, 39272368, 87967451, 96047017, 36629253, 55140976, 63580637, 78557806, 36144122, 70864451, 33755008, 83472662, 49536190, 60680497, 80017668, 79149804, 56148857, 58261557, 94665845, 65501139, 70877825, 95710486, 71953146, 46344466, 44269851, 59471401, 19962975, 98048844, 68115380, 21442124, 21218188, 26866062, 60714492, 991}, 80000000));

        // List<String> places = new ArrayList<>(Arrays.asList("CODE", "ANAGRASM", "anagrams", "doce"));
        // List<String> places2 = funWithAnagrams(places);

        
        //int[] numbers = new int[] {1000000000, 1000000001, 1000000002, 1000000003, 1000000004, 1000000005, 1000000006, 1000000007, 1000000008, 1000000009};
        // for ( int index = 0; index < numbers.length; index++ ) {
        //     System.out.println(primality(numbers[index]));
        // }        

        // System.out.println(sherlockAndAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(alternatingCharacters("AAABBB"));

    }

}