package com.example.democrud1.design_patter.command;

public class Client {

    public static void main(String[] args) {
        Account account = new Account("hungnv");

        Command open = new OpenAccount(account);
        Command close = new CloseAccount(account);
        BankApp bankApp = new BankApp(open, close);

        bankApp.clickOpenAccount();
        bankApp.clickCloseAccount();
    }
}