package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class createBinaryTree{
    public Node root;
    Queue<Node> queue;

    public createBinaryTree(){
        queue = new LinkedList<>();
    }

    //method to insert the elements using the level order approach
    public void insertElement(int element){

        //if the queue is empty
        if (queue.isEmpty()){
            root = new Node(element);
            queue.add(root);
        }

        //if not empty
        else if(!queue.isEmpty()){
            Node node = queue.peek();
            if (node.left==null){
                Node lnode = new Node(element);
                node.left = lnode;
                queue.add(lnode);
                System.out.println(element);
            }
            else {
                Node rnode = new Node(element);
                node.right= rnode;
                queue.poll(); //delete the element
                queue.add(rnode);
            }
        }
    }


    //************************************************  Node delete operation ******************************************

    //deletion in binary tree, deleting the rigth-most node in a tree appraoch
    public void deleteNode(Node root, int key){
        Node d_node = null;
        Node temp = null;
        Queue<Node> queue = new LinkedList<>(); //queue creation
        queue.add(root);

        //level order traversal implementation
        while(!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();

            if(temp.value == key){
                d_node = temp;
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        //logic to delete the temporary leaf node and replace the actual leaf value with the node to be deleted
        int value = temp.value;
        helperDelete(root, temp);
        d_node.value = value;
    }

    //Helper function for the delete node, which deletes the given node
    public void helperDelete(Node root, Node d_node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();
            if (temp.right != null) {
                if (temp.right == d_node) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }
            if (temp.left != null){
                if (temp.left == d_node) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }



}
