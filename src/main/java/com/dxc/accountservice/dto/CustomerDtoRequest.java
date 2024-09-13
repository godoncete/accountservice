package com.dxc.accountservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDtoRequest {
    private Long id;
    private String name;
    private String email;
}
