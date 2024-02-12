/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTL1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author krish
 */
public class BSTInsert {

    static Node root;

    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static void Inorder(Node root) {
        if (root == null) {
            return;
        } else {
            Inorder(root.left);
            System.out.print(root.key + " ");
            Inorder(root.right);
        }
    }

    static Node insert(Node root, int x) {
        Node temp = new Node(x);
        Node curr = root, parent = null;
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

    static Node insertR(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }
        if (root.key < x) {
            root.right = insertR(root.right, x);
        }
        if (root.key > x) {
            root.left = insertR(root.left, x);
        }
        return root;
    }

    static boolean searchR(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.key == x) {
            return true;
        } else {
            if (root.key < x) {
                return searchR(root.right, x);
            } else {
                return searchR(root.left, x);
            }
        }
    }

    static boolean searchI(Node root, int x) {
        while (root != null) {
            if (root.key == x) {
                return true;
            } else {
                if (root.key < x) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return false;
    }

    static boolean isPairSum(Node root, int sum, HashSet<Integer> h) {
        if (root == null) {
            return false;
        }
        if (isPairSum(root.left, sum, h) == true) {
            return true;
        }
        if (h.contains(sum - root.key)) {
            return true;
        } else {
            h.add(root.key);
        }
        return isPairSum(root.right, sum, h);

    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + (Math.max(height(root.left), height(root.right)));
        }
    }

    static void nodeatdistK(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.key + " ");
        } else {
            nodeatdistK(root.left, k - 1);
            nodeatdistK(root.right, k - 1);
        }
    }

    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.isEmpty() == false) {

            Node curr = q.poll();
            System.out.print(curr.key + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    static void levelOrderlinebyline1(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while (q.size() > 1) {
            Node curr = q.poll();

            if (curr == null) {
                System.out.print("\n");
                q.add(null);
                continue;
            }
            System.out.print(curr.key + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }

        }
    }

    static void levelOrderlinebyline2(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int cnt = 0;
        while (q.isEmpty() == false) {
            int size = q.size();
            cnt = cnt + size;
            for (int i = 0; i < size; i++) {

                Node curr = q.poll();
                System.out.print(curr.key + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
        System.out.println("no of nodes is:" + cnt);
    }

    static int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + size(root.left) + size(root.right);
        }
    }

    static int getMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
        }
    }
    static int maxlevel = 0;

    static void printLeftRecursive(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxlevel < level) {
            System.out.println(root.key);
            maxlevel = level;
        }
        printLeftRecursive(root.left, level + 1);
        printLeftRecursive(root.right, level + 1);
    }

    static void printLeftIterative(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.isEmpty() != true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i == 0) {
                    System.out.print(curr.key + " ");
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }

    }

    static boolean childrenSum(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum = sum + root.left.key;
        }
        if (root.right != null) {
            sum = sum + root.right.key;
        }

        return (root.key == sum && childrenSum(root.left) && childrenSum(root.right));

    }

    static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        return (Math.abs(lheight - rheight) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    static int maxWidth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int wd = 0;
        while (q.isEmpty() == false) {
            int size = q.size();
            wd = Math.max(wd, size);
            for (int i = 0; i < size; i++) {

                Node curr = q.poll();
                System.out.print(curr.key + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
        return wd;
    }

    static void dist_k(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.key);
        }
        dist_k(root.left, k - 1);
        dist_k(root.right, k - 1);
    }

    static void printSpiral(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        Stack<Integer> s = new Stack<Integer>();
        boolean reverse = false;
        q.add(root);

        while (q.isEmpty() == false) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();
                if (reverse) {
                    s.push(curr.key);
                } else {
                    System.out.print(curr.key + " ");
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (reverse == true) {
                while (s.isEmpty() == false) {
                    System.out.print(s.pop() + " ");
                }
            }
            reverse = !reverse;
            System.out.println();
        }

    }
    static int dia=0;
    static int diameter(Node root){
        if(root==null)return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        dia=Math.max(dia,1+lh+rh);
        return 1+Math.max(lh,rh);
        
    }

    public static void main(String[] args) {
        Node root = null;
        /*   root = insert(root, 10);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        Inorder(root);*/

        root = insertR(root, 10);
        insertR(root, 30);
        insertR(root, 20);
        insertR(root, 40);
        insertR(root, 70);
        insertR(root, 60);
        insertR(root, 80);
        Inorder(root);

        System.out.println("Item found:" + searchR(root, 70));
        System.out.println("Item found:" + searchI(root, 70));

        System.out.println("This exists?:" + isPairSum(root, 51, new HashSet<Integer>()));
        System.out.println("Height is?:" + height(root));
        System.out.println("size is?:" + size(root));
        System.out.println("Diameter is?:" + diameter(root));
        System.out.println("Maimum is?:" + getMax(root));
        System.out.println("Is tree balanced?:" + isBalanced(root));
        nodeatdistK(root, 2);
        System.out.println(" ");
        levelOrder(root);
        System.out.println(" ");
        levelOrderlinebyline1(root);
        System.out.println("--------------------");
        levelOrderlinebyline2(root);
        System.out.println("Spiral--------------------");
        printSpiral(root);

        printLeftRecursive(root, 1);
        System.out.println("--------------------");
        printLeftIterative(root);

        System.out.println("Children sum property holds?:" + childrenSum(root));
        System.out.println("Width of tree is:" + maxWidth(root));

        System.out.println("--------------------");
        dist_k(root, 2);
    }
}
