package SearchandSortL2;

import java.util.ArrayList;

public class UnionOf2SortedArrays {
    public static void main(String[] args) {
        int a[] = {1, 2, 4};
        int b[] = {3, 5, 6};
        ArrayList<Integer> ll = union(a, b);
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
    }

    static ArrayList<Integer> union(int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                if (list.size() > 0 && list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                } else if (list.size() == 0) {
                    list.add(a[i]);
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                if (list.size() > 0 && list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                } else if (list.size() == 0) {
                    list.add(a[i]);
                }
                i++;
            } else {
                if (list.size() > 0 && list.get(list.size() - 1) != b[j]) {
                    list.add(b[j]);
                } else if (list.size() == 0) {
                    list.add(a[i]);
                }
                j++;
            }
        }

        while (i < a.length) {
            if (list.get(list.size() - 1) != a[i]) {
                list.add(a[i]);
            }
            i++;
        }

        while (j < b.length) {
            if (list.get(list.size() - 1) != b[j]) {
                list.add(b[j]);
            }
            j++;
        }
        return list;
    }
}
