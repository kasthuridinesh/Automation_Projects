package qa.basics_java.constructor;

public class Draw {
    String draw;

    Draw() {
        System.out.println("Draw object created");
    }

    Draw(String toDraw) {
        draw = toDraw;
        System.out.println("Drawing" + toDraw);


    }

    // Constructor Overloaded
    public static void main(String[] args) {
        Draw draw = new Draw();
        Draw draw1 = new Draw("circle");
    }
}
