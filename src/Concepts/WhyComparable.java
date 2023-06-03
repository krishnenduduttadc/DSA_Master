package Concepts;

class Student implements Comparable<Student> {
    int id;
    int age;

    public Student(int id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        if (s.age > age) {
            return s.age;
        } else {
            return age;
        }
    }
}

public class WhyComparable {
    public static void main(String args[]) {
        Student amit=new Student(1,18);
        Student arpita=new Student(2,19);
        System.out.println(amit.compareTo(arpita));
    }
}
