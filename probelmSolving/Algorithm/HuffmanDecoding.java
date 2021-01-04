package probelmSolving.Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

abstract class Node implements Comparable<Node> {

    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right; 
    public Node(int freq) { 
      frequency = freq; 
    }
 
    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends Node {
    
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}
 
class HuffmanNode extends Node {
    
    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}

public class HuffmanDecoding {

    private static Node buildTree(int[] charFreqs) {
      
        PriorityQueue<Node> trees = new PriorityQueue<Node>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));
 
        assert trees.size() > 0;
      
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Node a = trees.poll();
            Node b = trees.poll();
 
            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
      
        return trees.poll();
    }
  
    public static Map<Character,String> mapA = new HashMap<Character ,String>();
  
    public static void printCodes(Node tree, StringBuffer prefix) {
      
        assert tree != null;
      
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
 
            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data,prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
 
/**
     * https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
     * 
     * Algorithm: https://www.techiedelight.com/huffman-coding/
     * 
     * PREFIX RULE: no code is prefix of anothe code.
     * 
     * There are mainly two major parts in Huffman Coding:
     *  1) Build a Huffman Tree from input characters.
     *  2) Traverse the Huffman Tree and assign codes to characters.
     * 
     * @param s
     * @param root
     */
    private static void decode(String s, Node root) {
        
        // System.out.println("Input string: " + s);

        char[] endcodedString = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        Node wNode = root;

        for ( int index = 0; index < endcodedString.length; index++ ) {

            // System.out.println("S[" + index + "] = " + endcodedString[index]);

            if ( wNode.left != null || wNode.right != null ) {
                if ( endcodedString[index] == '0' ) {
                    // go left
                    wNode = wNode.left;
                } else {
                    // go right
                    wNode = wNode.right;
                }
            }
            if ( wNode.left == null && wNode.right == null ) {

                // System.out.println("Step: " + index + " adding to output " + wNode.data);
                sb.append(wNode.data);
                wNode = root;
                continue;
            }

        }

        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
    
        String test= input.next();
 
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];
      
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;
 
        // build tree
        Node tree = buildTree(charFreqs);
 
        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();
      
        for(int i = 0; i < test.length(); i++) {
          	char c = test.charAt(i);
            s.append(mapA.get(c));
        }
      
        // System.out.println(s);
        decode(s.toString(), tree);

    }

}
