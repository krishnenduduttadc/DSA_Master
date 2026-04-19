package SegmentTreeL1;

public class SegmentTreeEvenCount {

    static int[] tree;
    static int n;

    static void build(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        buildUtil(arr, 0, 0, n - 1);
    }

    static void buildUtil(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = (arr[start] % 2 == 0) ? 1 : 0;
        } else {
            int mid = (start + end) / 2;
            buildUtil(arr, 2 * node + 1, start, mid);
            buildUtil(arr, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        return query(2 * node + 1, start, mid, l, r)
                + query(2 * node + 2, mid + 1, end, l, r);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7};

        build(arr);

        System.out.println("Even count(1,4): " + query(0, 0, n - 1, 1, 4)); // 3
    }
}
