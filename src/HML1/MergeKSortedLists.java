package HML1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;
        Pair(int li,int di,int val){
            this.li=li;
            this.di=di;
            this.val=val;
        }

        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();

        // write your code here
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<lists.size();i++){
            Pair p=new Pair(i,0,lists.get(i).get(0));
            pq.add(p);
        }
        while(pq.size()>0){
            Pair p=pq.remove();
            rv.add(p.val);
            p.di++;

            if(p.di<lists.get(p.li).size()){
                p.val=lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 4;//Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list0 = new ArrayList<>();
        list0.add(10);
        list0.add(20);
        list0.add(30);
        list0.add(40);
        list0.add(50);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list1.add(11);
        list1.add(19);
        list1.add(55);
        list1.add(57);


        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        lists.add(list0);
        lists.add(list1);
        lists.add(list2);


        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

/*
4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39
 */
