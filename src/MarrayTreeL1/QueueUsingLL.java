package MarrayTreeL1;

public class QueueUsingLL<T> {

    private Node2<T> front;
    private Node2<T> rear;
    private int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T front() {


        return front.data;
    }

    public void enqueue(T element) {

        Node2<T> newNode = new Node2<>(element);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public T dequeue() {


        T temp = front.data;

        front = front.next;

        size--;

        if (front == null) {
            rear = null;
        }

        return temp;
    }

    // Static Node class
    static class Node2<T> {

        T data;
        Node2<T> next;

        Node2(T data) {
            this.data = data;
            this.next = null;
        }
    }
}