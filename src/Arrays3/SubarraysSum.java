package Arrays3;

public class SubarraysSum {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int n=arr.length;



        int sum = 0;

        for(int i=0; i<n;i++){
            int occ = (i+1)*(n-i);
            sum = sum + occ*arr[i];
        }

        System.out.println(sum);
    }

}
