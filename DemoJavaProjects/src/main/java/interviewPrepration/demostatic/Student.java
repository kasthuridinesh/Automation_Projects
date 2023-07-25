package interviewPrepration.demostatic;

import org.openqa.selenium.json.JsonOutput;

public class Student {
    int rollNumber;
    String name;
    String subject;
    static  String collegeName = "IIT";
    Student(int i, String n, String s){
        rollNumber=i;
        name=n;
        subject=s;
    }
    void display(){
        System.out.println("rollNumber is:"+rollNumber+" "+"name is:  "+name+" "+"subject is:"+subject+" "+collegeName);
    }

    public static void main(String[] args) {
        Student s1= new Student(101,"ram","maths");
        s1.display();
    }

}
