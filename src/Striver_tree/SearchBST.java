package Striver_tree;

public class SearchBST {
    public static Node searchBST(Node root, int val) {
        while(root != null && root.key != val){
            root = val<root.key? root.left:root.right;
        }
        return root;
    }

    static Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
            //root.lcount++;
        }
        if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public  static int findCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.key == key) {
                ceil = root.key;
                return ceil;
            }

            if (key > root.key) {
                root = root.right;
            }
            else {
                ceil = root.key;
                root = root.left;
            }
        }
        return ceil;
    }

    public static int floorInBST(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.key == key) {
                floor = root.key;
                return floor;
            }

            if (key > root.key) {
                floor = root.key;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Node root = null;
        SearchBST tree = new SearchBST();

        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = tree.insertRec(root, data[i]);
        }

        Node p=searchBST(root,80);
        System.out.println(p.key);
        int ceil=findCeil(root,80);
        System.out.println(ceil);
        int floor=findCeil(root,20);
        System.out.println(floor);
    }
}
