package com.example.democrud1.design_patter.command;

public class OpenAccount implements Command {
    private Account account;

    public OpenAccount(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.open();
    }
}
