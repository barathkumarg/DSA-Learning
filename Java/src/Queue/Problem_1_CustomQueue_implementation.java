package Queue;

/**

 Time Complexity:

 Time complexity of all operations such as enqueue(), dequeue(), isFull(), isEmpty(), front(), and rear() is O(1).
 There is no loop in any of the operations.

 Applications of Queue:

 Queue is used when things don’t have to be processed immediatly, but have to be processed in First In First Out order like

 Breadth First Search
 . This property of Queue makes it also useful in following kind of scenarios:

 When a resource is shared among multiple consumers. Examples include CPU scheduling, Disk Scheduling.
 When data is transferred asynchronously (data not necessarily received at same rate as sent) between
 two processes. Examples include IO Buffers, pipes, file IO, etc.

 **/


public class Problem_1_CustomQueue_implementation {
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(20);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.dequeue();
        queue.display();
    }
}
