package CollectionsFW;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetD {
    public static void main(String[] args) {
        Set<Integer> s=new HashSet<>();
        s.add(4);
        s.add(1);
        s.add(3);
        s.add(2);
        s.add(3);
        System.out.println(s);

        Set<Integer> ss=new LinkedHashSet<>();
        ss.add(4);
        ss.add(1);
        ss.add(3);
        ss.add(2);
        ss.add(3);
        System.out.println(ss);

        Set<Integer> sss=new TreeSet<>();
        sss.add(4);
        sss.add(1);
        sss.add(3);
        sss.add(2);
        sss.add(3);
        System.out.println(sss);
    }
}
