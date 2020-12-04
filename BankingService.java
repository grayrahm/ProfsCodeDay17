import java.util.LinkedList;

class Customer {
    private String name;
    private int password;
    private LinkedList<Account> accounts;

    public boolean checkName(String name) {
        return this.name.equals(name);
    }

    public boolean checkPassword(int pwd) {
        return this.password == pwd;
    }
}

class Account {
    private int number;
    private Customer owner;
    private double balance;

    public Account(int number) {
        this.number = number;
    }

    public boolean checkNumber(int acctNum) {
        return this.number == acctNum;
    }

    //Getter
    public double getBalance() {
        return this.balance;
    }

    public void withdraw(double amt) {
        this.balance = this.balance - amt;
    }
}

class CheckingAccount extends Account {

    public CheckingAccount(int number) {
        super(number);
    }

    public boolean checkNumber(int number) {
        return super.checkNumber(number);
    }
}

class BankingService {
    IAccountDataStructure accounts;
    ICustDataStructure customers;

    double getBalance(int forAcctNum) throws NullPointerException {
        Account acct = accounts.findByNumber(forAcctNum);
        return acct.getBalance();
    }

    void withdraw(int forAcctNum, double amt) {
        Account acct = accounts.findByNumber(forAcctNum);
        if(!acct.equals(null)) {
            acct.withdraw(amt);
        }
    }

    String login(String custname, int withPwd) {
        Customer cust = customers.findCustomer(custname, withPwd);
        if(!cust.equals(null)) {
            return "Welcome customer!";
        }

        return "Oops -- don't know this customer";
    }

}