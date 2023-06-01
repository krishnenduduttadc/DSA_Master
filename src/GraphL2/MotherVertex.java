package GraphL2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MotherVertex {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(v);
        }

        System.out.println(findMotherVertex(n, graph));
    }
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>>adj){

        Stack<Integer> stack=new Stack<>();
        boolean[] vis=new boolean[N];;

        for(int i=0;i<N;i++){
            if(vis[i]==false){
                dfs(adj,vis,i,stack);
            }
        }

        int ans=stack.pop();
        vis=new boolean[N];
        count=0;

        dfs(adj,vis,ans);
        if(count==N){
            return ans+1;
        }else{
            return -1;
        }

    }

    static int count;
    static void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] visited,int cur,
                    Stack<Integer> stack){
        visited[cur]=true;

        for(int nbrs:graph.get(cur)){
            if(visited[nbrs]==false){
                dfs(graph,visited,nbrs,stack);
            }
        }
        stack.push(cur);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int cur){
        visited[cur]=true;
        count++;
        for(int nbrs:graph.get(cur)){
            if(visited[nbrs]==false){
                dfs(graph,visited,nbrs);
            }
        }

    }
}

/*
4 3
1 2
2 3
3 4
 */
