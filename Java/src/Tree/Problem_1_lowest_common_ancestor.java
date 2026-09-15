package Tree;

public class Problem_1_lowest_common_ancestor {

    public static Node findLowestCommonAncestor(Node root, int n1, int n2){
        if (root == null) return null;

        //check the left or right value
        if(root.value == n1 || root.value == n2) return root;

        Node left = findLowestCommonAncestor(root.left,n1,n2);
        Node right = findLowestCommonAncestor(root.right,n1,n2);

        if(left != null && right != null) return root;

        return left !=null ? left : right;


    }

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
        Node node = findLowestCommonAncestor(root,4,5);
        System.out.println("Least Common Ancestor: "+ node.value);


    }
}
