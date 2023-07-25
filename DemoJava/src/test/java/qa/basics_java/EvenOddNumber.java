package qa.basics_java;

import org.testng.annotations.Test;

@Test
public class EvenOddNumber {
    public static void main(String[] args) {
        int number = 5;
        if (number % 2 == 0) {
            System.out.println("number is even");

        } else {
            System.out.println("Number is odd");
        }

        int a = 10;
        int b = 16;
        if (a > b) {
            System.out.println("a is grater");
        } else {
            System.out.println(" b is greater");
        }

/// nested loop
        // if, else if, else
        int day = 2;
        if (day == 1) {
            System.out.println("Sunday");
        } else if (day == 2) {
            System.out.println("Monday");

        } else if (day == 3) {
            System.out.println("Tuesday");
        } else if (day == 4) {
            System.out.println("Wednesday");
        } else if (day == 5) {
            System.out.println("Thursday");
        } else if (day == 6) {
            System.out.println("Friday");
        } else {
            System.out.println("Invalid day");
        }
    }
}

