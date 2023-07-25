package interviewPrepration.polymorphisum;

public class AnimalColour {
    String color = "white";
}
class Dog extends AnimalColour{
    String color = "black";
    void displayColor(){
        System.out.println(color);
        System.out.println(super.color);

    }
}
class Colors{
    public static void main(String[] args) {
        Dog d = new Dog();
        d.displayColor();
    }
}
