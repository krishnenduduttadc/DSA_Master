package DesignPatternL2;

import java.util.ArrayList;
import java.util.List;

public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository repo = new NameRepository();
        repo.add("Alice");
        repo.add("Bob");
        repo.add("Charlie");

        Iterator<String> it = repo.getIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    interface Iterator<T> {
        boolean hasNext();

        T next();
    }

    static class NameRepository {
        List<String> names = new ArrayList<>();

        public void add(String name) {
            names.add(name);
        }

        public NameIterator getIterator() {
            return new NameIterator();
        }

        class NameIterator implements Iterator<String> {
            int index = 0;

            public boolean hasNext() {
                return index < names.size();
            }

            public String next() {
                return hasNext() ? names.get(index++) : null;
            }
        }
    }
}

