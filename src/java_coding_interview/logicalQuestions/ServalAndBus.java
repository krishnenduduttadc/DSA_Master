package java_coding_interview.logicalQuestions;

public class ServalAndBus {
    static int index=-1;
    public static void main(String[] args) {
        int n=3;
        int t=7;
        int[][] input={{2,2},{2,3},{2,4}};
        int[] a=new int[n];

        for (int i = 0; i < n; i++) {
            int[] in=input[i];
            int start=in[0];
            int frequency=in[1];

            if(start>=t){
                a[i]=start;
            }else{
                int u=t-start;
                int next_bus_freq=(((u-1)/frequency )+1)*frequency;
                a[i]=start+next_bus_freq;
            }
        }

        int min_value=min(a);
        System.out.println(index+1);
    }

    static  int min(int[] a){
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(min>a[i]){
                min=a[i];
                index=i;
            }
        }
        return min;
    }
}
