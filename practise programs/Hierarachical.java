class A{
    int a=21;
    void method1(){
        System.out.println("output from class A="+(this.a+20));
    }
}
class B extends A{
    int z=12;
    void method2(){
        System.out.println("output from class B="+("z+20"));
    }

}
class C extends A{
    void method3(){
        System.out.println("output from class C="+(super.a));
    }
}
 class Hierarchical {
    public static void main(String args[]){
        System.out.println("hello");
        B obj=new B();
        obj.method1();
        obj.method2();
        C obj1=new C();
        obj1.method3();
        obj1.method1();
    }
}
