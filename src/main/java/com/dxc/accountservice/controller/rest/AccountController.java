package com.dxc.accountservice.controller.rest;

import com.dxc.accountservice.domain.dto.AccountDtoRequest;
import com.dxc.accountservice.domain.dto.AccountDtoResponse;
import com.dxc.accountservice.domain.dto.AddAmountBalanceDto;
import com.dxc.accountservice.domain.dto.RestMoneyBalanceDto;

import com.dxc.accountservice.domain.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @GetMapping(path = "/customer/{customerId}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<AccountDtoResponse>> getAccountByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.listarCuentasCliente(customerId));
    }


    @Operation(summary = "Obtiene la cuenta por Id de la cuenta y el  Id cliente")
    @GetMapping(path = "/{accountId}/{customerId}" ,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<AccountDtoResponse> obtenerCuentaPorId(@Positive @PathVariable Long accountId, @Positive @PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.getByAccountIdAndCustomerId(accountId,customerId));
    }

    @Operation(summary = "Crea una nueva cuenta para un cliente")
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AccountDtoResponse> crearCuenta(@Valid @RequestBody  AccountDtoRequest AccountDtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.crearCuenta(AccountDtoRequest));
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
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(accountService.eliminarCuentasPorCliente(customerId));
    }

    @Operation(summary = "Agrega dinero a la cuenta de un cliente" )
    @PostMapping("/add-money")
    public ResponseEntity<Boolean> addMoneyToBalance(@Valid @RequestBody AddAmountBalanceDto addAmountBalanceDto) {
        return ResponseEntity.ok(accountService.addMoneyToBalance(addAmountBalanceDto));
    }
    @Operation(summary = "Retirar dinero de la cuenta de un cliente. allAccounts en true eso para retirar el monto de todas las cuentas"  )
    @PostMapping("/rest-money")
    public ResponseEntity<Boolean> addMoneyToBalance(@Valid @RequestBody RestMoneyBalanceDto restMoneyBalanceDto,
                                                     @RequestParam(required = false) boolean allAccounts) {
        allAccounts=true;
        return ResponseEntity.ok(accountService.restMoneyToBalance(restMoneyBalanceDto, allAccounts));
    }



    @Operation(summary = "Comprobar si un cliente tiene un préstamo" )
    @GetMapping(path = "/comprobar-prestamo/{customerId}/{monto}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> comprobarPrestamo(@Positive @PathVariable Long customerId,@Positive @PathVariable Integer monto) {
        return ResponseEntity.ok(accountService.comprobarPrestamo(customerId,monto));
    }
}
