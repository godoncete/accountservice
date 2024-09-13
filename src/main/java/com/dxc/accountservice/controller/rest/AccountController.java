package com.dxc.accountservice.controller.rest;

import com.dxc.accountservice.dto.AccountDtoRequest;
import com.dxc.accountservice.dto.AccountDtoResponse;
import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import com.dxc.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{accountId}/{customerId}")
    public AccountDtoResponse obtenerCuentaPorId(@PathVariable Long accountId, @PathVariable Long customerId) {
        return accountService.getByAccountIdAndCustomerId(accountId,customerId);
    }

    @PostMapping
    public AccountDtoResponse crearCuenta(@Valid @RequestBody AccountDtoRequest account) {
        return accountService.crearCuenta(account);
    }

    @PutMapping("/{accountId}"  )
    public ResponseEntity<AccountDtoResponse> actualizarCuenta(@PathVariable Long accountId,
                                                               @Valid @RequestBody AccountDtoRequest account) {
        return ResponseEntity.ok(accountService.actualizarCuenta(account, accountId));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Boolean> eliminarCuenta(@PathVariable Long customerId) {
        return  ResponseEntity.ok(accountService.eliminarCuenta(customerId));
    }

    @PostMapping("/add-money")
    public AccountDtoResponse addMoneyToBalance(@Valid @RequestBody AccountDtoRequest accountDtoRequest) {
        return accountService.crearCuenta(accountDtoRequest);
    }
}
