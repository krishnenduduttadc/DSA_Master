package GraphL2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SatisfiabilityOfEqualityEquation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        System.out.println(equationsPossible(arr));
    }

    static int[] parent;
    static int[] rank;


    public static boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i]=i;
            rank[i]=1;
        }

        for(String e:equations){
            if(e.charAt(1)=='='){
                union(e.charAt(0)-'a',e.charAt(3)-'a');
            }
        }

        for(String eqn:equations){
            if(eqn.charAt(1)=='!'){
                int lx=find(eqn.charAt(0)-'a');
                int ly=find(eqn.charAt(3)-'a');
                if(lx==ly){
                    return false;
                }
            }
        }
        return true;
    }


    static void union(int x,int y){
        int lx=find(x);
        int ly=find(y);
        if(rank[lx]>rank[ly]){
            parent[ly]=lx;
        }else if(rank[lx]<rank[ly]){
            parent[lx]=ly;
        }else{
            parent[lx]=ly;
            rank[ly]++;
        }
    }
    static int find(int x){
        if(parent[x]==x){
            return x;
        }
        int temp=find(parent[x]);
        parent[x]=temp;
        return temp;
    }
}

/*
2
b==c
c!=b
 */
