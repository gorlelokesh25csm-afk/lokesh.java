package inheritance;

 interface I2{
	 int Z = 305;
	 void sample();
 }
 
 interface I3 extends I2{
	 int Y = 208;
	 void mult();
 }

public class Interfaces implements I2 ,I3  {
	
 @Override
 public void sample() {
	System.out.println("The application is about sample");
	
 }
 
 @Override
 public void mult() {
	 System.out.println("sum of two numbers :" + (Y+Z));
	
 }
 
 public static void main(String[] args) {
	 
	 Interfaces i1 = new Interfaces();
	 System.out.println(I3.Y);
		System.out.println(I2.Z);
		i1.mult();
		i1.sample();
		
 }

}
