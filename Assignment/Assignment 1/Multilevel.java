package inheritance;

class one{
	 int a = 20;
	 int b = 36;
	 
	 void add() {
		 
		 System.out.println("sum of the numbers:" + (a+b+100) );
	 }
	 
	 void mult() {
		
		 System.out.println("mult"+ (a*2) );
	 }
	}
	 
class two extends one{

	int c = 30;
	
	void add() {
		
		System.out.println("sum of the numbers"+(a+b+c));
	}
	void mult(int e) {
	
		System.out.println("mult"+ (e*50) );
	}
	
}
class three extends one {
	void mult(int d) {
		System.out.println("mult"+ (a*b*2));
	}
}
public class Multilevel {
 public static void main(String[] args) {
	two kc = new two();
	kc.mult(5);
	kc.mult();

	
}
}
