package HML2;

import java.util.HashMap;
import java.util.HashSet;

public class EmployeesUnderManager {
    public static void main(String[] args){
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("A","C");
        map.put("B","C");
        map.put("C","F");
        map.put("D","E");
        map.put("E","F");
        map.put("F","F");

        findCount(map);
    }
    static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String,Integer> result){
        if(tree.containsKey(man)==false){
            result.put(man,0);
            return 1;
        }
        int sz=0;
        for(String emp:tree.get(man)){
            int cs=getSize(tree,emp,result);
            sz+=cs;
        }
        result.put(man,sz);
        return sz+1;
    }

    static void findCount(HashMap<String,String> map){
        HashMap<String,HashSet<String>> tree=new HashMap<>();
        String ceo="";
        for(String emp:map.keySet()){
            String man=map.get(emp);
            if(man.equals(emp)){
                ceo=man;
            }else{
                if(tree.containsKey(man)){
                    HashSet<String> emps=tree.get(man);
                    emps.add(emp);
                }else{
                    HashSet<String> emps=new HashSet<>();
                    emps.add(emp);
                    tree.put(man,emps);

                }
            }
        }

        HashMap<String,Integer> result=new HashMap<>();
        getSize(tree,ceo,result);

        for(String emp:result.keySet()){
            System.out.println(emp+" "+result.get(emp));
        }

    }
}/*
6
A C
B C
C F
D E
E F
F F
 */
