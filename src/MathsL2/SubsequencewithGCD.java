package MathsL2;

public class SubsequencewithGCD {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int n = arr.length;


        int ans =0;
        for(int i=0;i<n;i++){
            ans = gcd(ans,arr[i]);
        }

        if(ans == 1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
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
