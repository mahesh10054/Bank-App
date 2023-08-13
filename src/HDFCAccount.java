import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{
    private String name;

    private String accountNo;

    private String password;

    private double balance;

    final double rateOfInterest = 7.1;

    final String IFSCCode = "HDFC12345";

    public HDFCAccount() {

    }

    public HDFCAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password))
        {
            return "Account Balance is:- "+ this.balance;
        }
        return "Your Password is Wrong";
    }

    @Override
    public String addMoney(double amount) {
        this.balance += amount;
        return "Amount Added Successfully. New Balance is:- "+this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password))
        {
            if(this.balance < amount)
            {
                return "Insufficient Balance";
            }
            this.balance -= amount;
            return "Account Withdraw Successfully. New Balance is:- "+ this.balance;
        }
        return "Your Password is Wrong";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword))
        {
            this.password = newPassword;
            return "Password Change Successfully.";
        }
        return "Your Old Password is Wrong";
    }

    @Override
    public double calculateInterest(int year) {
        return (this.balance*year*rateOfInterest)/100.0;
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
