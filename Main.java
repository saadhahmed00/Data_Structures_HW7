import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // parse the array representing the binary search tree
        int[] binaryTree;
        String input = sc.nextLine();
        if (input.equals("")) {
            binaryTree = new int[0];
        } else {    
            String[] binaryTreeStrings = input.split(" ");
            binaryTree = new int[binaryTreeStrings.length];
            for (int i = 0; i < binaryTreeStrings.length; i++) {
                binaryTree[i] = Integer.parseInt(binaryTreeStrings[i]);
            }
        }

        // check if this is a binary search tree; print the result
        System.out.println(isBinarySearchTree(binaryTree));
    }

    // This is a method for finding the index of the left child
    public static int leftChildIdx(int index){
        return (index * 2) + 1;
    }

    // This is a method for finding the index of the right child
    public static int rightChildIdx(int index){
        return (index * 2) + 2; 
    }

    // This method will return true if the current node is the last child of the tree
    public static boolean isLastChild(int idx, int length){
        return leftChildIdx(idx) >= length;
    }

    // This method does most of the computation
    // It takes in the min and max range of each node. If the node is within the range, it return true. If not, then false
    // This method divides the tree into the left and right nodes and recursively calls itself until it reaches the last node
    // If the value of the parent, left node, and right node are true, then the tree is a BinarySearchTree
    // Time complexity is O(n) since each node is visited only once.
    public static boolean trueChildren(int[] binaryTree, int idx, int minimum, int maximum){

        // This is the base case. 
        // If we reach the last node, then execute.
        if(isLastChild(idx, binaryTree.length) == true){
            
            // We check if the node is within the right bounds
            return (binaryTree[idx] < maximum ) && (binaryTree[idx] > minimum);
        }

        boolean right;

        // We recursively call the left nodes with a new restriction on max. Max is the node value at the current index (or parent value)
        boolean left = trueChildren(binaryTree, leftChildIdx(idx), minimum, binaryTree[idx]);
        
        // Since a BST is written from left to right, we need to check if a right child exists
        if(rightChildIdx(idx) < binaryTree.length){

            // If it exists, then we recursively call the right nodes with a new restriction on the min value. Min is the the node value at the current index (or parent value)
            right = trueChildren(binaryTree, rightChildIdx(idx), binaryTree[idx], maximum);
        }
        else{
            // If there is no right node, then right is just true
            right = true;
        }
        
        // We will check the root node to see if it is within the given bounds. Then we will compare it to the left and right values
        // If they all are true, the the tree is a BST. If even one is false, then the tree is NOT a BST
        return ((binaryTree[idx] < maximum ) && (binaryTree[idx] > minimum)) && left && right;
    }
    
    public static boolean isBinarySearchTree(int[] binaryTree) {
        
        // We call on trueChildren by starting with the first index. The first index can be any number so the bounds are -inf to +inf
        return trueChildren(binaryTree, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
    
}