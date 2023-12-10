package LinkedList2;

public class RemoveDuplicateFromSortedLinkedList {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode th = null, tt = null;

    private static void addLast(ListNode node) {
        if (tt == null) {
            th = tt = node;
        } else {
            tt.next = node;
            tt = node;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = null;
            if (tt == null || tt.val != curr.val) addLast(curr);

            curr = forw;
        }

        return th;
    }



    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }



    static ListNode head;

    void push(int new_data) {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedLinkedList llist=new RemoveDuplicateFromSortedLinkedList();
        llist.push(11);
        llist.push(10);
        llist.push(11);
        llist.push(6);


        ListNode ans = removeDuplicates(head);
        printList(ans);
    }
}
