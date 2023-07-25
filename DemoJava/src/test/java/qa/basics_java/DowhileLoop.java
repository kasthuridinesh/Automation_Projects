package qa.basics_java;

import org.testng.annotations.Test;

public class DowhileLoop {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println(i);
            i++;

        } while (i <= 10);
    }

    // in do while loop 1 time the excution will happen then only it will check the condition
    @Test
    public void example() {
        int i = 20;
        do {
            System.out.println(i);
        } while (i <= 10);


    }
}
