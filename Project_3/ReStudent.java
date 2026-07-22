package Project_3;

import java.util.ArrayList;

public class ReStudent {
    private final String name;
    private final int rollNo;
    private int marks;

    ReStudent(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            throw new IllegalArgumentException("Marks should be between 0 to 100");
        }
    }

    public void display() {
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + getGrade());
        System.out.println("Passed: " + (isPassed() ? "True" : "False"));
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

    public boolean isPassed() {
        return marks >= 40;
    }

    public static void main(String[] args) {
        ArrayList<ReStudent> stds = new ArrayList<>();

        stds.add(new ReStudent("Maaz", 1, 85));
        stds.add(new ReStudent("Ali", 2, 90));
        stds.add(new ReStudent("Arif", 3, 57));
        stds.add(new ReStudent("Tillu", 4, 38));
        stds.add(new ReStudent("Seraj", 5, 64));
        stds.set(4, new ReStudent("Kalesh", 10, 67));

        for (ReStudent s : stds) {
            s.display();
        }

        ReStudent res = stds.get(0);
        System.out.println(res);
        stds.get(0).display();
        stds.remove(3).display();

        try {
            stds.get(0).setMarks(120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// this is a java comment
/* this is also a java comment
    but multiline
*/