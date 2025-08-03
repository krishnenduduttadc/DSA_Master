package DesignPatternL2;

public class BuilderPatternDemo {

    // Main method
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("John", "Doe")
                .age(30)
                .phone("1234567890")
                .address("123 Main St")
                .build();

        User user2 = new User.UserBuilder("Jane", "Smith")
                .build();  // no optional fields

        System.out.println(user1);
        System.out.println(user2);
    }

    // Product class
    static class User {
        // required parameters
        private String firstName;
        private String lastName;

        // optional parameters
        private int age;
        private String phone;
        private String address;

        // Private constructor
        private User(UserBuilder builder) {
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.age = builder.age;
            this.phone = builder.phone;
            this.address = builder.address;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + ", Age: " + age + ", Phone: " + phone + ", Address: " + address;
        }

        // Static nested Builder class
        public static class UserBuilder {
            private String firstName;
            private String lastName;
            private int age;
            private String phone;
            private String address;

            public UserBuilder(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public UserBuilder age(int age) {
                this.age = age;
                return this;
            }

            public UserBuilder phone(String phone) {
                this.phone = phone;
                return this;
            }

            public UserBuilder address(String address) {
                this.address = address;
                return this;
            }

            public User build() {
                return new User(this);
            }
        }
    }
}

