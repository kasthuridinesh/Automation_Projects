package interviewPrepration.Inheritance;

public class Employee {
    float Salary=100000;
}

   class organization extends Employee{
        String employeeName="ram";

    public static void main(String[] args) {
        organization emp = new organization();
        System.out.println(emp.employeeName);
        System.out.println(emp.Salary);
    }

}
