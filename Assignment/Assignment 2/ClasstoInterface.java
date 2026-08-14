package inheritance;

interface I1{
	int y = 200;
	void text();
}
class Sample  implements I1{
	int x = 100;
	void add() {
	System.out.println("This is a class ");
	}
	@Override
	public void text() {
	System.out.println("This is the interface");
		
	}
}

public class ClasstoInterface {
	
	  public static void main(String[] args) {
		
	Sample sam = new Sample();
	System.out.println(I1.y);
	System.out.println(sam.x);
	sam.add();
	sam.text();	
	}
}
