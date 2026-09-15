package Tree;

public class Problem_Tree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        Tree.printTree(root);

        //Inorder Traversal
        System.out.println("Inorder Traversal:");
        Tree.inorderTraversal(root);
        System.out.println();

        //Preorder Traversal
        System.out.println("Preorder Traversal:");
        Tree.preorderTraversal(root);
        System.out.println();

        //Postorder Traversal
        System.out.println("Postorder Traversal:");
        Tree.postorderTraversal(root);
        System.out.println();

        //level order Traversal
        System.out.println("LevelOrder Traversal:");
        Tree.levelOrdertraversal(root);
        System.out.println();

        //get the height of the tree
        System.out.println("\nThe height of the tree "+ Tree.getheight(root));

        //print the elements in K distance
        int height = 2;
        System.out.println("\nElements with height '"+ height +"' are: ");
        Tree.getElementsAtKdistance(root,height);

        //print the size of the tree
        System.out.println("\nThe size of the tree is: "+ Tree.getSizeOfTree(root));

        //print the maximum element in the tree
        System.out.println("\nMaximum element in the tree is: "+ Tree.getMaximumElement(root));

        //find the tree is balanced or not
        System.out.println("\nBalanced tree check:");
        if(Tree.findBalancedtree(root) > 0){
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }

        //find the width at n level
        int level = 3;
        System.out.println("\nThe width of the tree at level "+level+" is: "+Tree.getWidthOfLevel(root,level));






    }
}
