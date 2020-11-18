import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionFathomHealth {
    
    // public static int[] sort(int[] input, int value, int index) {
        
    //     for ( int index = 0; index < input.length; index ++ ) { 
    //         if ( value < input[index] ) {
    //             int tmp = input[index];
    //             input[index] = value;
                
    //         }
    //     }
        
    // }
        
    
    public static int[] merge(int[] a, int[] b) {
        
        int[] output = new int[a.length + b.length];

        int innerIndex = 0;
        int index = 0;
        int endIndex = a.length <= b.length ? b.length : a.length;
        
        // a = 1 b = 2 output = 1, 2
        // a = 4 b = 6 output = 1, 2, 4, 6
        // a = 3 b = 7 output = 1, 2, 4, 6, 3, 7
        while ( index < endIndex ) {
            
            if ( a.length > index && b.length > index ) {
                
                if ( a[index] <= b[index] ) {
                    output[innerIndex] = a[index];
                    output[innerIndex + 1] = b[index];
                } else {
                    output[innerIndex] = b[index];
                    output[innerIndex + 1] = a[index];
                }
              
                innerIndex = innerIndex + 2;
                
            } else {
                
                if ( a.length < index ) {
                    output[innerIndex] = b[index];
                } else {
                    output[innerIndex] = a[index];
                }
                
                innerIndex++;
            }
            
            index++;
            
        }
        
        return output;
        
    }
    
    
    // public static int[] mergeSort(int[] array) {
        
    //     // int[] result = new int[array.length];
        
    //     // int middleIndex = array.length / 2; 
    //     // bool finished = false; 
    //     // int index = 0;
        
    //     // while (!finished) {
            
    //     //     if ( )
            
    //     // }
        
        
    //     // for ( int index; index < array.length; index++ ) {
            
    //     // }
        
    // }
    
    public static void main(String args[] ) throws Exception {
        
        int[] arrays = new int[] {4, 5, 7, 1, 3, 4};
        
        System.out.println(Arrays.toString( merge(new int[]{1, 4, 5}, new int[]{2, 6, 7, 8}))); // expect 1, 2, 4, 5, 6, 7, 8
        System.out.println("Hello World");
    }
}