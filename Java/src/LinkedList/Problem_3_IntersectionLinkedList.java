package LinkedList;
/**
 Intersection of Two Linked Lists

 While we have already achieved the best time complexity possible, but is it possible to reduce the space complexity?

Algorithm (Loop algorithm used for the finding loop in linked list)
 Set a pointer p1 to list A.
 Set a pointer p2 to list B.
 Run a while loop and while the nodes pointed by p1 and p2 are not same:
 If p1 is pointing to NULL, set p1 to head of B.
 Else, move to the next node of A.
 If p2 is pointing to NULL, set p2 to head of A.
 Else, move to the next node of B.
 Return the node pointed by p1.


 ============================  Results  =================================
 Time complexity = O(m + n)
 Space complexity = O(1)
 **/

public class Problem_3_IntersectionLinkedList {

    public static void findIntersection(Node head1, Node head2){

        Node node1 = head1;
        Node node2 = head2;

        while(node1!=node2){
            node1 = node1 ==null ? head2:node1.next;
            node2 = node2 ==null ? head1:node2.next;
        }
        System.out.println(" Intersection found at value: "+node1.data);
    }

    public static void main(String[] args) {

        //intersection creation
        SLinkedList linkedlist = new SLinkedList();

        linkedlist.insertFirst(1);
        linkedlist.insertLast(2);
        linkedlist.insertLast(3);
        linkedlist.insertLast(4);
        linkedlist.insertLast(5);

        SLinkedList linkedlist_2 = new SLinkedList();
        linkedlist_2.insertFirst(6);
        linkedlist_2.insertLast(7);

        //get the last node in linked list_2
        Node temp = linkedlist_2.head;
        while(temp.next!= null){
            temp = temp.next;
        }

        //get the middle node in linked_list
        Node second_temp = linkedlist.head.next.next;

        temp.next = second_temp;

        /**
         1 -> 2 -> 3 -> 4 -> 5 ->
                   ^
         6 -> 7 -> ^
         **/
        findIntersection(linkedlist.head, linkedlist_2.head);
    }
}
