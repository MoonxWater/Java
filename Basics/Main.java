class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void getName() {
        System.out.printf("Student's name is %s. \n", name);
    }

    void getChar() {
        for (char i : name.toCharArray()) {
            System.out.println(i);
        }
    }

    void getChar2() {
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
    }
}

public class Main {
    static Student createStudent(String name, int age) {
        Student s = new Student(name, age);
        return s;
    }

    public static void main(String[] args) {
        Student s1 = Main.createStudent("Seraj", 20);
        s1.getName();
        s1.getChar();
        s1.getChar2();
    }
}