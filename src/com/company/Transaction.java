package com.company;

import java.util.Date;

/**
 * Created by mudy on 7/2/2017.
 */
public class Transaction {
//    Transaction Amount
    private  double amount;

//    Transaction time
    private Date timestamp;

//    Transaction discription
    private String memo;

//    Transaction account
    private Account inAccount;


    public  Transaction (double amount, Account inAccount){
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
    }

    public  Transaction(double amount, String memo , Account inAccount){
        this(amount,inAccount);

        this.memo = memo;
    }
}
