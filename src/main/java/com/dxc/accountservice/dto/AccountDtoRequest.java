package com.dxc.accountservice.dto;

import lombok.*;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    private String type;
    @NotNull
    private LocalDate openingDate;
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int balance;
    @NotNull
    private CustomerDtoRequest customer;
}
