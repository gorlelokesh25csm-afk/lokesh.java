
class Addition {
    int x = 10, y = 5;

    void add() {
        int z = x + y;
        System.out.println("Addition Result: " + z);
    }
}

class Subtraction extends Addition {

    void subtract() {
        int z = x - y;
        System.out.println("Subtraction Result: " + z);
    }
}

class Multiplication extends Subtraction {

    void multiply() {
        int z = x * y;
        System.out.println("Multiplication Result: " + z);
    }
}

 public class Dog {
   public static void main(String[] args) {

        Multiplication m = new Multiplication();

        m.add();
        m.subtract();
        m.multiply();
    }
}