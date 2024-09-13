package com.dxc.accountservice.controller;

import com.dxc.accountservice.dto.AccountDtoResponse;
import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import com.dxc.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AccountDtoResponse>> getAccountByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.listarCuentasCliente(customerId));

    }

    @GetMapping("/{id}")
    public Account obtenerCuentaPorId(@PathVariable Long id) {
        return accountService.obtenerCuentaPorId(id);
    }



}
