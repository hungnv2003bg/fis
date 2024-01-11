package com.example.democrud1.solid;

public class MomoPayment extends Payment {
    @Override
    public boolean checkProductExist() {
        return false;
    }

    @Override
    public boolean checkBalance() {
        return false;
    }

    @Override
    public void pay() {

    }
}
