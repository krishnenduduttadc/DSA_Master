package ArraysL1;

public class FirstAndLastIndex {
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = 15;
        int[] arr = {
                1, 5, 10, 15, 22, 33, 33, 33, 33, 33, 40, 42, 55, 66, 77
        };


        int d = 33;


        int low = 0;
        int high = arr.length - 1;
        int firstIndex = -1;
        int lastIndex = -1;


        while (low <= high) {
            int mid = (low + high) / 2;
            if (d > arr[mid]) {
                low = mid + 1;
            } else if (d < arr[mid]) {
                high = mid - 1;
            } else {
                firstIndex = mid;
                high = mid - 1;
            }
        }
        System.out.println(firstIndex);

        low = 0;
        high = arr.length - 1;


        while (low <= high) {
            int mid = (low + high) / 2;
            if (d > arr[mid]) {
                low = mid + 1;
            }
            if (d < arr[mid]) {
                high = mid - 1;
            }
            if (d == arr[mid]) {
                lastIndex = mid;
                low = mid + 1;
            }
        }
        System.out.println(lastIndex);

    }
}

/*
15
1
5
10
15
22
33
33
33
33
33
40
42
55
66
77
33
 */
