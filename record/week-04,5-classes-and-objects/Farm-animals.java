class Animal {
    String name;
    String stay;
    String food;
    Animal() {
        name = "Unknown";
        stay = "Unknown";
        food = "Unknown";
    }
    Animal(String name, String stay, String food) {
        this.name = name;
        this.stay = stay;
        this.food = food;
    }
    void display() {
        System.out.println("Animal : " + name);
        System.out.println("Stay   : " + stay);
        System.out.println("Food   : " + food);
    }
    void display(String sound) {
        display();
        System.out.println("Sound  : " + sound);
        System.out.println();
    }
}

public class ClassesAndOBjects {
    public static void main(String[] args) {
        Animal cow = new Animal("Cow", "Farm", "Grass");
        Animal pig = new Animal("Pig", "Pigsty", "Vegetables");
        Animal horse = new Animal("Horse", "Stable", "Hay");

        cow.display("Moo");
        pig.display("Oink");
        horse.display("Neigh");
    }
}
