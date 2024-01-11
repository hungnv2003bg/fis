package com.example.democrud1.design_patter.factory.factorypattern;

public class BankFactory {
    private BankFactory() {
    }

    public static final Bank getBank(Enum bankType) {
        switch (bankType) {

            case TPBANK:
                return new TPBank();

            case MBBANK:
                return new MBBank();

            default:
                throw new IllegalArgumentException("This bank type is unsupported");
        }
    }
}
