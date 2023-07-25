package interviewPrepration.polymorphisum;

public class Vehicle {
    void run(){
        System.out.println("vehicle is running");
    }
}
 class Bike extends Vehicle {
    void run(){
        System.out.println("bike is running");
    }


}
class MethodOverRidding{
    public static void main(String[] args) {
        Bike b = new Bike();
        b.run();
    }
}
