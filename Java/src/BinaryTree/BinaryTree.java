package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


public class BinaryTree {

    //------------------------------- Printing the tree ------------------------------------------

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



    public static Node insert(Node node, int value){
    /**
     Insert function to insert the Node in Binary Order
     **/
        if(node == null) return new Node(value);
        else if(value > node.value) node.right = insert(node.right, value);
        else node.left = insert(node.left,value);
        return node;
    }

    public static boolean search(Node node, int value){
    /**
     Search the respective Node and return the value in boolean
     **/
    if (node.value == value) return true;
    else if(node!=null && node.value > value) return search(node.left, value);
    else if(node!=null && node.value < value) return search(node.right, value);
    else return false;
    }

    public static Node deleteNode(Node node, int value){
    /**
      Delete the node, replace the rightmost element method
     **/
        if(node == null) return node;
        else if(node.value > value) node.left = deleteNode(node.left,value);
        else if(node.value < value) node.right = deleteNode(node.right,value);
        else {
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            node.value = minValue(node.right);

            //Delete the replaced node
            node.right = deleteNode(node.right, node.value);
        }
        return node;
    }

    //helper for the deleteNode method
    public static int minValue(Node node){
        int minvalue = node.value;
        while(node.left!=null){
            minvalue = node.value;
            node = node.left;
        }
        return minvalue;
    }

    public static void main(String[] args) {
        Node root = BinaryTree.insert(null,10);
        BinaryTree.insert(root,5);
        BinaryTree.insert(root,15);
        BinaryTree.insert(root,20);

        BinaryTree.printTree(root);
        int value = 20;
        System.out.println("The element "+ value + "found "+ BinaryTree.search(root,value));

        //delete the node
        BinaryTree.deleteNode(root,10);
        BinaryTree.printTree(root);
    }
}
