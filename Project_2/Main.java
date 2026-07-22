class Student {
    private final String name;
    private final int roll;
    private int marks;

    Student(String name, int roll, int marks) {
        this.name = name;
        this.roll = roll;
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        }
    }

    public void display() {
        System.out.println("Roll Number: " + roll);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + getGrade());
        System.out.println("Passed: " + isPassed());
        System.out.println();
    }

    public char getGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else return 'F';
    }

    public String isPassed() {
        if (marks >= 40) return "True";
        else return "False";
    }

    public static Student getTopper(Student[] stds) {
        Student topper = stds[0];

        for (Student s : stds) {
            if (s.marks > topper.marks) {
                topper = s;
            }
        }

        return topper;
    }

    public static double getAvg(Student[] stds) {
        double avg = 0;

        for (Student s : stds) {
            avg += s.marks; 
        }

        return avg / stds.length;
    }
} 

public class Main {
    public static void main(String[] args) {
        Student[] stds = new Student[5];

        stds[0] = new Student("Maaz", 1, 85);
        stds[1] = new Student("Ali", 2, 90);
        stds[2] = new Student("Arif", 3, 57);
        stds[3] = new Student("Tillu", 4, 38);
        stds[4] = new Student("Seraj", 5, 64);

        for (Student s : stds) {
            s.display();
        }
        
        Student topper = Student.getTopper(stds);

        System.out.println("Topper: " + topper.getName());
        System.out.println("Topper Marks: " + topper.getMarks());
        System.out.println("Average Marks: " + Student.getAvg(stds));

        Student moon = new Student("Moon", 6, 90);

        moon.setMarks(120);

        System.out.println(moon.getMarks());
    }
}
