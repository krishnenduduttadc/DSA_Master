package DP_CreationalPattern;

//Builds complex objects step by step.
//Separates construction from representation.
//Improves readability.
//Used when many optional fields.

class House {
    String roof;

    static class Builder {
        House h = new House();

        Builder roof(String r) {
            h.roof = r;
            return this;
        }

        House build() {
            return h;
        }
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        House h = new House.Builder().roof("Concrete").build();
        System.out.println(h.roof);
    }
}

