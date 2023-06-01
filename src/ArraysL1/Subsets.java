package ArraysL1;

public class Subsets {
    public static void main(String[] args) {
        int arr[]={4,5,6,7};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]+"\t");
                }
                System.out.println();
            }
        }
    }
}
