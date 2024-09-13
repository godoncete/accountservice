package com.dxc.accountservice.dto;

import com.dxc.accountservice.entity.Customer;

import java.time.LocalDate;

public class AccountDtoResponse {

    private Long id;

    private String type;

    private LocalDate openingDate;

    private int balance;

    private Customer customer;
}
