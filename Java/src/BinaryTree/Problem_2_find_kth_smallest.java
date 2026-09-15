package BinaryTree;
/**
 Given the root of a binary search tree and K as input, find Kth smallest element in BST.



 Time complexity = 0(n)
 Space Complexity = 0(h)

 **/



public class Problem_2_find_kth_smallest {

    // static variable to keep track on the node count
    // best use in case of recursion
    static int count = 0;

    public static void findKthSmallest(Node node, int k) {
        if (node == null || count > k) return;

        // implementation of inorder traversal
        findKthSmallest(node.left, k);

        // if node count matches print the value
        count++;
        if (count == k) System.out.println("Value found:" + node.value);

        findKthSmallest(node.right, k);
    }

    public static void main(String[] args) {
        Node root = BinaryTree.insert(null, 10);
        BinaryTree.insert(root,5);
        BinaryTree.insert(root, 15);
        BinaryTree.insert(root, 12);
        BinaryTree.insert(root, 20);

        // Display the tree
        BinaryTree.printTree(root);

        findKthSmallest(root, 5);
    }


}
