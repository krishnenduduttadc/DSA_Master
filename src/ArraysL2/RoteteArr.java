package ArraysL2;

public class RoteteArr {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        int n=arr.length;
        int k=3; //rotate by 2
        int arr2[]=new int[n];

        int j=0;
        for(int i=n-k;i<=n-1;i++){
            arr2[j]=arr[i];
            j++;
        }

        int l=k;
        for(int i=0;i<=n-k-1;i++){
            arr2[l]=arr[i];
            l++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
    }
}
