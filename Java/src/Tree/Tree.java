package Tree;

import java.util.*;

class Node {
    Node left;
    Node right;
    int value;

    Node(int value){
        this.left = null;
        this.right = null;
        this.value = value;
    }
}


public class Tree {

    public static void printTree(Node root) {
        if (root == null) return;

        // Get the maximum level (height) of the tree
        int maxLevel = getMaxLevel(root);

        // Queue to handle printing each level
        List<Node> nodes = Collections.singletonList(root);
        for (int level = 1; level <= maxLevel; level++) {
            if (nodes.isEmpty() || isAllElementsNull(nodes)) break;

            int floor = maxLevel - level;
            int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
            int firstSpaces = (int) Math.pow(2, floor) - 1;
            int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

            // Print leading whitespaces
            printWhitespaces(firstSpaces);

            List<Node> newNodes = new ArrayList<>();
            for (Node node : nodes) {
                if (node != null) {
                    System.out.print(node.value);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    System.out.print(" ");
                    newNodes.add(null);
                    newNodes.add(null);
                }
                printWhitespaces(betweenSpaces);
            }
            System.out.println();

            // Printing the connecting lines (edges)
            for (int i = 1; i <= edgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        printWhitespaces(edgeLines + edgeLines + i + 1);
                        continue;
                    }
                    if (nodes.get(j).left != null) System.out.print("/");
                    else printWhitespaces(1);

                    printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null) System.out.print("\\");
                    else printWhitespaces(1);

                    printWhitespaces(edgeLines + edgeLines - i);
                }
                System.out.println();
            }
            nodes = newNodes;
        }
    }

    // Helper to print whitespaces
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    // Helper to check if all elements in the list are null
    private static boolean isAllElementsNull(List<Node> list) {
        for (Node node : list) {
            if (node != null) return false;
        }
        return true;
    }

    // Helper to calculate the max level (height) of the tree
    private static int getMaxLevel(Node node) {
        if (node == null) return 0;
        return Math.max(getMaxLevel(node.left), getMaxLevel(node.right)) + 1;
    }


    // --------------------------------------------------------------------------------- //

    // Inorder Traversal
    public static void inorderTraversal(Node root){
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }

    // Preorder Traversal
    public static void preorderTraversal(Node root){
        if (root == null) return;
        System.out.print(root.value + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    //Postorder Traversal
    public static void postorderTraversal(Node root){
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    //level order traversal using the (queue implementation)
    public static void levelOrdertraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        //iterate till queue gets empty
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value + " ");

            //add the left and right elements in the queue
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }

    // Get the height of the tree
    public static int getheight(Node root){
        if (root == null) return -1;
        int leftHeight = getheight(root.left);
        int rightHeight = getheight(root.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    //get the elements in K distance
    public static void getElementsAtKdistance(Node root, int k){
        if (k<0 || root ==null) return;
        if(k==0 && root!=null) { System.out.print(root.value +" "); return; }
        getElementsAtKdistance(root.right,k-1);
        getElementsAtKdistance(root.left,k-1);

    }

    //get the size of the tree (use: recursive approach)
    public static int getSizeOfTree(Node root){
        if (root == null) return 0;
        int left = getSizeOfTree(root.left);
        int right = getSizeOfTree(root.right);
        return left + right + 1;
    }

    //get the Maximum element in the tree
    public static int getMaximumElement(Node root){
        if(root==null) return Integer.MIN_VALUE;

        int result = root.value;
        int left = getMaximumElement(root.left);
        int right = getMaximumElement(root.right);

        if (left > result) result = left;
        if(right > result) result = right;

        return result;
    }

    //find the given was the balanced tree
    public static int findBalancedtree(Node root){
        if (root == null) return 0;
        int leftheight = findBalancedtree(root.left);
        if (leftheight == -1) return -1;  //fail case check

        int rightheight = findBalancedtree(root.right);
        if(rightheight == -1) return -1;  //fail case check

        if(Math.abs(leftheight - rightheight) >1) return -1;  //fail case check

        return Math.max(leftheight,rightheight) + 1;
    }

    //Find width of the tree for the given level
    public static int getWidthOfLevel(Node root, int level){
        if (root == null) return 0;

        if(level==1) return 1;

        else if(level > 1) {
            return getWidthOfLevel(root.left, level -1) + getWidthOfLevel(root.right, level -1);
        }
        return 0;
    }


}
