class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

interface Pet {
    void play();
}

class Dog extends Animal implements Pet {

    public void play() {
        System.out.println("Dog is playing");
    }

    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();
        d.play();
    }
}