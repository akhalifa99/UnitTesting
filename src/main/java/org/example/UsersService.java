package org.example;

import net.bytebuddy.implementation.bytecode.Throw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UsersService {
    public List<User> users = new ArrayList<>();


    public UsersService() {
        this.users.add(new User(1, "user1@gmail.com","12345678"));
    }

    public boolean Login(String email, String password) throws NotValidMailException {

        Scanner sc = new Scanner(System.in);
        for (User user:users
             ) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                System.out.println("Logged in successfully");
                return true;
            } else if (user.getEmail().equals(email) && !user.getPassword().equals(password)) {
                System.out.println("Enter correct password");

                //password = sc.nextLine();
                Login(email,password);
                return false;

            }
        }
        System.out.println("User does not exist");
        SignUp(email,password);
        return false;
    }

    public void SignUp(String email, String password) throws NotValidMailException {
        boolean exists=false;
        Scanner sc = new Scanner(System.in);


        if(users!=null){
        for (User user:users
        ) {
            if (user.getEmail().equals(email)){
                exists=true;
                System.out.println("user already exists");
                break;
            }
        }}

        while (exists){
            exists = false;
            System.out.println("Enter an email address");
            email = sc.nextLine();
            for (User user:users
            ) {
                if (user.getEmail().equals(email)){
                    exists=true;
                    System.out.println("user already exists");
                    break;
                }
            }
        };
        if (!ValidEmail(email))
            throw new NotValidMailException("Email is not valid");
        //System.out.println("Enter a new password");
        User user = new User(this.users.size()+1,email,password);
        users.add(user);
    }
    public int withDraw(User user,int AccountID,int amount) throws CannotFindAccount, NoAvailableBlance {
         Account account=ValidAccount(user,AccountID);
         if(account.getBalance()<amount)
             throw new NoAvailableBlance("No available balance");
         else
             account.setBalance(account.getBalance()-amount);
         return account.getBalance();




    }
    public int deposit(User user,int AccountID,int amount) throws CannotFindAccount {
        Account account=ValidAccount(user,AccountID);
        account.setBalance(account.getBalance()+amount);
        return account.getBalance();
    }

    public boolean ValidEmail(String email){
        System.out.println(email);
        return Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").
                matcher(email).matches();
    }
    public Account ValidAccount(User user,int accountID) throws CannotFindAccount {
        for (Account account:user.getUserAccounts()){
            if(account.getAccountID()==accountID){
                return account;
            }
        }
         throw new CannotFindAccount("Account does not exist");
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
