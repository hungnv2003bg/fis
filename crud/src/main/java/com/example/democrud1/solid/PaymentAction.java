package com.example.democrud1.solid;

public interface PaymentAction {
    boolean checkProductExist();

    boolean checkBalance();

    void pay();
}
