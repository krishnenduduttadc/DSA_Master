package HML1;

import java.util.HashMap;

public class GetCommonElements2 {
    public static void main(String[] args) throws Exception {
        // write your code here
        //Scanner s=new Scanner(System.in);
        int n1=7;//s.nextInt();
        int[] a1={1, 1, 2, 2, 2, 3, 5};

        int[] a2={1, 1, 1, 2, 2, 4, 5};

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
1
2
2
4
5
 */
