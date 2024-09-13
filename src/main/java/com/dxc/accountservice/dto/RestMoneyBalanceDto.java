package com.dxc.accountservice.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@NotBlank
@NotNull
@Positive
public class RestMoneyBalanceDto {
    private Integer amount;
    private Long accountId;
    private Long customerId;
}
