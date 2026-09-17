import java.util.Scanner;
public class PrimePalindrome{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        int x = s.nextInt();
        int y = x;
        int r=0;
        while(y>0){
            r=(r*10)+(y%10);
            y=y/10;
        }
        boolean prime=true;
        boolean palin=false;
        if(r==x)
            palin=true;
        for(int i=2;i<=x/2;i++){
            if (x%i==0){
                prime=false;
                break;
            }
        }
        if(prime && palin)
          System.out.println("Given number is a PrimePalindrome");
        else
            System.out.println("Given number is Not PrimePalindrome");
    }
}
