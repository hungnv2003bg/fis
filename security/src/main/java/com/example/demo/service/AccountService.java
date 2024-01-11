package com.example.demo.service;

import com.example.demo.model.reponse.AccountReponse;
import com.example.demo.model.request.account.AccountSaveRequest;
import com.example.demo.model.request.account.AccountUpdateRequest;

import java.util.List;

public interface AccountService {
    List<AccountReponse> getAccounts();

    List<AccountReponse> deleteAccount(Integer id);

    AccountReponse getAccount(Integer id);

    AccountReponse saveAccount(AccountSaveRequest accountSaveRequest);

    AccountReponse updateAccount(Integer id, AccountUpdateRequest accountUpdateRequest);
}
