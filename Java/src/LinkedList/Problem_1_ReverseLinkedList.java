package LinkedList;
/**
 * Reverse a Linked List
 Description - Given a pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing links between nodes.


 Input: Head of following linked list
 1->2->3->4->NULL
 Output: Linked list should be changed to,
 4->3->2->1->NUL
 **/


public class Problem_1_ReverseLinkedList {
    public static void main(String[] args) {
        SLinkedList linkedlist = new SLinkedList();

        linkedlist.insertFirst(1);
        linkedlist.insertLast(2);
        linkedlist.insertLast(3);
        linkedlist.insertLast(4);
        linkedlist.insertLast(5);

        linkedlist.display();

        //Reversing the linked list
        Node prev = null;
       Node current = linkedlist.head;
        Node next;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        linkedlist.head = current;
        linkedlist.display();
    }
}
