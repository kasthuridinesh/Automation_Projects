package interviewPrepration.Inheritance;

public class Animal2 {
    void Sleep() {
        System.out.println("animal ia sleeping in the mid night");
    }
}

class Dogs extends Animal2 {
    void eat() {
        System.out.println("dog eats non veg");
    }

}

class Cats extends Animal2 {
    void drink() {
        System.out.println("cat drink milk");
    }
}

class testInheritances {
    public static void main(String[] args) {
        Dogs d1 = new Dogs();
        Cats c1 = new Cats();
        c1.drink();
        c1.Sleep();
        d1.eat();
        d1.Sleep();
    }




}