package LinkedListL1;

public class GetValueinLinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size(){
            return size;
        }

        public void display(){
            for(Node temp = head; temp != null; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
            } else if(size == 1){
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            } else if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node t = head;
                for(int i = 0; i < idx; i++){
                    t = t.next;
                }
                return t.data;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Hardcoded sequence of operations
        list.addLast(10);
        System.out.println(list.getFirst()); // Expected Output: 10

        list.addLast(20);
        list.addLast(30);
        System.out.println(list.getFirst()); // Expected Output: 10
        System.out.println(list.getLast());  // Expected Output: 30

        System.out.println(list.getAt(1));   // Expected Output: 20

        list.addLast(40);
        System.out.println(list.getLast());  // Expected Output: 40

        list.addLast(50);
        list.removeFirst();
        System.out.println(list.getFirst()); // Expected Output: 20

        list.removeFirst();
        list.removeFirst();
        System.out.println(list.getAt(3));   // Expected Output: Invalid arguments

        list.removeFirst();
        list.removeFirst();
        System.out.println(list.getFirst()); // Expected Output: List is empty

        list.display(); // Expected Output: List is empty
    }
}
