package ArraysL1;

public class Rotate {
    static void rev(int[] arr,int i,int j){
        int si=i;
        int ei=j;
        while(si<ei){
            int t=arr[si];
            arr[si]=arr[ei];
            arr[ei]=t;
            si++;
            ei--;
        }
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,7,8};

        int k=12;
        k=k%arr.length;
        if(k<0){
            k=k+arr.length;
        }
        //part1
        rev(arr,0,arr.length-k-1);
        //part2
        rev(arr,arr.length-k,arr.length-1);

        rev(arr,0,arr.length-1);

        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
