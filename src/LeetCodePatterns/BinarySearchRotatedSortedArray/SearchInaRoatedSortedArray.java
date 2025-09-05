package LeetCodePatterns.BinarySearchRotatedSortedArray;

public class SearchInaRoatedSortedArray {

    public static void main(String[] args) {
        SearchInaRoatedSortedArray solver = new SearchInaRoatedSortedArray();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {3, 1};
        int[] nums3 = {1};

        System.out.println("Search 0 in nums1: " + solver.search(nums1, 0)); // Expected 4
        System.out.println("Search 3 in nums1: " + solver.search(nums1, 3)); // Expected -1
        System.out.println("Search 1 in nums2: " + solver.search(nums2, 1)); // Expected 1
        System.out.println("Search 0 in nums3: " + solver.search(nums3, 0)); // Expected -1
    }

    public int search(int[] arr, int target) {
        int por = findPor(arr);
        if (por == 0) {
            return bSearch(arr, 0, arr.length - 1, target);
        }
        if (target >= arr[0]) {
            return bSearch(arr, 0, por - 1, target);
        } else {
            return bSearch(arr, por, arr.length - 1, target);
        }
    }

    int bSearch(int[] arr, int startPoint, int endPoint, int key) {
        int start = startPoint;
        int end = endPoint;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > key) {
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    int findPor(int[] arr) {
        int start = 0, end = arr.length - 1;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= arr[arr.length - 1]) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return ans;
    }
}
