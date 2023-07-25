package interviewPrepration.constructor;

public class Student5 {
    int age;
    String name;
     int salary;
     Student5(int i , String n){
         age=i;
         name = n;
    }
    Student5(int i,String n,int s){
         age=i;
         name=n;
         salary=s;
    }
    Student5(Student5 s){
        age=s.age;


    }
    void displays(){System.out.println(age+" "+name);}
    public void display(){
        System.out.println(age+""+name+""+salary);
    }

    public static void main(String[] args) {
        Student5 s5= new Student5(12,"ram");
        Student5 s6 = new Student5(15,"setha",200000);
        Student5 s7 = new Student5(s5);
        s7.displays();
        s5.display();
        s6.display();

    }
    /// copy constructor

}

