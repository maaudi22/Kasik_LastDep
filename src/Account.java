public class Account extends Helper{
    double oldBalance;
    double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
        this.oldBalance = balance;
    }

    public void showBalance(){
        System.out.println("Guthaben: " + colorGreen + this.balance + "$" + colorDefault);
    }


}
