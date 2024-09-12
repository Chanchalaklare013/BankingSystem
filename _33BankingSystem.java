//Account.java /first step
 interface Account
{
    void deposit(double amount);
    void withdrow(double amount);
    double getBalance();
}
//Bank Account 
 abstract class BankAccount implements Account
{
    protected double balance;

    protected BankAccount(double initialBalance)
    {
       this.balance = initialBalance;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void withdrow(double amount)
    {
        balance -= amount;
    }

    public double getBalance()
    {
        return balance;
    }
}  
 class SavingsAccount extends BankAccount 
{
    private final double interestRate;

    public SavingsAccount(double initialBalance, double interestRate)
    {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest()
    {
        double interest = balance * interestRate;
        deposit(interest);
    } 
}
 class CheckingAccount extends BankAccount
{
    private static final double TRANSACTION_FEE = 1.00;

    public CheckingAccount(double amount)
    {
         super(amount);
        if(amount + TRANSACTION_FEE > balance)
        {
          //System.out.println("Insfficient balance. withdrowal cancelled.");
        }
        else
        {
            balance -= (amount + TRANSACTION_FEE);
        }
    }
}
public class _33BankingSystem 
{
    public static void main(String []args)
    {
        //creat a saving account object
        
        SavingsAccount SA=new SavingsAccount(5000, 0.5);
        System.out.println("Initial saving account balance: rs " + SA.getBalance());
        //add interest in Saving account
        SA.addInterest();
        
        // checking class object 
        CheckingAccount CA = new CheckingAccount(1000);
        System.out.println("Balance after adding interest: " + CA.getBalance());
        //System.out.println("initial Checking Account Balance: "+CA.getBalance);
        CA.withdrow(100);
       // CA.withdrow(400);
        System.out.println("Balance after withdrawals: " + CA.getBalance());

    }    

}
