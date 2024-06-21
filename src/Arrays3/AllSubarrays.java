package Arrays3;

public class AllSubarrays {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};



        for(int sp =0;sp < arr.length;sp++){
            for(int ep = sp;ep<arr.length;ep++){

                for(int i=sp;i<=ep;i++){
                    System.out.print(arr[i]+" ");
                }

                System.out.println();
            }
        }
    }

}
