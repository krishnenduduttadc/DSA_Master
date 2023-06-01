package HML1;

import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElements1 {
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
                int nf=of+1;
                hm.put(val,nf);
            }else{
                hm.put(val,1);
            }
        }

        for(int val:a2){
            if(hm.containsKey(val)){
                System.out.println(val);
                hm.remove(val);
            }
        }

    }

}

/*
9
5
5
9
8
5
5
8
0
3
18
9
7
1
0
3
6
5
9
1
1
8
0
2
4
2
9
1
5
 */
