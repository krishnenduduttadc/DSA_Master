package CollectionsFW;

import java.util.Stack;

public class StackD {
    public static void main(String[] args) {
        Stack<String> s=new Stack<>();
        s.push("amit");
        s.push("rahul");
        s.push("krish");
        s.push("sutapa");
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s);
        //s.clear();
        System.out.println(s.isEmpty());
    }
}
