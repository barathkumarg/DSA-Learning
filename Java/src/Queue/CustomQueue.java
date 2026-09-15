package Queue;

public class CustomQueue {
    //Data members
    int capacity;
    int rear;
    int front;
    int size;
    int []queue;

    //Constructor
    CustomQueue(int capacity){
        this.capacity = capacity;
        this.front = 0;
        this.rear = capacity - 1;
        this.queue = new int[capacity];
        this.size =  0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.capacity -1;
    }

    //insertion operation
    public void enqueue(int element){
        if (isFull()){
            System.out.println("Queue is full");
        } else {
            this.rear = (this.rear + 1) % this.capacity;
            this.queue[this.rear] = element;
            this.size++;
            System.out.println("Element inserted");
        }
    }

    //deletion operation
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        } else {
            int element = this.queue[front];
            this.front = (this.front + 1) % this.capacity;
            this.size --;
            System.out.println("Element got removed " + element);
        }
    }

    //Display operation
    public void display(){
        System.out.println("Direction of the queue '<--- ' ");
        for(int index = this.front;index<=this.rear;index++){
            System.out.print(this.queue[index] + " ");
        }
    }

}
