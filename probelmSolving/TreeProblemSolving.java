package probelmSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
 * ProblemSolving: Trees section
 * 
 *  With the support of: The design and analysis of computer algorithms - Aho | Hopcroft | Ullman
 * 
 */
public class TreeProblemSolving {

    /**
     * 
     * @param root
     * @param data
     * @return
     */
    public static Node insert(Node root, int data) {
        
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    /**
     * Inorder traversal:
     *  - visit in inorder the left subtree of the root r (if it exists)
     *  - visit r
     *  - Visit in inotder the right subtree of r (if it exists)
     * 
     * @param root
     */
    public static void inOrder(Node root) {

        if ( root.left != null ) {            
            inOrder(root.left);
        } 

        System.out.print(root.data + " ");

        if ( root.right != null ) {
            inOrder(root.right);
        }

    }

    /**
     * https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
     * 
     * - Visit the root r
     * - Visit in preorder traversal the subtrees v1, v2, ..., vk
     * 
     * @param args
     */
    public static void preOrder(Node root) {

        System.out.print(root.data + " ");

        if ( root.left != null ) {            
            preOrder(root.left);
        } 

        if ( root.right != null ) {
            preOrder(root.right);
        }

    }

    /**
     * https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
     * 
     * - Visit in postorder traversal the subtrees v1, v2, ..., vk
     * - Visit the root r
     * 
     * @param root
     */
    public static void postOrder(Node root) {

        if ( root.left != null ) {            
            postOrder(root.left);
        } 

        if ( root.right != null ) {
            postOrder(root.right);
        }

        System.out.print(root.data + " ");

    }

    /**
     * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_r=next-challenge&h_v=zen
     * 
     * The height of a vertex is the lenght of the longest path from v to a leaf. The height of a tree is the height of the root
     * 
     * @param root
     * @return
     */
    public static int height(Node root) {
        
        if ( root == null ) {
            return 0;
        }

        int leftDepth = 0;
        int rightDepth = 0;

        if ( root.left != null ) {            
            leftDepth =  height(root.left) + 1;
        } 

        if ( root.right != null ) {
            rightDepth = height(root.right) + 1; 
        }

        if ( leftDepth > rightDepth ) {
            return leftDepth;
        } else {
            return rightDepth;
        }

    }

    /**
     * https://www.hackerrank.com/challenges/tree-top-view/problem?h_r=next-challenge&h_v=zen
     * Algorithm: https://www.techiedelight.com/print-top-view-binary-tree/
     * 
     * @param root
     */
    public static void topView(Node root) {
        
        int MAX = 500;    // Otherwise, MAX=getNodeCount(root);
        int[] top = new int[MAX*2];
        java.util.Queue<Object[]> queue = new java.util.ArrayDeque<>();
        
        queue.add(new Object[] { root, MAX}) ;
        
        while(!queue.isEmpty()) {
        
            Object[] array = queue.remove();
            Node node = (Node)array[0];
            Integer order = (Integer)array[1];
            
            if ( node == null) continue;
    
            if ( top[order] == 0 ) {
                top[order] = node.data;
            }

            queue.add(new Object[]{node.left, order-1});
            queue.add(new Object[]{node.right, order+1});

        }
    
        for ( int data: top ) {
            if ( data != 0 ) {
                System.out.print(data + " ");
            }
        }
    }

    /**
     * https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
     * 
     * @param args
     */
    private static Map<Integer, List<Integer>> levels = new LinkedHashMap<Integer, List<Integer>>();

    public static void levelOrder(Node root) {

        levelOrderTraversal(root, 0);

        for ( Map.Entry<Integer, List<Integer>> level : levels.entrySet() ) {
            level.getValue().stream().forEach(x -> System.out.print(x + " "));
        }

    }

    private static void levelOrderTraversal(Node node, int level) {

        if ( node == null ) return;

        // System.out.println("Node: " + node.data + " level: " + level);

        if ( levels.containsKey(level) ) {
            levels.get(level).add(node.data);
        } else {
            levels.put(level, new ArrayList<Integer>(Arrays.asList(new Integer[] {node.data})));
        }

        if ( node.left != null ) {            
            levelOrderTraversal(node.left, level + 1);
        } 

        if ( node.right != null ) {
            levelOrderTraversal(node.right, level + 1);
        }

    }

    /**
     * https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
     * 
     * @param root
     * @param data
     * @return
     */
    public static Node binarySearchTreeInsert(Node root,int data) {

        if ( root == null ) {
            Node node = new Node(data);
            root = node;
        } else if ( root.data > data ) {
            root.left = binarySearchTreeInsert(root.left, data);
        } else if ( root.data < data ) {
            root.right = binarySearchTreeInsert(root.right, data);
        }

        return root;

    }

    /**
     * Graphs G = (V,E) finite, nonempty set of vertices V and a set of edges E. 
     * Directed graph: if the edges are orderes pairs (v,w). v is tail w is head of the edge. 
     * Number of vertices adjacent to v is called degree of v 
     * A path is a sequence of edges of the form (v1,v2), (v2,v3),...
     *
     * Tree is a directed acyclic graph satisfying the following properties:
     *  - there is exactly one root which no edges enter
     *  - every vertex except the root has exactly one entering edge
     *  - there is a path from the root to each vertex 
     * 
     * @param args
     * 
     */
    public static void main(String[] args) {

        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.left = new Node(3);
        root.right.right.left.right = new Node(4);
        root.right.right.right = new Node(6);

    }

    
}
