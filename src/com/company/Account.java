package com.company;

import java.util.ArrayList;

/**
 * Created by mudy on 7/2/2017.
 */
public class Account {
    //Account type name
    private String name;




    //Account Unique Id
    private String uuid;


    //Account holder name from user class
    private User holder;

    //List of Transaction of this Account
    private ArrayList<Transaction> transaction;


    //Account Construtor
    public  Account(String name, User holder, Bank theBank)
    {
        //set account name and holder
        this.name = name;
        this.holder = holder;

        //get new account UUID
        this.uuid = theBank.getNewAccountUUID();

        // init list of transaction
        this.transaction = new ArrayList<Transaction>();



    }

    public String getUUID()
    {
        return  this.uuid;
    }
}
