package qa.basics_java;


public class CollectAmount {
    public Integer collectedAmount = 1000;

    public Integer collectedAmountAndGivenToME() {
        System.out.println("Collected rupees is" + collectedAmount);

        return collectedAmount;
    }

    public static void main(String[] args) {
        CollectAmount myson = new CollectAmount();
        Integer amount = myson.collectedAmountAndGivenToME();
        System.out.println("Amount received" + amount);
    }
}
