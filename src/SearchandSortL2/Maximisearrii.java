package SearchandSortL2;

import java.util.Arrays;

public class Maximisearrii {
    public static void main(String[] args) {
        int arr[] = {1,4,5,7,6,2,4};
        System.out.println(maximise(arr));
    }
    static int maximise(int[] arr){
        int osum=0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            osum+=arr[i]*i;
        }
        return osum;
    }
}
