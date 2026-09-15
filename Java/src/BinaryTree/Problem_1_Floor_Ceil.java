package BinaryTree;

/**
 ------------  Floor Problem  ----------------
 Given a Binary Search Tree and a number x, find floor of x in the given BST.

 Input : x = 14 and root of below tree
 10
 /  \
 5    15
 /  \
 12    30
 Output : 12

 Input : x = 15 and root of below tree
 10
 /  \
 5    15
 /  \
 12    30
 Output : 15

 ---------------  Ceil Problem  ------------------

 For example, Let's consider the Binary Tree below -

      8
    /   \
   4      12
 /  \    /  \
 2    6  10   14

 Key: 11   Ceil: 12
 Key: 1    Ceil: 2
 Key: 6    Ceil: 6
 Key: 15   Ceil: -1

 Time complexity : 0(log n)

 Auxiliary Space: O(logn)

 **/


public class Problem_1_Floor_Ceil {

    public static int findFloor(Node node, int value){

        // return the MAX value if 'null' found, for comparison
        if(node == null) return Integer.MAX_VALUE;

        // return actual value if found
        if(node.value == value) return value;

        // move LEFT if encountered lower value
        // In case of floor it may either be the root value hence storing value, help of tail recursion
        // return the least value near to the actual value
        if(node.value > value) return findFloor(node.left, value);
        else {
            int floorvalue = findFloor(node.right, value);
            return (floorvalue <= value) ? floorvalue : node.value;
        }

    }

    public static int findCeil(Node node, int value) {

        // return the MAX value if 'null' found, for comparison
        if (node == null) return Integer.MIN_VALUE;

        // return actual value if found
        if (node.value == value) return value;

        // move LEFT if encountered lower value
        // In case of floor it may either be the root value hence storing value, help of tail recursion
        // return the least value near to the actual value
        if (node.value < value) return findCeil(node.right, value);
        else {
            int floorvalue = findCeil(node.left, value);
            return (floorvalue >= value) ? floorvalue : node.value;
        }
    }

    public static void main(String[] args) {
        Node root = BinaryTree.insert(null, 10);
        BinaryTree.insert(root,5);
        BinaryTree.insert(root, 15);
        BinaryTree.insert(root, 12);
        BinaryTree.insert(root, 20);

        // Display the tree
        BinaryTree.printTree(root);
        System.out.println(Problem_1_Floor_Ceil.findFloor(root, 14));
        System.out.println(Problem_1_Floor_Ceil.findCeil(root,14));
    }
}
