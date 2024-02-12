
package ArraysL1;

/**
 *
 * @author krish
 */


public class RemoveDuplicates {

    public static void main(String a[]) {
        int arr[] = {2,2,3,4,5,6}, n = arr.length;
        int p = removeDup(arr, n);

        System.out.println("After Removal");

        for (int i = 0; i < p; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    
    public static int rmdup(int arr[],int n){
        int p=1;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[p-1]){
                arr[p]=arr[i];
                p++;
            }
        }
        return p;
    }
    

    private static int removeDup(int[] arr, int n) {
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }
}
