/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTL1;

public class BasicBST {

    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        }
        if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    Node insert(Node root, int x) {
        Node temp = new Node(x);
        Node parent = null, curr = root;

        while (curr != null) {
            parent = curr;
            if (curr.key > x) {
                curr = curr.left;
            } else if (curr.key < x) {
                curr = curr.right;
            } else {
                return root;
            }
        }

        if (parent == null) {
            return temp;
        }
        if (parent.key > x) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }
        return root;
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    boolean searchRec(Node root, int x) {
        if (root == null) {
            return false;
        } else if (root.key == x) {
            return true;
        } else if (x < root.key) {
            return searchRec(root.left, x);
        } else {
            return searchRec(root.right, x);
        }
    }

    boolean search(Node root, int x) {
        while (root != null) {
            if (root.key == x) {
                return true;
            } else if (x < root.key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }

    Node getSuccessor(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    Node delete(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.key > x) {
            root.left = delete(root.left, x);
        } else if (root.key < x) {
            root.right = delete(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node succ = getSuccessor(root);
                root.key = succ.key;
                root.right = delete(root.right, succ.key);
            }
        }
        return root;
    }

    Node floor(Node root, int x) {
        Node res = null;
        while (root != null) {
            if (root.key == x) {
                return root;
            } else if (root.key > x) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }

    boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        return (root.key > Integer.MIN_VALUE && root.key < Integer.MAX_VALUE
                && isBST(root.left, Integer.MIN_VALUE, root.key)
                && isBST(root.right, root.key, Integer.MAX_VALUE)
    );
    }

    public static void main(String[] args) {
        Node root = null;
        BasicBST tree = new BasicBST();
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = tree.insertRec(root, data[i]);
        }

        tree.insert(root, 90);
        tree.inorderRec(root);

        System.out.println("The element 20 is found " + tree.searchRec(root, 20));
        System.out.println("The element 90 is found " + tree.search(root, 90));

        tree.delete(root, 90);
        tree.inorderRec(root);

        System.out.println("The floor of the element 57 is  " + tree.floor(root, 57).key);
        
        System.out.println("Is BST? "+tree.isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

}
