package BitManipulationL2;

public class ElementsRepeating4times {
    public static void main(String[] args) {


        int[] arr = {2, 4, 1, 2, 4}; // Example input

        int ans = 0;

        for(int i=0;i<arr.length;i++){
            ans = ans ^ arr[i];
        }

        System.out.println(ans);
    }

}
