package com.dxc.accountservice.controller.rest;

import com.dxc.accountservice.domain.dto.AccountDtoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTestRestTemplate {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void givenCostumerId_whenGetAccountByCustomer_thenAccountList() {

    }
    @Test
    void givenCostumerId_whenGetAccountByCustomerNotExist_thenCustomerNotFoundException()
    {
    }

    @Test
    void givenAccountIdAndCostumerId_whenObtenerCuentaPorId_thenOneAccount() throws Exception{
        ResponseEntity<AccountDtoResponse> response = restTemplate.getForEntity("http://localhost:" + port + "/account/1/1", AccountDtoResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void givenAccountIdAndCostumerId_whenCostumerIdNotExist_thenCustomerNotFoundException() throws Exception{
    }

    @Test
    void givenAccount_whenCrearCuenta_thenAccountCreated() {
    }

    @Test
    void givenAccount_whenInvalidAccount_thenMethodArgumentNotValidException() {
    }

    @Test
    void givenAccountAndBalance_whenRestMoneyToBalance_thenTrue() {
    }

    @Test
    void givenAccountAndBalance_whenRestInsuficientMoneyToBalance_thenInsufficientBalanceException() {
    }
}