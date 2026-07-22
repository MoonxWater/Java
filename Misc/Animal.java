class Animals {
    String name;

    void speak() {
        System.out.println("Speak!");
    }
}

class Dog extends Animals {
    @Override
    void speak() {
        System.out.println("Bark!");
    }
}

class Cat extends Animals {
    @Override
    void speak() {
        System.out.println("Meow!");
    }
}


public class Animal {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();

        d.speak();
        c.speak();
    }
}