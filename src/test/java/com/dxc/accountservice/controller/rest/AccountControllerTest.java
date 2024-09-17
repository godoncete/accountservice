package com.dxc.accountservice.controller.rest;

import com.dxc.accountservice.domain.dto.AccountDtoResponse;
import com.dxc.accountservice.domain.service.AccountService;
import com.dxc.accountservice.persistence.entity.Customer;
import com.dxc.accountservice.persistence.mapper.AccountMapper;
import com.dxc.accountservice.persistence.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    AccountService accountService;
    @MockBean
    AccountRepository accountRepository;
    @InjectMocks
    AccountController accountController;
//    @MockBean
//    private AccountMapper accountMapper;

    private AccountDtoResponse accDto;
    private Customer customer;

    @BeforeEach
    public void setUp(){
        accDto = AccountDtoResponse.builder()
                .id(1L).balance(400).openingDate(LocalDate.now()).type("Personal").customerId(1L)
                .build();
        Mockito.when(accountService.getByAccountIdAndCustomerId(1L,1L))
            .thenReturn(accDto);
    }

    @Test
    void givenCostumerId_whenGetAccountByCustomer_thenAccountList() {

    }
    @Test
    void givenCostumerId_whenGetAccountByCustomerNotExist_thenCustomerNotFoundException()
    {
    }

    @Test
    void givenAccountIdAndCostumerId_whenObtenerCuentaPorId_thenOneAccount() throws Exception{
            MvcResult fakeaccount = mockMvc.perform(
                        get("/account/1/1")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
//                    .andExpect((ResultMatcher)content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
//                    .andExpect((ResultMatcher) jsonPath("$.type", hasItem("Personal")))
                    .andReturn();
    }
    @Test
    void givenAccountIdAndCostumerId_whenCostumerIdNotExist_thenCustomerNotFoundException() {

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