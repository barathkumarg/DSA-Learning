package BinaryTree;

/**

 Problem
 A binary search tree (BST) is a node based binary tree data structure which has the following properties.

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 **/

public class Problem_3_verify_balaned_tree {

    static int MIN_VALUE = Integer.MIN_VALUE;

    // Inorder traversal implementation to check it was BST
    public static void VerifyBSTTree(Node node){
        if(node == null) return;

        VerifyBSTTree(node.left);
        if (MIN_VALUE > node.value){
            System.out.println("Not a BST tree ");
            return;
        }

        // Updating the visited value as MIN value
        MIN_VALUE = node.value;

        VerifyBSTTree(node.right);
    }

    public static void main(String[] args) {
        Node root = BinaryTree.insert(null, 10);
        BinaryTree.insert(root,5);
        BinaryTree.insert(root, 15);
        BinaryTree.insert(root, 12);
        BinaryTree.insert(root, 20);

        BinaryTree.printTree(root);

        //intentional change of value in root to verify the Verify BST
        root.value = -1;

        VerifyBSTTree(root);

    }
}
