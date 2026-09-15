package Tree;


import java.util.LinkedList;
import java.util.Queue;

public class Problem_2_tree_operations {

    public static void main(String[] args) {
        createBinaryTree binaryTree = new createBinaryTree();
        binaryTree.insertElement(1);
        binaryTree.insertElement(2);
        binaryTree.insertElement(3);
        binaryTree.insertElement(4);
        binaryTree.insertElement(5);
        Tree.printTree(binaryTree.root);
        binaryTree.deleteNode(binaryTree.root,2);
        Tree.printTree(binaryTree.root);

    }
}
