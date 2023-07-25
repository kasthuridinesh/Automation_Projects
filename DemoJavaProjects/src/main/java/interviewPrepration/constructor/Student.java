package interviewPrepration.constructor;
// parameterized constructor
public class Student {
    int age;
    String name;

    Student(int i, String n) {
        age=i;
        name=n;

    }

    void display() {
        System.out.println(age + "" + name);
    }

    public static void main(String[] args) {
        Student st1 = new Student(25, "kasthuri");
        Student st2 = new Student(31, "dinesh");
        st1.display();
        st2.display();
    }
}