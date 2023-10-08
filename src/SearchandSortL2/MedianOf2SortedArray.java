package SearchandSortL2;

public class MedianOf2SortedArray {
    public static void main(String[] args) {
        int arr1[] = {3, 5, 7, 10, 15};
        int arr2[] = {2, 4, 12};
        System.out.println(find(arr1,arr2));
    }

    static double find(int[] a1, int[] a2) {
        int len = a1.length + a2.length;
        int[] merged = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;


        while (i < a1.length && j < a2.length) {
            if(a1[i]<a2[j]){
                merged[k]=a1[i];
                i++;
                k++;
            }else{
                merged[k]=a2[j];
                j++;
                k++;
            }
        }

        while(i<a1.length){
            merged[k]=a1[i];
            i++;
            k++;
        }
        while(j<a2.length){
            merged[k]=a2[j];
            j++;
            k++;
        }
        double median=0.0;
        int mid=merged.length/2;
        if(merged.length%2==1){
            median=merged[mid];
        }else{
            median=(merged[mid]+merged[mid-1])/2.0;
        }
        return median;
    }
}
