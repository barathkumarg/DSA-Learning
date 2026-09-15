package LinkedList;

public class SinglyLinkedListOperation {
    //Head node pointer
    static Node head;

    //Node class
    static class Node{
        int data;
        Node next;

        //constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    //Node operation class
    static class NodeOperation {

        //print the linked list elements
        public static void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");

                temp = temp.next;
            }
            System.out.println();
        }

        //*****************   Insertion operation  *************************************
        //insert at last
        public static void insertLast(int data) {
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
        public static void insertFirst(int data) {
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
        public static void insertPosition(int position, int data) {
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

        //*************************  Deletion operation  ********************************

        //delete first
        public static void deleteFirst() {
            if (head == null) {
                System.out.println("Nothing to delete");
            } else {
                head = head.next;
            }
        }

        //delete last
        public static void deleteLast() {
            if (head == null) {
                System.out.println("Nothing to delete");
            } else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }

        //delete by position
        public static void deletePosition(int position) {
            if (head == null) {
                System.out.println("Nothing to delete");
            } else {
                Node temp = head;
                for (int i = 1; i < position; i++) {
                    temp = temp.next;
                    if (temp == null || temp.next == null) {
                        System.out.println("limit reached");
                        return;
                    }
                }
                temp.next = temp.next.next;
            }

        }


        //execution
        public static void main(String[] args) {
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);

            node1.next = node2;
            node2.next = node3;
            head = node1;

            NodeOperation.insertLast(4);
            NodeOperation.insertFirst(-1);
            NodeOperation.insertPosition(0, 0);

            NodeOperation.display();

            NodeOperation.deleteFirst();
            NodeOperation.deleteLast();
            NodeOperation.deletePosition(2);

            NodeOperation.display();

        }
    }
}
