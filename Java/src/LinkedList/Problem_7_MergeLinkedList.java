package LinkedList;

import java.util.LinkedList;

public class Problem_7_MergeLinkedList {

  public static void merge(Node node1, Node node2) {
    Node result = null;
    Node resulthead = null;

    //traverse and merge the resultant 2 linked list
    while (node1 != null && node2 != null) {
      if (node1.data < node2.data) {
        if (resulthead == null) {result = node1; resulthead = node1;}
        else {
          result.next = node1;
          result = result.next;

        }
        node1 = node1.next;
      } else {
        if (resulthead == null) {result = node2; resulthead = node2;}
        else {result.next = node2; result=result.next;}
        node2 = node2.next;
      }
    }

    //finally merge the singly pointed linked list
    //node 1 case
    while (node1!=null){
      if (result == null) result = node1;
      else result.next = node1;
      node1 = node1.next;
    }

    //node 2 case
    while (node2!=null){
      if (result == null) result = node2;
      else result.next = node1;
      node2 = node2.next;
    }

    //printing the result
    while (resulthead!=null){
      System.out.print(resulthead.data + " ");
      resulthead = resulthead.next;
    }


  }

  public static void main(String[] args) {
    SLinkedList linkedList1 = new SLinkedList();

    linkedList1.insertFirst(1);
    linkedList1.insertLast(3);
    linkedList1.insertLast(5);
    linkedList1.insertLast(7);
    linkedList1.insertLast(9);
    linkedList1.insertLast(11);

    SLinkedList linkedList2 = new SLinkedList();
    linkedList2.insertFirst(2);
    linkedList2.insertLast(4);
    linkedList2.insertLast(6);
    linkedList2.insertLast(8);
    linkedList2.insertLast(10);

    merge(linkedList1.head, linkedList2.head);
  }
}
