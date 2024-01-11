package com.example.demo.controller;

import com.example.demo.model.request.account.AccountSaveRequest;
import com.example.demo.model.request.account.AccountUpdateRequest;
import com.example.demo.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAccount(@RequestBody AccountSaveRequest accountSaveRequest) {
        return ResponseEntity.ok(accountService.saveAccount(accountSaveRequest));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateAccount(@PathVariable("id") Integer id,
                                           @RequestBody AccountUpdateRequest accountUpdateRequest) {
        return ResponseEntity.ok(accountService.updateAccount(id, accountUpdateRequest));
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
