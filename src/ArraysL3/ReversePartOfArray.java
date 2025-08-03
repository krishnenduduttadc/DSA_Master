package ArraysL3;

public class ReversePartOfArray {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {5, 4, 3, 2, 1};
        int s = 2;
        int e = 4;
        reversePart(arr, s, e);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void reversePart(int[] arr, int s, int e) {
        int sp = s;
        int ep = e;
        while (sp < ep) {
            int temp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = temp;
            sp++;
            ep--;
        }

    }

}
