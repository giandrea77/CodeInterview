package probelmSolving;

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

        System.out.println(root.data);

        if ( root.right != null ) {
            inOrder(root.right);
        }

    }

    /**
     * https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
     * @param args
     */
    public static void preOrder(Node root) {

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
     * 
     */
    public static void main(String[] args) {

        // Generate tree: 1 14 3 7 4 5 15 6 13 10 11 2 12 8 9
        Node root = new Node(1);
        root.right = new Node(2);
        
        Node working = root.right;
        working.right = new Node(5);

        working = working.right;
        working.left = new Node(3);
        working.right = new Node(6);

        working = working.left;
        working.right = new Node(4);

        // System.out.println("root: " + root.data);
        inOrder(root);

    }

    
}
