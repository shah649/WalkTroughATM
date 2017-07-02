package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mudy on 7/2/2017.
 */
public class Bank {

    private  String name;
    private ArrayList<User> user;
    private  ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.user = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }


    // Generate the number and check this is unique or not
    public String getNewUserUUID()
    {
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique = false;
     // loop contniou check the duplication
        do {

            uuid = "";
            for(int c = 0 ; c < len; c++ ){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            nonUnique = false;
            for (User u : this.user) {
            if(uuid.compareTo(u.getUUID()) == 0){
                nonUnique = true;
                break;
            }
            }
        }while (nonUnique);


        return uuid;
    }
    public String getNewAccountUUID()
    {
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique = false;
        // loop contniou check the duplication
        do {

            uuid = "";
            for(int c = 0 ; c < len; c++ ){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            nonUnique = false;
            for (Account a : this.accounts) {
                if(uuid.compareTo(a.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }
        }while (nonUnique);


        return uuid;
    }

    public  void addAccount (Account anAcct)
    {this.accounts.add(anAcct);}

    public User addUser(String firstname, String lastName , String pin)
    {
        User newUser = new User(firstname,lastName,pin,this);
        this.user.add(newUser);

        Account newAccpunt = new Account("Savings",newUser,this);

        newUser.addAccount(newAccpunt);
        this.addAccount(newAccpunt);

        return  newUser;
    }

    public User userLogin(String userID , String pin){
        for(User u : this.user){

            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin))
            {return  u;}
        }
        return  null;
    }
}
