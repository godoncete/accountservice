package com.dxc.accountservice.domain.service;

import com.dxc.accountservice.domain.dto.AccountDtoResponse;
import com.dxc.accountservice.exception.AccountNotFoundException;
import com.dxc.accountservice.persistence.entity.Account;
import com.dxc.accountservice.persistence.entity.Customer;
import com.dxc.accountservice.persistence.mapper.AccountMapper;
import com.dxc.accountservice.persistence.repository.AccountRepository;
import com.dxc.accountservice.persistence.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class AccountServiceImplTest {

    private Customer customer;
    private AccountDtoResponse accountDto;
    private Account account;

    @TestConfiguration
    static class AccountServiceConfiguration{
        @Bean
        public AccountService accountService(){
            return new AccountServiceImpl();
        }
    }

    @BeforeEach
    public void setUp(){
        customer = Customer.builder().id(1L).email("email@email.com").name("test").build();
        accountDto = AccountDtoResponse.builder()
                .id(1L).balance(100).type("Company").openingDate(LocalDate.now())
                .customerId(1L).build();
        account = Account.builder()
                .id(1L).balance(100).type("Company").openingDate(LocalDate.now())
                .customer(customer).build();
    }

    @MockBean
    CustomerRepository customerRepository;
    @MockBean
    AccountRepository accountRepository;
    @MockBean
    AccountMapper accountMapper;
    @Autowired
    AccountService accountService;

    @Test
    void givenCostumeId_whenListarCuentasCliente_thenAccountListNotNull() {
    }

    @Test
    void givenCostumerId_whenIdNotExist_thenCostumerNotFoundException() {
    }
    @Test
    void givenAccountIdAndCustomerId_whenGetByAccountIdAndCustomerId_thenAccountIsNotNull() {
            assertThat(accountService).isNotNull();

            Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
            Mockito.when(accountRepository.findByIdAndCustomer(1L,customer)).thenReturn(Optional.of(account));
            Mockito.when(accountMapper.toAccountDtoResponse(account)).thenReturn(accountDto);

            AccountDtoResponse accDto = accountService.getByAccountIdAndCustomerId(1L,1L);

            assertThat(accDto)
                    .isNotNull()
                    .extracting(AccountDtoResponse::getBalance,AccountDtoResponse::getType,AccountDtoResponse::getCustomerId)
                    .containsExactly(100,"Company",1L);
    }

    @Test
    void givenAccountIdAndCustomerId_whenGetByAccountIdNotExistAndCustomerId_thenAccountNotFoundException(){
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Exception exception = assertThrows(AccountNotFoundException.class, () -> {
           accountService.getByAccountIdAndCustomerId(1L,1L);
        });

        assertEquals("this account does not exist for customer with id: 1", exception.getMessage());

//        verify(accountRepository, never()).findByIdAndCustomer(anyLong(),any());
//        verify(accountMapper, never()).toAccountDtoResponse(any());
    }

    @Test
    void givenOneAccount_whenCrearCuenta_thenAccountCreated() {
    }
    @Test
    void givenOneAccount_whenInvalidAccount_thenMethodArgumentNotValidException() {
    }

    @Test
    void givenAccountAndBalance_whenRestMoneyToBalance_thenTrue() {
    }
    @Test
    void givenAccountAndBalance_whenRestInsuficientMoneyToBalance_thenInsuficientBalanceException() {
    }
}