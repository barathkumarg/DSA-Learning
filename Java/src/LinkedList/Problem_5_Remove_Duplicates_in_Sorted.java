package LinkedList;

public class Problem_5_Remove_Duplicates_in_Sorted {

    //intialize the linked list node
    static Node head = null;

    public static void insertSort(int data){

        //create a Node
        Node newnode = new Node(data);
        newnode.next = null;

        //Put the first element if the head points null
        if(head == null || head.data > data){
            newnode.next = head;
            head = newnode;
        } else {
            Node temp = head;
            while(temp.next!=null && temp.next.data < newnode.data){
                temp = temp.next;
            }
            //replace the newnode in its original position
            newnode.next = temp.next;
            temp.next = newnode;
        }
    }

    //Function to remove duplicates
    public static void removeDuplicates() {
        Node current = head;

        while (current != null) {
            Node temp = current;
            while (temp!= null && current.data == temp.data){
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;

        }
    }



    //function to display the linkedlist
    public static void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        insertSort(2);
        insertSort(1);
        insertSort(10);
        insertSort(6);
        insertSort(6);
        insertSort(4);
        insertSort(4);

        removeDuplicates();

        display();

    }
}
