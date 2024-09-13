package com.dxc.accountservice.dto;

import com.dxc.accountservice.entity.Customer;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDtoRequest {
    @NotBlank
    @NotNull
    private Long id;
    @NotBlank
    private String type;
    @NotNull
    private LocalDate openingDate;
    @NotNull
    private int balance;
    private CustomerDtoRequest customer;
}
