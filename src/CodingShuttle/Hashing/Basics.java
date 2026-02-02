package CodingShuttle.Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Basics {
    public static void main(String[] args) {
        String s = "BA";
        System.out.println(s.hashCode());
        Boolean a = false;
        System.out.println(a.hashCode());
        Double b = 12.23;
        System.out.println(b.hashCode());

        Boy b1 = new Boy(25, "Anuj");
        Boy b2 = b1;
        Boy b3 = new Boy(26, "Anuj");

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b3.hashCode());

        Map<Integer, String> map = new HashMap<>(); //lf 0.75, ic 16

    }

    static class Boy {
        int age;
        String name;

        public Boy(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

    }
}
