package inheritance;


class first {
	 int a = 20;
	 int b = 36;
	 
	 void add() {
		 
		 System.out.println("sum of the numbers:" + (a+b+100) );
	 }
	 
	 void mult() {
		 System.out.println("mult"+ (a*2) );
	 }
	}
	 
class second extends first{
	
	int c = 30;
	@Override
	void add() {
		
		System.out.println("sum of the numbers"+(a+b+c));
	}
	//overload
	void mult(int e) {
	
		System.out.println("mult"+ (e*50) );
	}
	
	}
		public class Single {
			 public static void main(String[] args) {
				
 	 second sc = new second();
	 sc.add();
	 sc.mult(35);
	 sc.mult();
			 }	
    }

