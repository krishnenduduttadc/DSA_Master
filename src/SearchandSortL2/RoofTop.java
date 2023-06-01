package SearchandSortL2;

public class RoofTop {
    public static void main(String[] args) {
        int arr[] = {1,4,5,7,6,2,4};
        System.out.println(find(arr));
    }
    static int find(int[] arr){
        int ms=0;
        int c=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<arr[i+1]){
                c++;
            }else{
                if(c>ms){
                    ms=c;
                }
                c=0;

            }
        }
        if(c>ms){
            ms=c;
        }
        return ms;
    }
}
