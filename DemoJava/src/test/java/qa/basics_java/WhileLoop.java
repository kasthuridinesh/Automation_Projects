package qa.basics_java;

import org.testng.annotations.Test;

/// intialization condtion increment value
public class WhileLoop {
    /// printing 1 to 10
    @Test

    public static void main(String[] args) {
        int index = 1;
        // print 1 to 10
        while (index <= 10) {
            System.out.println("printing value of i:" + index);
            index++;
        }

    }

    // print even number between1 to 10
    @Test
    public void evenNumbers() {
        int index = 2;
        while (index <= 10) {
            System.out.println("printing value of i:" + index);
            index = index + 2;// index+=2(shortcut method to increment)
        }
    }

    @Test
    /// printing nimbers in decending order
    public void decendingNumbers() {
        int index = 10;
        while (index >= 0) {
            System.out.println("printing value of i:" + index);
            index--;// index+=2(shortcut method to increment)
        }

    }
}

