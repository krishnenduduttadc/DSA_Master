package MathsL2;

public class GCDArray {
    public static void main(String[] args) {


        int[] arr = {4,8,12,24};
        int n=arr.length;


        int ans =0;
        for(int i=0;i<n;i++){
            ans = gcd(ans,arr[i]);
        }

        System.out.println(ans);
    }


    public static int gcd(int a , int b)
    {
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
}
