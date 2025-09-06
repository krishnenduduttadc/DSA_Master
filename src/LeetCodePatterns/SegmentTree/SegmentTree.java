package LeetCodePatterns.SegmentTree;

import java.util.Arrays;

public class SegmentTree {
    private final int[] data;
    private final int[] tree;

    public SegmentTree(int[] data) {
        this.data = data;
        this.tree = new int[2 * data.length];
        this.build(0, 0, data.length - 1);

        System.out.println(Arrays.toString(this.tree));

    }

    public static void main(String[] args) {
        int[] data = {2, 5, 1, 6, 4, 10, 8, 9};
        SegmentTree segmentTree = new SegmentTree(data);
        System.out.println(segmentTree.queryRange(3, 7));
        System.out.println(segmentTree.queryRange(2, 5));

        segmentTree.update(3, 10);
        System.out.println(segmentTree.queryRange(3, 7));
    }

    private void build(int nodeNo, int start, int end) {
        if (start == end) {
            this.tree[nodeNo] = this.data[start];
        } else if (start < end) {
            int mid = (start + end) / 2;
            this.build(2 * nodeNo + 1, start, mid);
            this.build(2 * nodeNo + 2, mid + 1, end);
            this.tree[nodeNo] = this.tree[2 * nodeNo + 1] + this.tree[2 * nodeNo + 2];
        }
    }

    private int query(int nodeNo, int l, int r, int start, int end) {
        if (l > end || r < start) {
            return 0;
        } else if (start >= l && end <= r) {
            return this.tree[nodeNo];
        } else {
            int mid = (start + end) / 2;
            int leftAns = this.query(2 * nodeNo + 1, l, r, start, mid);
            int rightAns = this.query(2 * nodeNo + 2, l, r, mid + 1, end);
            return leftAns + rightAns;
        }
    }

    public int queryRange(int l, int r) {
        return this.query(0, l, r, 0, this.data.length - 1);
    }

    public void update(int nodeNo, int start, int end, int index, int updatedValue) {
        if (start == end) {
            this.tree[nodeNo] = updatedValue;
        } else if (start <= index && index <= end) {
            int mid = (start + end) / 2;
            if (index <= mid) {
                this.update(2 * nodeNo + 1, start, mid, index, updatedValue);
            } else {
                this.update(2 * nodeNo + 2, mid + 1, end, index, updatedValue);
            }
            this.tree[nodeNo] = this.tree[2 * nodeNo + 1] + this.tree[2 * nodeNo + 2];
        }
    }

    public void update(int index, int updatedValue) {
        this.update(0, 0, this.data.length - 1, index, updatedValue);
    }

}
