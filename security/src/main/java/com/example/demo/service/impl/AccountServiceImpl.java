package com.example.demo.service.impl;

import com.example.demo.entity.Accounts;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.model.reponse.AccountReponse;
import com.example.demo.model.request.account.AccountSaveRequest;
import com.example.demo.model.request.account.AccountUpdateRequest;
import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final AccountMapper accountMapper;

    @Override
    public List<AccountReponse> getAccounts() {
        List<Accounts> accounts = accountRepo.findAll();
        return accounts.stream().map(accountMapper::toAccountReponse).toList();
    }

    @Override
    public List<AccountReponse> deleteAccount(Integer id) {
        accountRepo.deleteById(id);
        return getAccounts();
    }

    @Override
    public AccountReponse getAccount(Integer id) {
        Optional<Accounts> optionalAccounts = accountRepo.findById(id);
        return accountMapper.toAccountReponse(optionalAccounts.get());
    }

    @Override
    public AccountReponse saveAccount(AccountSaveRequest accountSaveRequest) {
        Accounts accounts = accountMapper.toAccount(accountSaveRequest);
        accountRepo.save(accounts);
        return accountMapper.toAccountReponse(accounts);
    }

    @Override
    public AccountReponse updateAccount(Integer id, AccountUpdateRequest accountUpdateRequest) {
        Optional<Accounts> accountsOptional = accountRepo.findById(id);
        Accounts accounts = accountsOptional.get();
        Accounts accountsUpdate = accountMapper.toAccount(accountUpdateRequest);
        accounts.setUsername(accountsUpdate.getUsername());
        accounts.setPassword(accountsUpdate.getPassword());
        accounts.setEmail(accountsUpdate.getEmail());
        accounts.setFullname(accountsUpdate.getFullname());
        accounts.setRole(accountsUpdate.getRole());
        return accountMapper.toAccountReponse(accounts);
    }
}
