public class Difference {
    int roll;
    char c;
    String name;
    float fee;
    //constructer
    public Difference(int i,char c, String n, float f) {
		this.roll= i;
        this.c=c;
		this.name = n;
		this.fee = f;
	}
    //method
    void method(){
        System.out.println("roll number is:"+roll);
        System.out.println("entered character is:"+c);
        System.out.println("name of the student is:"+name);
        System.out.println("fee is:"+fee);
    }
    public static void main(String args[]){
        System.out.println();
        Difference obj=new Difference(12, 'x',",harsha", 12.21f);
        obj.method();
    }
}
    

