package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userID;
    private String email;
    private String password;
    private  List<Account> userAccounts = new ArrayList<>();



    public User(int userID, String email, String password){
        this.userID=userID;
        this.email=email;
        this.password=password;
        this.userAccounts.add(new Account(this.userAccounts.size()+1,AccountType.CURRENT,this.userID,200));
        this.userAccounts.add(new Account(this.userAccounts.size()+1,AccountType.SAVINGS,this.userID,1000));
    }
    public void openNewAccount(AccountType accountType,int balance){
        this.userAccounts.add(new Account(this.userAccounts.size()+1,accountType,userID,balance));
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getUserID() {
        return userID;
    }

    public List<Account> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<Account> userAccounts) {
        this.userAccounts = userAccounts;
    }
}


