package LowLevelDesign;

public class InheritenceAndPolymorphism {

    public static class Animal {
        public void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    public static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Bark");
        }
    }

    // Derived class Cat
    public static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow");
        }
    }

    public static void main(String[] args) {
        // Create instances of Animal, Dog, and Cat
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        // Demonstrate polymorphism
        myAnimal.makeSound(); // Output: Some generic animal sound
        myDog.makeSound();    // Output: Bark
        myCat.makeSound();    // Output: Meow
    }
}
