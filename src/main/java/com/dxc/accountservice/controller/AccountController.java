package com.dxc.accountservice.controller;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import com.dxc.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @GetMapping
    public List<Account> listarCuentas() {
        return accountService.listarCuentas();
    }

    @GetMapping("/{id}")
    public Account obtenerCuentaPorId(@PathVariable Long id) {
        return accountService.obtenerCuentaPorId(id);
    }



}
