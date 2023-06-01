package CollectionsFW;

import java.util.ArrayList;

public class ArrayListD {
    public static void main(String[] args) {
        ArrayList<String> al=new ArrayList<>();
        al.add("amit");
        al.add("arpita");
        al.add("amal");
        System.out.println(al);
        al.add(1,"krish");
        System.out.println(al);

        ArrayList<String> al2=new ArrayList<>();
        al2.add("sudip");
        al2.add("soumen");
        al.addAll(al2);
        System.out.println(al);

        System.out.println(al.get(2));
        al.remove(2);
        System.out.println(al);

        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i)+" ");
        }
    }
}
