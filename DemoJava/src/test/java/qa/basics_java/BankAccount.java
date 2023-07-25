package qa.basics_java;


public class BankAccount {


    Long accountNumber = 123456789012L;
    String accountHolder = "kasthuri";
    int accountBalance = 3000;

    public void getBalance() {
        System.out.println("Balance is " + accountBalance);
    }

    public void getCustomerName() {
        System.out.println("Customer name is " + accountHolder);

    }

    public void getAccountNumber() {
        System.out.println("Account number is" + accountNumber);
    }


    public static void main(String[] args) {
        // Craeting object for class
        BankAccount account = new BankAccount();
        account.getBalance();
        account.getCustomerName();
        account.getAccountNumber();
    }
}

