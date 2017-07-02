package com.company;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
	// init Scanner

        Scanner sc = new Scanner(System.in);

    // init Bank
        Bank theBank = new Bank("The Smart Bank");

    // add a user

        User aUser = theBank.addUser("shah","syed", "1234");

        //Account

        Account newAccount = new Account("checking", aUser,theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);
    }
}
