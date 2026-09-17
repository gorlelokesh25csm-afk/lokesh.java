import java.util.Scanner;

/**
 * Student Utility Program
 * Demonstrates:
 * 1. Variables and data types
 * 2. Input and output
 * 3. Conditional statements
 * 4. Loops
 * 5. Parameterized methods
 */public class StudentUtilityProgram {

    // ---------------- METHODS ----------------

    /**
     * Returns the factorial of a number.
     */
    public static long factorial(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;
    }

    /**
     * Checks whether a number is prime.
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the maximum of two numbers.
     */
    public static int maximum(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Calculates the area of a circle.
     */
    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    /**
     * Displays the grade based on percentage.
     */
    public static void displayGrade(double percentage) {
        if (percentage >= 90) {
            System.out.println("Grade: A+");
        } else if (percentage >= 80) {
            System.out.println("Grade: A");
        } else if (percentage >= 70) {
            System.out.println("Grade: B");
        } else if (percentage >= 60) {
            System.out.println("Grade: C");
        } else if (percentage >= 50) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }

    // ---------------- MAIN METHOD ----------------

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Part A: Student Information
        System.out.println("========== STUDENT INFORMATION ==========");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();

        System.out.print("Enter marks in Subject 1: ");
        double mark1 = sc.nextDouble();

        System.out.print("Enter marks in Subject 2: ");
        double mark2 = sc.nextDouble();

        System.out.print("Enter marks in Subject 3: ");
        double mark3 = sc.nextDouble();

        double total = mark1 + mark2 + mark3;
        double percentage = total / 3;

        System.out.println("\n========== STUDENT RESULT ==========");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage : " + percentage + "%");

        displayGrade(percentage);

        // Menu-driven program
        int choice;

        do {
            System.out.println("\n========== STUDENT UTILITY MENU ==========");
            System.out.println("1. Check Even or Odd");
            System.out.println("2. Find Largest of Three Numbers");
            System.out.println("3. Display Grade");
            System.out.println("4. Display Day of the Week");
            System.out.println("5. Multiplication Table");
            System.out.println("6. Display Numbers from 1 to N");
            System.out.println("7. Sum of First N Natural Numbers");
            System.out.println("8. Fibonacci Series");
            System.out.println("9. Factorial");
            System.out.println("10. Check Prime Number");
            System.out.println("11. Maximum of Two Numbers");
            System.out.println("12. Area of Circle");
            System.out.println("13. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Even or Odd
                    System.out.print("Enter a number: ");
                    int number = sc.nextInt();

                    if (number % 2 == 0) {
                        System.out.println(number + " is Even.");
                    } else {
                        System.out.println(number + " is Odd.");
                    }
                    break;

                case 2:
                    // Largest of three numbers
                    System.out.print("Enter three numbers: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int c = sc.nextInt();

                    int largest;

                    if (a >= b && a >= c) {
                        largest = a;
                    } else if (b >= a && b >= c) {
                        largest = b;
                    } else {
                        largest = c;
                    }

                    System.out.println("Largest number = " + largest);
                    break;

                case 3:
                    // Grade based on percentage
                    System.out.print("Enter percentage: ");
                    double p = sc.nextDouble();

                    displayGrade(p);
                    break;

                case 4:
                    // Day using switch
                    System.out.print("Enter day number (1-7): ");
                    int day = sc.nextInt();

                    switch (day) {
                        case 1:
                            System.out.println("Monday");
                            break;
                        case 2:
                            System.out.println("Tuesday");
                            break;
                        case 3:
                            System.out.println("Wednesday");
                            break;
                        case 4:
                            System.out.println("Thursday");
                            break;
                        case 5:
                            System.out.println("Friday");
                            break;
                        case 6:
                            System.out.println("Saturday");
                            break;
                        case 7:
                            System.out.println("Sunday");
                            break;
                        default:
                            System.out.println("Invalid day number.");
                    }
                    break;

                case 5:
                    // Multiplication table
                    System.out.print("Enter a number: ");
                    int tableNumber = sc.nextInt();

                    for (int i = 1; i <= 10; i++) {
                        System.out.println(
                            tableNumber + " x " + i +
                            " = " + (tableNumber * i)
                        );
                    }
                    break;

                case 6:
                    // Numbers from 1 to N
                    System.out.print("Enter N: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;

                case 7:
                    // Sum of first N natural numbers
                    System.out.print("Enter N: ");
                    int limit = sc.nextInt();

                    int sum = 0;

                    for (int i = 1; i <= limit; i++) {
                        sum += i;
                    }

                    System.out.println(
                        "Sum of first " + limit +
                        " natural numbers = " + sum
                    );
                    break;

                case 8:
                    // Fibonacci series
                    System.out.print("Enter number of terms: ");
                    int terms = sc.nextInt();

                    int first = 0;
                    int second = 1;

                    System.out.println("Fibonacci Series:");

                    for (int i = 1; i <= terms; i++) {
                        System.out.print(first + " ");

                        int next = first + second;
                        first = second;
                        second = next;
                    }

                    System.out.println();
                    break;

                case 9:
                    // Factorial using method
                    System.out.print("Enter a number: ");
                    int factNumber = sc.nextInt();

                    if (factNumber < 0) {
                        System.out.println(
                            "Factorial is not defined for negative numbers."
                        );
                    } else {
                        System.out.println(
                            "Factorial = " + factorial(factNumber)
                        );
                    }
                    break;

                case 10:
                    // Prime number using method
                    System.out.print("Enter a number: ");
                    int primeNumber = sc.nextInt();

                    if (isPrime(primeNumber)) {
                        System.out.println(
                            primeNumber + " is a Prime Number."
                        );
                    } else {
                        System.out.println(
                            primeNumber + " is not a Prime Number."
                        );
                    }
                    break;

                case 11:
                    // Maximum of two numbers using method
                    System.out.print("Enter two numbers: ");
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    System.out.println(
                        "Maximum = " + maximum(x, y)
                    );
                    break;

                case 12:
                    // Area of circle using method
                    System.out.print("Enter radius: ");
                    double radius = sc.nextDouble();

                    System.out.println(
                        "Area of Circle = " + circleArea(radius)
                    );
                    break;

                case 13:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 13);

        sc.close();
    }
}

Explanation of the Program
Part A — Java Basics

The program accepts:

Student name using String

Roll number using int

Marks using double

The total and percentage are calculated using arithmetic operators.

double total = mark1 + mark2 + mark3;
double percentage = total / 3;


Input is obtained using the Scanner class.

Scanner sc = new Scanner(System.in);
String name = sc.nextLine();
int rollNumber = sc.nextInt();

Part B — Conditional Statements

The program demonstrates both if-else and switch.

For example, even/odd checking uses the modulus operator:

if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}


The switch statement is used to identify the day:

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    // ...
}

Part C — Loops

A for loop is used for the multiplication table:

for (int i = 1; i <= 10; i++) {
    System.out.println(tableNumber * i);
}


It is also used for the Fibonacci series:

int first = 0;
int second = 1;

for (int i = 1; i <= terms; i++) {
    System.out.print(first + " ");

    int next = first + second;
    first = second;
    second = next;
}

Part D — Parameterized Methods

Each required method accepts parameters and returns a result.

public static int maximum(int a, int b) {
    return (a > b) ? a : b;
}


Example method call:

int result = maximum(25,
