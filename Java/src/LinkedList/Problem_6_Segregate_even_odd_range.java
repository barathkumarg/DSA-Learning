package LinkedList;

/**
 Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear
 before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers the same.

 Examples:
 Input: 17->15->8->12->10->5->4->1->7->6->NULL
 Output: 8->12->10->4->6->17->15->5->1->7->NULL

 ========= Idea ============
 To create the 2 linked list containing the seperate odd and even linked list and aggregate them

 **/


public class Problem_6_Segregate_even_odd_range {

    public static void segrearet(Node head){
        Node oddStart = null;
        Node oddEnd = null;
        Node evenStart = null;
        Node evenEnd = null;
        Node currentNode = head;

        while(currentNode!=null){
            int data = currentNode.data;
            if(data % 2 == 0){
               if(evenStart == null){
                   evenStart = currentNode;
                   evenEnd = currentNode;
               } else {

                   evenEnd.next = currentNode;
                   evenEnd = evenEnd.next;

               }

            }else{
                if(oddStart == null){
                    oddStart = currentNode;
                    oddEnd = currentNode;
                } else {

                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;

                }
            }
            currentNode = currentNode.next;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;

        //Display the full linked list
        while(evenStart!=null){
            System.out.print(evenStart.data + " ->");
            evenStart = evenStart.next;
        }
        System.out.print(" null");

    }

    public static void main(String[] args) {
        SLinkedList linkedlist = new SLinkedList();

        linkedlist.insertFirst(3);
        linkedlist.insertLast(2);
        linkedlist.insertLast(5);
        linkedlist.insertLast(4);
        linkedlist.insertLast(7);
        linkedlist.insertLast(10);


        segrearet(linkedlist.head);
    }
}
