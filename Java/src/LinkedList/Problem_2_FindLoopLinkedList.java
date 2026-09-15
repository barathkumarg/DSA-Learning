package LinkedList;

/**
 Problem #2 : Detect Loop in a Linked List

 Description :Given a linked list, check if the the linked list has loop or not. Below diagram shows a linked list with a loop.

 Implementation: Slow and fast pointer method

 **/
public class Problem_2_FindLoopLinkedList {

    //Slow and fast pointer approach
    public static void findLoop(Node tempNode){
        Node slowNode = tempNode;
        Node fastNode = tempNode;

        while(slowNode!=null && fastNode!=null && fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if(slowNode == fastNode){
                System.out.println("loop found");
                return;

            }
        }
        System.out.println("No loop found");

    }

    public static void main(String[] args) {

        //loop creation
        SLinkedList linkedlist = new SLinkedList();

        linkedlist.insertFirst(1);
        linkedlist.insertLast(2);
        linkedlist.insertLast(3);
        linkedlist.insertLast(4);
        linkedlist.insertLast(5);

        //looping logic
        Node temp = (Node) linkedlist.head;
        while(temp.next!=null){
            temp = temp.next;
        }
        //move to the second element
        Node secondary_temp = linkedlist.head.next;
        temp.next = secondary_temp;

        /**
         1 -> 2 -> 3 -> 4 -> 5
              ^              v
               <- <- <- <- <-
         **/

        findLoop(linkedlist.head);




    }
}
