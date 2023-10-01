package org.example;

public class Account {
    private int accountID;
    private AccountType accountType;
    private int ownerID;
    private int balance;

    public Account(int accountID,AccountType accountType,int ownerID,int balance){
        this.accountID=accountID;
        this.accountType=accountType;
        this.ownerID=ownerID;
        this.balance=balance;
    }




    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
