package HML2;

import java.util.*;

public class FindItenary {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Banglore");
        map.put("Bombay", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        //write your code here
        HashMap<String,Boolean> psrc=new HashMap<>();
        for(String src:map.keySet()){
            String dest=map.get(src);

            psrc.put(dest,false);
            if(psrc.containsKey(src)==false){
                psrc.put(src,true);
            }
        }


        String src="";
        for(String pot:psrc.keySet()){
            Boolean val=psrc.get(pot);
            if(val==true){
                src=pot;
                break;
            }
        }


        while(true){
            if(map.containsKey(src)==true){
                System.out.print(src+" -> ");
                src=map.get(src);
            }else{
                System.out.print(src+". ");
                break;
            }
        }

    }
}


/*


4
Chennai Banglore
Bombay Delhi
Goa Chennai
Delhi Goa

 */
