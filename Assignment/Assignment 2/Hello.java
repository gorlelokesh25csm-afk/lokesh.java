
class Addition {
    int x = 10, y = 5;

    void add() {
        int z = x + y;
        System.out.println("Addition Result: " + z);
    }
}

class Subtraction extends Addition {

    void display() {
        int z = x - y;
        System.out.println("Subtraction Result: " + z);
    }

    public static void main(String[] args) {
        Subtraction s = new Subtraction();

        s.add();      
        s.display(); 
    }
}


