package LinkedListL1;

public class RemoveDuplicates {
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

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public void removeDuplicates(){
            LinkedList res = new LinkedList();

            while(this.size() > 0){
                int val = this.getFirst();
                this.removeFirst();

                if(res.size() == 0 || res.tail.data != val){
                    res.addLast(val);
                }
            }

            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }
    }

    public static void main(String[] args) {
        // Hardcoded input
        int[] elements = {2, 2, 2, 3, 3, 5, 5, 5, 5, 5};

        LinkedList l1 = new LinkedList();
        for (int element : elements) {
            l1.addLast(element);
        }

        System.out.println("Original List:");
        l1.display();

        l1.removeDuplicates();

        System.out.println("List after removing duplicates:");
        l1.display();
    }
}
