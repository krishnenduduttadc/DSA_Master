package HML2;

import java.util.HashMap;
import java.util.Scanner;

public class Itenary {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = 4;
        HashMap<String, String> map = new HashMap<>();
        map.put("chennai", "bangalore");
        map.put("bombay", "delhi");
        map.put("goa", "chennai");
        map.put("delhi", "goa");

        HashMap<String, Boolean> psrc = new HashMap<>();
        for (String src : map.keySet()) {
            String des = map.get(src);
            psrc.put(des, false);

            if (psrc.containsKey(src) == false) {
                psrc.put(src, true);
            }
        }
        String osrc = "";
        System.out.println(psrc);
        for (String s : psrc.keySet()) {
            if (psrc.get(s) == true) {
                osrc = s;
            }
        }
        //System.out.println(osrc);

        String src = osrc;

        while (true) {
            if (map.containsKey(src) == true) {
                System.out.print(src + "->");
                src = map.get(src);
            } else {
                System.out.print(src + ".");
                break;
            }
        }

    }
}
