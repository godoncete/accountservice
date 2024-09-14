package com.dxc.accountservice.controller.rest;

import com.dxc.accountservice.domain.dto.AccountDtoRequest;
import com.dxc.accountservice.domain.dto.AccountDtoResponse;
import com.dxc.accountservice.domain.dto.AddAmountBalanceDto;
import com.dxc.accountservice.domain.dto.RestMoneyBalanceDto;

import com.dxc.accountservice.domain.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Operation(summary = "Obtiene la lista de cuentas de un cliente por Id")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AccountDtoResponse>> getAccountByCustomer(@Positive @PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.listarCuentasCliente(customerId));
    }


    @Operation(summary = "Obtiene la cuenta por Id de la cuenta y el  Id cliente")
    @GetMapping("/{accountId}/{customerId}")
    public ResponseEntity<AccountDtoResponse> obtenerCuentaPorId(@Positive @PathVariable Long accountId, @Positive @PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.getByAccountIdAndCustomerId(accountId,customerId));
    }

    @Operation(summary = "Crea una nueva cuenta para un cliente")
    @PostMapping
    public ResponseEntity<AccountDtoResponse> crearCuenta(@Valid @RequestBody  AccountDtoRequest AccountDtoRequest) {
        return ResponseEntity.ok(accountService.crearCuenta(AccountDtoRequest));
    }

    @Operation(summary = "Actualiza una cuenta por Id")
    @PutMapping("/{accountId}"  )
    public ResponseEntity<AccountDtoResponse> actualizarCuenta(@PathVariable Long accountId,
                                                               @Valid @RequestBody AccountDtoRequest account) {
        return ResponseEntity.ok(accountService.actualizarCuenta(account, accountId));
    }


    @Operation(summary = "Elimina todas las  cuentas de un cliente por Id de un cliente"  )
    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> eliminarCuentas(@PathVariable Long customerId) {
        return  ResponseEntity.ok(accountService.eliminarCuentasPorCliente(customerId));
    }

    @Operation(summary = "Agrega dinero a la cuenta de un cliente" )
    @PostMapping("/add-money")
    public ResponseEntity<Boolean> addMoneyToBalance(@Valid @RequestBody AddAmountBalanceDto addAmountBalanceDto) {
        return ResponseEntity.ok(accountService.addMoneyToBalance(addAmountBalanceDto));
    }
    @Operation(summary = "Retirar dinero de la cuenta de un cliente"  )
    @PostMapping("/rest-money")
    public ResponseEntity<Boolean> addMoneyToBalance(@Valid @RequestBody RestMoneyBalanceDto restMoneyBalanceDto) {
        return ResponseEntity.ok(accountService.restMoneyToBalance(restMoneyBalanceDto));
    }



    @Operation(summary = "Comprobar si un cliente tiene un préstamo" )
    @GetMapping("/comprobar-prestamo/{customerId}/{monto}")
    public ResponseEntity<String> comprobarPrestamo(@Positive @PathVariable Long customerId,@Positive @PathVariable Integer monto) {
        return ResponseEntity.ok(accountService.comprobarPrestamo(customerId,monto));
    }
}
