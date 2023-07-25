package qa.basics_java;

import org.testng.annotations.Test;

public class ForLoop {
    public static void main(String[]args){
        for (int i = 1;i<=10;i++){
            System.out.println(i);
        }
    }

    /// print 9in decending order
    @Test
    public void decendingOrder(){
        for (int i = 10; i>=0;i--){
            System.out.println(i);
        }
    }
}
