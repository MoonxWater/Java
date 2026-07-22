class Teacher {
    String name;
    int age;
    int salary;
    boolean isPaid;

    Teacher(String name, int age, int salary, boolean isPaid) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isPaid = isPaid;
    }
}

public class Demo {
    public static void main(String[] args) {
        Teacher[] teachers = new Teacher[3];
        teachers[0] = new Teacher("Maaz", 18, 50000, true);
        teachers[1] = new Teacher("Ali", 19, 50000, true);
        teachers[2] = new Teacher("Tillu", 18, 5, false);

        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Name: " + teachers[i].name);
            System.out.println("Age: " + teachers[i].age);
            System.out.println("Salary: " + teachers[i].salary);
            System.out.println("Is Paid: " + teachers[i].isPaid);
            System.out.println();
        }
    }
}
