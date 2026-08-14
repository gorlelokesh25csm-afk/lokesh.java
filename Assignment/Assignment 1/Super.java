package inheritance;

	class start{
		 int a = 20;
		 int b = 36;
		 
		 void add() {
			 
			 System.out.println("sum of the numbers:" + (a+b+100) );
		 }
		 
		 void mult() {
			
			 System.out.println("mult"+ (a*2) );
		 }
		}
		 
	class end extends start{
		
		int c = 30;
		
		void add() {
			
			System.out.println("sum of the numbers"+(a+b+c));
		}
		void mult(int e) {
		
			System.out.println("mult"+ (e*50) );
		}
		void supercallmethods() {
			super.add();
			super.mult();
		}
	}
	public class Super {
		public static void main(String[] args) {
			end ex = new end();
			ex.supercallmethods();
			ex.add();
			ex.mult(35);
			
		}
	}
