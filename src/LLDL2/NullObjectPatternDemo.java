package LLDL2;

public class NullObjectPatternDemo {

    // Main method
    public static void main(String[] args) {
        Customer c1 = CustomerFactory.getCustomer("Alice");
        Customer c2 = CustomerFactory.getCustomer("David");

        System.out.println(c1.getName());  // Output: Alice
        System.out.println(c2.getName());  // Output: Not Available
    }

    // Abstract class or Interface
    abstract static class Customer {
        protected String name;

        public abstract boolean isNull();

        public abstract String getName();
    }

    // Real Object
    static class RealCustomer extends Customer {
        public RealCustomer(String name) {
            this.name = name;
        }

        @Override
        public boolean isNull() {
            return false;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    // Null Object
    static class NullCustomer extends Customer {
        @Override
        public boolean isNull() {
            return true;
        }

        @Override
        public String getName() {
            return "Not Available";
        }
    }

    // Factory
    static class CustomerFactory {
        private static final String[] names = {"Alice", "Bob", "Charlie"};

        public static Customer getCustomer(String name) {
            for (String n : names) {
                if (n.equalsIgnoreCase(name)) {
                    return new RealCustomer(n);
                }
            }
            return new NullCustomer();
        }
    }
}

