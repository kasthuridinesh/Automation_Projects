package interviewPrepration.Inheritance;

public class EmployeeDetails {
    public  void sayName(){
        System.out.println("Printing name");
    }
    public void sayAge(){
        System.out.println("printing ages");

    }

    public static void main(String[] args) {
        EmployeeDetails call = new EmployeeDetails();
        call.sayName();
        call.sayAge();

    }
}
