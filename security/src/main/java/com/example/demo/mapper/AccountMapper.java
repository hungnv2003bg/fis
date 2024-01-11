package com.example.demo.mapper;

import com.example.demo.entity.Accounts;
import com.example.demo.model.reponse.AccountReponse;
import com.example.demo.model.request.account.AccountSaveRequest;
import com.example.demo.model.request.account.AccountUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Accounts toAccount(AccountSaveRequest accountSaveRequest) {
        Accounts accounts = new Accounts();
        accounts.setId(accountSaveRequest.getId());
        accounts.setEmail(accountSaveRequest.getEmail());
        accounts.setPassword(accountSaveRequest.getPassword());
        accounts.setFullname(accountSaveRequest.getFullname());
        accounts.setUsername(accountSaveRequest.getUsername());
        accounts.setRole(accountSaveRequest.getRole());
        return accounts;
    }

    public Accounts toAccount(AccountUpdateRequest accountUpdateRequest){
        Accounts accounts = new Accounts();
        accounts.setEmail(accountUpdateRequest.getEmail());
        accounts.setPassword(accountUpdateRequest.getPassword());
        accounts.setFullname(accountUpdateRequest.getFullname());
        accounts.setUsername(accountUpdateRequest.getUsername());
        accounts.setRole(accountUpdateRequest.getRole());
        return accounts;
    }

    public AccountReponse toAccountReponse(Accounts accounts){
        AccountReponse accountReponse = new AccountReponse();
        accountReponse.setId(accounts.getId());
        accountReponse.setUsername(accounts.getUsername());
        accountReponse.setPassword(accounts.getPassword());
        accountReponse.setEmail(accounts.getEmail());
        accountReponse.setFullname(accounts.getFullname());
        accountReponse.setRole(accounts.getRole());
        return accountReponse;
    }
}
