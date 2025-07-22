package LLDL1;

public class InterfaceSegregation {
    public static void main(String[] args) {
        // Create instances of Employee and Manager
        Employee employee = new Employee();
        Manager manager = new Manager();

        // Demonstrate Employee behavior
        performWork(employee);
        allowEating(employee);

        // Demonstrate Manager behavior
        performWork(manager);
        allowEating(manager);
        performManagement(manager);
    }

    // Method to perform work
    public static void performWork(Workable worker) {
        worker.work();
    }

    // Method to allow eating
    public static void allowEating(Eatable eater) {
        eater.eat();
    }

    // Method to perform management
    public static void performManagement(Manageable manager) {
        manager.manage();
    }

    public interface Worker {
        void work();

        void eat();

        void manage();
    }

    // Small specific interfaces (following ISP)
    public interface Workable {
        void work();
    }


    public interface Eatable {
        void eat();
    }

    public interface Manageable {
        void manage();
    }

    // Employee class (following ISP)
    public static class Employee implements Workable, Eatable {
        @Override
        public void work() {
            System.out.println("Employee working");
        }

        @Override
        public void eat() {
            System.out.println("Employee eating");
        }
    }

    // Manager class (following ISP)
    public static class Manager implements Workable, Eatable, Manageable {
        @Override
        public void work() {
            System.out.println("Manager working");
        }

        @Override
        public void eat() {
            System.out.println("Manager eating");
        }

        @Override
        public void manage() {
            System.out.println("Manager managing");
        }
    }
}


