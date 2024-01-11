package com.example.democrud1.solid;

import org.hibernate.resource.transaction.spi.TransactionStatus;

public class BankPayment extends Payment {
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
//        BankApiConnection bankApiConnection = getBankApiConnection();
//        if (!bankApiConnection.validateAccount(user)) {
//            throw new PaymentException("Thong tin khong hop le");
//        }
//        if (!bankApiConnection.hasSufficientFunds(user, balance)) {
//            throw new PaymentException("tai khoan het tien");
//        }
//        TransactionStatus status = bankApiConnection.makePayment(user, recipientAccount, balance);
//        if (status == TransactionStatus.SUCCESS) {
//            System.out.println("thanh toan thanh cong");
//        } else {
//            throw new PaymentException("THanh toan that bai " + status);
//        }
    }
}
