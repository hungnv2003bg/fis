package com.example.democrud1.design_patter.command;

public class CloseAccount implements Command {
    private Account account;

    public CloseAccount(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.close();
    }
}
