package HML1;

import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElements2 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s=new Scanner(System.in);
        int n1=s.nextInt();
        int[] a1=new int[n1];
        for(int i=0;i<n1;i++){
            a1[i]=s.nextInt();
        }
        int n2=s.nextInt();

        int[] a2=new int[n2];
        for(int i=0;i<n2;i++){
            a2[i]=s.nextInt();
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int val:a1){
            if(hm.containsKey(val)){
                int of=hm.get(val);
                hm.put(val,of+1);

            }else{
                hm.put(val,1);
            }
        }

        for(int val:a2){
            if(hm.containsKey(val) && hm.get(val)>0){
                System.out.println(val);
                int of=hm.get(val);
                hm.put(val,of-1);
            }
        }


    }

}

/*
7
1
1
2
2
2
3
5
7
1
1
1
2
2
4
5
 */
