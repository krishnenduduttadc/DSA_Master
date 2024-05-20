package LinkedList2;

public class MergeTwoSortedLinkedList {
    //public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1:l2;

        Node dummy = new Node(-1);
        Node prev =dummy;

        Node c1 = l1;
        Node c2 = l2;

        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;

        return dummy.next;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }



     static Node head1,head2;

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head1;
        head1 = new_node;
    }
    void push2(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head2;
        head2 = new_node;
    }
    public static void main(String[] args) {
        MergeTwoSortedLinkedList llist1=new MergeTwoSortedLinkedList();
        llist1.push(1);
        llist1.push(2);
        llist1.push(3);

//        Node h1 = createList(n);
//        int m = scn.nextInt();

        MergeTwoSortedLinkedList llist2=new MergeTwoSortedLinkedList();
        llist2.push(1);
        llist2.push(2);
        llist2.push(3);
        //Node h2 = createList(m);


        Node head3 = mergeTwoLists(head1, head2);
        printList(head3);
    }
}
