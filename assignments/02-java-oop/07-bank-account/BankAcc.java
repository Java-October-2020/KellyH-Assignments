import java.util.Random;

public class BankAcc{
    String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    static int numberAccounts = 0;
    private double acctTotal = savingsBalance + checkingBalance;

    public BankAcc(){
        this.accountNumber = randAccNum();
        numberAccounts++;
    }

    public static int numAccounts(){
        return BankAcc.numberAccounts;
    }

    private static String randAccNum(){
        String accNum = "";
        Random num = new Random();
        for (int i = 0; i < 10; i++) {
            int r = num.nextInt(9);
            accNum += Integer.toString(r);
        }
        return accNum;
    }
    public static String getAccNum(){
        String number = randAccNum();
        System.out.println(number);
        return number;
    }

    public double getChkBal(){
        return this.checkingBalance;
    }

    public double getSavBal(){
        return this.savingsBalance;
    }

    public void addTo(double amount, String acct){
        if (acct.toString() == "savings") {
            this.savingsBalance += amount;
            this.acctTotal += amount;
            System.out.println("added " + amount + " to savings \n");
        }

        else if (acct.toString() == "checking") {
            this.checkingBalance += amount;
            this.acctTotal += amount;
            System.out.println("added " + amount + " to checking \n");

        }

        else {
            System.out.println("Please select either cheking or savings account");
        }
    }

    public void withdrawFrom(double amount, String acct){
        if (acct == "savings" && this.savingsBalance >= amount) {
            this.savingsBalance -= amount;
            this.acctTotal -= amount;
        }
        else if (acct == "savings" && this.savingsBalance < amount) {
            System.out.println("insufficient funds in savings");
        }

        else if (acct == "checking" && this.checkingBalance >= amount) {
            this.checkingBalance -= amount;
            this.acctTotal -= amount;
        }
        else if (acct == "checking" && this.checkingBalance < amount) {
            System.out.println("insufficient funds in checking");
        }

        else if(acct != "savings" || acct != "checking") {
            System.out.println("Please select either cheking or savings account");
        }
    }

    public void checkTotal(){
        System.out.println("Total: " + this.acctTotal + "\n" + "total in savings: " + this.savingsBalance + "\n" + "total in checking " + this.checkingBalance);
    }

    public static void main(String[] args) {
        BankAcc test = new BankAcc();
        test.addTo(1000, "savings");
        test.addTo(200000, "checking");
        test.withdrawFrom(30000, "checking");
        test.checkTotal();
        

    }
}