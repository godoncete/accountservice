package com.dxc.accountservice.controller.rest;

import com.dxc.accountservice.dto.AccountDtoRequest;
import com.dxc.accountservice.dto.AccountDtoResponse;
import com.dxc.accountservice.dto.AddAmountBalanceDto;
import com.dxc.accountservice.dto.RestMoneyBalanceDto;
import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import com.dxc.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/account")
@Validated
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AccountDtoResponse>> getAccountByCustomer(@Positive @PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.listarCuentasCliente(customerId));
    }

    @GetMapping("/{accountId}/{customerId}")
    public AccountDtoResponse obtenerCuentaPorId(@Positive @PathVariable Long accountId, @Positive @PathVariable Long customerId) {
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

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Boolean> eliminarCuenta(@PathVariable Long customerId) {
        return  ResponseEntity.ok(accountService.eliminarCuenta(customerId));
    }

    @PostMapping("/add-money")
    public ResponseEntity<Boolean> addMoneyToBalance(@Valid @RequestBody AddAmountBalanceDto addAmountBalanceDto) {
        return ResponseEntity.ok(accountService.addMoneyToBalance(addAmountBalanceDto));
    }
    @PostMapping("/rest-money")
    public ResponseEntity<Boolean> addMoneyToBalance(@Valid @RequestBody RestMoneyBalanceDto restMoneyBalanceDto) {
        return ResponseEntity.ok(accountService.restMoneyToBalance(restMoneyBalanceDto));
    }
    @GetMapping("/comprobar-prestamo/{customerId}/{monto}")
    public ResponseEntity<String> comprobarPrestamo(@PathVariable Long customerId, @PathVariable Integer monto) {
        return ResponseEntity.ok(accountService.comprobarPrestamo(customerId,monto));
    }
}
