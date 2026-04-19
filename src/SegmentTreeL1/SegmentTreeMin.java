package SegmentTreeL1;

public class SegmentTreeMin {

    static int[] tree;
    static int n;

    static void build(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        buildUtil(arr, 0, 0, n - 1);
    }

    static void buildUtil(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildUtil(arr, 2 * node + 1, start, mid);
            buildUtil(arr, 2 * node + 2, mid + 1, end);
            tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return Integer.MAX_VALUE;
        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        int left = query(2 * node + 1, start, mid, l, r);
        int right = query(2 * node + 2, mid + 1, end, l, r);

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 6};

        build(arr);

        System.out.println("Min(1,3): " + query(0, 0, n - 1, 1, 3)); // 1
    }
}
