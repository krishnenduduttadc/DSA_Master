package HML2;

import java.util.HashMap;

public class Itenary {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Banglore");
        map.put("Bombay", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        HashMap<String, Boolean> psrc = new HashMap<>();
        for (String src : map.keySet()) {
            String des = map.get(src);
            psrc.put(des, false);
            if (psrc.containsKey(src) == false) {
                psrc.put(src, true);
            }
        }

        //System.out.println(psrc);
        String src="";
        for(String s:psrc.keySet()){
            if(psrc.get(s)==true){
                src=s;
            }
        }
        //System.out.println(src);

        while(true){
            if(map.containsKey(src)==true){
                System.out.print(src+"->");
                src=map.get(src);
            }else{
                System.out.print(src+".");
                break;
            }
        }
    }
}
