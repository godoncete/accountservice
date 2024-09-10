package com.dxc.accountservice.controller;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import com.dxc.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping
    @RequestMapping("/{id}")
    public Account obtenerCuentaPorId(@PathVariable Long id) {
        return accountService.obtenerCuentaPorId(id);
    }

    @PostMapping
    @RequestMapping
    public Account crearCuenta(@PathVariable Account account) {
        return accountService.crearCuenta(account);
    }

    @PutMapping
    @RequestMapping
    public Account actualizarCuenta(@PathVariable Account account) {
        return accountService.actualizarCuenta(account);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public boolean eliminarCuenta(@PathVariable Long id) {
        return accountService.eliminarCuenta(id);
    }

    @PostMapping
    @RequestMapping("/{account}/{amount}/{customer}")
    public boolean addMoneyToBalance(@PathVariable Account account, @PathVariable int amount, @PathVariable Customer customer) {
        return accountService.addMoneyToBalance(account, amount, customer);
    }

    @GetMapping
    @RequestMapping("rest/{account}/{amount}/{customer}")
    public boolean restMoneyToBalance(@PathVariable Account account, @PathVariable int amount, @PathVariable Customer customer) {
        return accountService.addMoneyToBalance(account, amount, customer);
    }

    @DeleteMapping
    @RequestMapping("/{customer}")
    public boolean eliminarCuentasPorCliente(@PathVariable Customer customer){
        return accountService.eliminarCuentasPorCliente(customer);
    }


}
