package interviewPrepration.Inheritance;
// multilevel inheritance
public class Animal {
    void eat(){
        System.out.println("eat veg and non-veg");

    }}
    class Dog extends Animal{
        void sound(){
            System.out.println("bow , bow");
        }
        void walk(){
            System.out.println("wailing in the roof top");
        }
    }
    class cat extends Dog{
        void drink(){
            System.out.println(" cal drinks milk");

        }
    }
   class testInheritance{
    public static void main(String[] args) {
        cat c = new cat();
        Dog d = new Dog();
        c.eat();
        c.sound();
        c.walk();
        c.drink();
        d.sound();
        d.eat();
        d.walk();
    }

    }

