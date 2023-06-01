package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReconstructItenary {
    static HashMap<String,PriorityQueue<String>> graph;
    static LinkedList<String> ans;

    public static List<String> findItinerary(List<List<String>> tickets) {
        graph=new HashMap<>();
        ans=new LinkedList<>();

        for(List<String> ticket:tickets){
            PriorityQueue<String> temp=graph.getOrDefault(ticket.get(0),new PriorityQueue<>());
            temp.add(ticket.get(1));
            graph.put(ticket.get(0),temp);
        }

        dfs("JFK");
        return ans;
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bi.readLine());

        List<List<String>> ans=new ArrayList<>();
        for(int i=0; i<n; ++i){
            String str[]=bi.readLine().split(" ");
            ArrayList<String> smallAns=new ArrayList<>();
            smallAns.add(str[0]);
            smallAns.add(str[1]);
            ans.add(smallAns);
        }

        List<String> res=findItinerary(ans);
        System.out.println(res);
    }

    static void dfs(String src){
        PriorityQueue<String> nbrs=graph.get(src);
        while(nbrs!=null && nbrs.size()>0){
            String nbr=nbrs.remove();
            dfs(nbr);
        }
        ans.addFirst(src);
    }
}

/*
5
JFK SFO
JFK ATL
SFO ATL
ATL JFK
ATL SFO
 */
