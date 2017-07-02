package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by mudy on 7/2/2017.
 */
public class User {
    //User first name
    private String firstName;

    //User last name
    private String lastName;


    //User Unique Id
    private String uuid;


    //User Pin number
    private byte pinHash[];

    //Ist of acounts of this User
    private ArrayList<Account> accounts;

//    Construtor of user class

    public User (String firstName, String lastName , String pin , Bank theBank)
    {
        // value initilzie of parametre
        this.firstName = firstName;
        this.lastName = lastName;

        //for pin security we will use MassageDigest class
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        }catch(NoSuchAlgorithmException e) {
            System.err.println("error, NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //for genrate unique id
        this.uuid = theBank.getNewUserUUID();

        // create list of account Array
        this.accounts = new ArrayList<Account>();

        //print log message
        System.out.printf("New user %s, %s with ID %s created.\n",lastName,firstName,this.uuid);
        }

        public  void addAccount (Account anAcct)
        {this.accounts.add(anAcct);}

        public  String getUUID() {
        return this.uuid;
        }

        public boolean validatePin(String aPin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        }catch (NoSuchAlgorithmException e )
        {
            System.err.println("error, caugh NoSuchAlgoriException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
        }
    }

