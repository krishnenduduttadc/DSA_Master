package Sorting;

public class Bubble {
    public static void main(String[] args) {


        int[] arr = {0,1,5,7,8,9,4};
        int n=arr.length;
        BubbleSort(arr);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void BubbleSort(int[] arr){
        int n = arr.length;

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
