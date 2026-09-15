package LinkedList;

//Node class
class Node{
    int data;
    Node next;

    //constructor
    public Node(int data){
        this.data = data;
        this.next = null;
    }

}

public class SLinkedList {
    Node head;

    //print the linked list elements
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");

            temp = temp.next;
        }
        System.out.println();
    }

    //*****************   Insertion operation  *************************************
    //insert at last
    public void insertLast(int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        //if no element found
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return;
    }

    //insert at first
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        //if no element found
        if (head == null) {
            head = newNode;
            return;
        }

        //replace the head
        newNode.next = head;
        head = newNode;
    }

    //insert at the position
    public void insertPosition(int position, int data) {
        Node temp = head;
        Node newNode = new Node(data);
        newNode.next = null;

        //if no element found
        if (head == null) {
            head = newNode;
            return;
        }

        //replace logic
        for (int i = 0; i < position; i++) {
            temp = temp.next;
            if (temp == null) {
                System.out.println("limit reached");
                return;
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }


}
