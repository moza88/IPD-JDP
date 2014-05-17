package edu.depaul.ipd.jdp.jdbc;


public class Account {

    private int accountNumber;
    private double balance;
    private String name;

    public Account() {
    }

    public Account(int acctNbr) {
        this.accountNumber = acctNbr;
    }

    public Account(int acctNbr, double balance) {
        this.accountNumber = acctNbr;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void withdraw(double amt) {
        balance -= amt;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInitialBalance(double initBalance) {
        this.balance = initBalance;
    }
    
    @Override
    public String toString() {
        return "id[" + accountNumber +"] name["+name+"] balance[" + balance + "]";
    }
}
