package Concepts;

public class HeapDemo {

    public static void main(String args[]) {
        MinHeap h = new MinHeap(9);
        h.insert(10);
        h.insert(20);
        h.insert(15);
        h.insert(40);
        h.insert(50);
        h.insert(100);
        h.insert(25);
        h.insert(45);

        h.show();

    }

    public static class MinHeap {

        int arr[];
        int size;
        int capacity;

        MinHeap(int c) {
            size = 0;
            capacity = c;
            arr = new int[c];
        }

        int left(int i) {
            return 2 * i + 1;
        }

        int right(int i) {
            return 2 * i + 2;
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        public void insert(int x) {
            if (size == capacity) {
                return;
            }
            size++;
            arr[size - 1] = x;
            for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; ) {
                int tmp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = tmp;
                i = parent(i);
            }
        }

        public void show() {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
