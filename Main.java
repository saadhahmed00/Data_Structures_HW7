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

    public static int parentIndx(int index){
        return (index - 1)/2;
    }

    public static int leftParentIdx(int index){
        return (index * 2) + 1;
    }

    public static int rightParentIdx(int index){
        return (index * 2) + 2;
    }
    
    public static boolean isBinarySearchTree(int[] binaryTree) {


        // TODO fill this in, along with any needed helper functions
        throw new UnsupportedOperationException();
    }
    
}