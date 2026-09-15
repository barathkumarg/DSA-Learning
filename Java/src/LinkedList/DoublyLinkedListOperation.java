package LinkedList;

public class DoublyLinkedListOperation {

    static Node head;

    //Node class
    static class Node{
        int data;
        Node next;
        Node prev;

        //constructor
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    //Node operation class
    static class NodeOperation {

        //print the linked list elements
        public static void display() {
            Node temp = head;
            Node lastNode = null;

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                if (temp.next == null){
                    lastNode = temp;
                }

                temp = temp.next;
            }
            System.out.println();
            System.out.println("Printing in reverse order");

            //reverse order printing
            while(lastNode!= null){
                System.out.print(lastNode.data + " -> ");
                lastNode = lastNode.prev;
            }

        }

        //*****************   Insertion operation  *************************************
        //insert at last
        public static void insertLast(int data) {
            Node newNode = new Node(data);
            newNode.next = null;
            newNode.prev = null;

            //if no element found
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            return;
        }

        //insert at first
        public static void insertFirst(int data) {
            Node newNode = new Node(data);
            newNode.prev = null;
            newNode.next = null;

            //if no element found
            if (head == null) {
                head = newNode;
                return;
            }

            //replace the head
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }

        //insert at the position
        public static void insertPosition(int position, int data) {
            Node temp = head;
            Node newNode = new Node(data);
            newNode.next = null;
            newNode.prev = null;

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
            newNode.prev = temp;

            //handling the previous case
            if(newNode.next!=null){
                newNode.next.prev = newNode;
            }
        }

        }


        //execution
        public static void main(String[] args) {
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);

            node1.next = node2;
            node1.prev = null;

            node2.next = node3;
            node2.prev = node1;

            node3.prev = node2;
            node3.next = null;

            head = node1;

            NodeOperation.insertFirst(0);
            NodeOperation.insertLast(4);
            NodeOperation.insertPosition(2,8);
            NodeOperation.display();


        }

}
