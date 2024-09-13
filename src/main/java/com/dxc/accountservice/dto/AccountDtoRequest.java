package com.dxc.accountservice.dto;

import com.dxc.accountservice.entity.Customer;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDtoRequest {

    private Long id;
    private String type;
    private LocalDate openingDate;
    private int balance;
    private CustomerDtoRequest customer;
}
