package com.example.democrud1.design_patter.factory.factorypattern;

public class KhachHangBank {
    public static void main(String[] args) {
        Bank bank = BankFactory.getBank(Enum.MBBANK);
        System.out.println(bank.getNameBank());
    }
}
