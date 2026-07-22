package Project_3;

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Fly!");
    }
}

class Fish implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Swim!");
    }
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Fly!");
    }

    @Override
    public void swim() {
        System.out.println("Swim!");
    }
}

public class Main {
    public static void main(String[] args) {
        Flyable b = new Bird();
        Swimmable f = new Fish();

        b.fly();
        f.swim();

        Duck d = new Duck();

        d.fly();
        d.swim();
    }
}
