package SegmentTreeL1;

public class SegmentTreeSum {

    static int[] tree;
    static int n;

    // Build tree
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
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Query
    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0; // no overlap
        if (l <= start && end <= r) return tree[node]; // full overlap

        int mid = (start + end) / 2;
        int left = query(2 * node + 1, start, mid, l, r);
        int right = query(2 * node + 2, mid + 1, end, l, r);

        return left + right;
    }

    // Update
    static void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid)
                update(2 * node + 1, start, mid, idx, val);
            else
                update(2 * node + 2, mid + 1, end, idx, val);

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};

        build(arr);

        System.out.println("Sum(1,3): " + query(0, 0, n - 1, 1, 3)); // 15

        update(0, 0, n - 1, 1, 10);

        System.out.println("After update Sum(1,3): " + query(0, 0, n - 1, 1, 3)); // 22
    }
}
