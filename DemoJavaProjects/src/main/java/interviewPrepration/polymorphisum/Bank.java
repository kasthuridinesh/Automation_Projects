package interviewPrepration.polymorphisum;

public class Bank {
    int interestRate(){
        return 0;
    }

}
class AxicBank extends  Bank{
    int interestRate(){
        return 8;
    }
}
class ICICBank extends Bank{
    int interestRate(){
        return 9;
    }
}
class AllBankInterest{
    public static void main(String[] args) {
        AxicBank a= new AxicBank();
        ICICBank i = new ICICBank();
        System.out.println(a.interestRate());
        System.out.println(i.interestRate());


    }

}
