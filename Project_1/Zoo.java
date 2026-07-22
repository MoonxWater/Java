class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }
    
    void speak() {
        System.out.println("Speak!");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void speak() {
        System.out.println("Bark!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void speak() {
        System.out.println("Meow!");
    }
}

class Cow extends Animal {
    Cow(String name) {
        super(name);
    }

    @Override
    void speak() {
        System.out.println("Moo!");
    }
}

class Lion extends Animal {
    Lion(String name) {
        super(name);
    }

    @Override
    void speak() {
        System.out.println("Roar!");
    }
}

public class Zoo {
    public static void main(String[] args) {
        Animal[] zoo = {
            new Dog("Tommy"),
            new Cat("Sufra"),
            new Lion("Mufasa"),
            new Cow("Mughal-e-Azam")
        };

        for (Animal a : zoo) {
            a.speak();
        }
    }
}
