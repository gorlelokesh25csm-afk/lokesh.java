class C2 {
    void display() {
        System.out.println("This is C2");
    }
}

interface I1 {
    void show();
}

// ❌ INVALID CODE
// C2 is a class, so C1 cannot IMPLEMENT C2.
// I1 is an interface, so C1 cannot EXTEND I1.

class C1 implements C2 extends I1 {

    public void show() {
        System.out.println("This is I1");
    }

    public static void main(String[] args) {
        C1 obj = new C1();

        obj.display();
        obj.show();
    }
}
