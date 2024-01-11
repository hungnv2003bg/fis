package com.example.democrud1.solid;

public abstract class Payment implements PaymentAction {

    protected void payment() {
        checkProductExist();
        checkBalance();
        pay();
    }
}
