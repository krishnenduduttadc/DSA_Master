package CollectionsFW;

import java.util.HashMap;
import java.util.Map;

public class MapD {
    public static void main(String[] args) {
        Map<String,Integer> m=new HashMap<>();
        m.put("one",1);
        m.put("two",2);
        m.put("two",5);
        m.put("three",3);
        System.out.println(m.keySet());
        System.out.println(m);
        System.out.println(m.containsKey("one"));
        System.out.println(m.containsValue(1));
        m.remove("one");
        System.out.println(m);
        System.out.println(m.get("two"));
    }
}
