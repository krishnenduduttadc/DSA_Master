package Striver_tree;

public class TopView {
//    static ArrayList<Integer> topView(Node root)
//    {
//        ArrayList<Integer> ans = new ArrayList<>();
//        if(root == null) return ans;
//        Map<Integer, Integer> map = new TreeMap<>();
//        Queue<Pair> q = new LinkedList<Pair>();
//        q.add(new Pair(root, 0));
//        while(!q.isEmpty()) {
//            Pair it = q.remove();
//            int hd = it.hd;
//            Node temp = it.node;
//            if(map.get(hd) == null) map.put(hd, temp.data);
//            if(temp.left != null) {
//
//                q.add(new Pair(temp.left, hd - 1));
//            }
//            if(temp.right != null) {
//
//                q.add(new Pair(temp.right, hd + 1));
//            }
//        }
//
//        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
//            ans.add(entry.getValue());
//        }
//        return ans;
//
//    }
//
//    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.left.left = new Node(6);
//
//        ArrayList<Integer> res=topView(root);
//        System.out.println(res);
//    }
}
