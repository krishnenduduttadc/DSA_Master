package BinaryTreeL1;

import java.util.*;

public class BasicTreeOperations {
    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node root;

    private void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    public void levelOrder(Node root) {
        //if(root==null)return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.key + " ");
            //System.out.print(curr.key + ":L:" + curr.left.key + ",R:" + curr.right.key);

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node current = q.remove();
                currentLevel.add(current.key);

                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            result.add(currentLevel);

        }
        return result;
    }


    public void levelOrderLinebyLine(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while (q.size() > 1) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
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

    public void levelOrderLinebyLine2(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
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
    }

    public int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + size(root.left) + size(root.right);
        }
    }

    int countNodes(Node root) {
        int lh = 0, rh = 0;
        Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int max(Node root) {
        if (root == null) {
            return -1;
        } else {
            return Math.max(root.key, Math.max(max(root.left), max(root.right)));
        }
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return (Math.max(height(root.left), height(root.right))) + 1;
        }
    }

    public void printKdist(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.key + " ");
        } else {
            printKdist(root.left, k - 1);
            printKdist(root.right, k - 1);
        }
    }

    public void leftView(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
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
        }
    }

    public void printSpiral(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        Stack<Integer> s = new Stack<Integer>();
        boolean reverse = false;
        q.add(root);
        while (q.isEmpty() == false) {
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
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
                if (reverse) {
                    while (s.isEmpty() == false) {
                        System.out.print(s.pop() + " ");
                    }
                }
                reverse = !reverse;
                //System.out.println();
            }
        }
    }

    boolean isChildrenSum(Node root) {
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
        return (root.key == sum && isChildrenSum(root.left) && isChildrenSum(root.right));
    }

    int isBalanced(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = isBalanced(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = isBalanced(root.right);
        if (rh == -1) {
            return -1;
        }

        if (Math.abs(lh - rh) > 1) {
            return -1;
        } else {
            return (Math.max(lh, rh) + 1);
        }
    }

    int maxWidth(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res = Math.max(res, size);
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return res;
    }

    int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);
        return Math.max(d1, Math.max(d2, d3));
    }

    static void inorderIter(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        while (curr != null & !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(" " + curr.key);
            curr = curr.right;
        }
    }

    static void pairSum(Node curr, int sum, Node root) {
        if (curr == null) {
            return;
        }
        int s = sum - curr.key;
        Node f = null;
        if (curr.key < s) {
            f = find(root, s);
        }
        if (f != null) {
            System.out.println(curr.key + " " + f.key);
        }
        pairSum(curr.left, sum, root);
        pairSum(curr.right, sum, root);
    }

    static Node find(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.key == x) {
            return root;
        }
        Node left = find(root.left, x);
        if (left != null) {
            return left;
        }
        Node right = find(root.right, x);
        if (right != null) {
            return right;
        }
        return null;
    }

    public static ArrayList<Integer> longestRootToLeafPath(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(root.key);
            return ans;
        }
        ArrayList<Integer> leftAns = longestRootToLeafPath(root.left);
        ArrayList<Integer> rightAns = longestRootToLeafPath(root.right);
        if (leftAns == null) {
            rightAns.add(root.key);
            return rightAns;
        }

        if (rightAns == null) {
            leftAns.add(root.key);
            return leftAns;
        }
        if (leftAns.size() > rightAns.size()) {
            leftAns.add(root.key);
            return leftAns;
        } else {
            rightAns.add(root.key);
            return rightAns;
        }
    }

    public void binaryTreePaths(Node root) {
        if(root==null){
            return ;
        }
        System.out.print(""+root.key);
        binaryTreePaths(root.left);
        binaryTreePaths(root.right);

    }

    public static void main(String[] args) {
        BasicTreeOperations tree = new BasicTreeOperations();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        ArrayList<Integer> p = longestRootToLeafPath(root);
        for (int i = 0; i < p.size(); i++) {
            System.out.print(p.get(i) + "--");
        }
        System.out.println("\n------------->");
        tree.binaryTreePaths(root);
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPostorder(root);

        System.out.println("Level order traversal of binary tree is ");
        tree.levelOrder(root);

        System.out.println("Level order line by line traversal of binary tree is ");
        tree.levelOrderLinebyLine2(root);

        System.out.println("Tree size is " + tree.size(root));

        System.out.println("Tree maximum element is " + tree.max(root));

        System.out.println("Height of tree is " + tree.height(root));

        tree.printKdist(root, 2);

        System.out.println("Left view of tree ");
        tree.leftView(root);

        System.out.println("\nIs children sum true: " + tree.isChildrenSum(root));

        System.out.println("\nIs height balanced: " + tree.isBalanced(root));

        System.out.println("\nMaximum width is: " + tree.maxWidth(root));

        System.out.println("\nSpiral traversal is: ");
        tree.printSpiral(root);

        System.out.println("\nDiameter is: " + tree.diameter(root));

        System.out.println("\nNo of nodes is: " + tree.countNodes(root));

        //System.out.println("\nThe nodes is: " + find(root, 5));
        pairSum(root, 5, root);
    }
}
