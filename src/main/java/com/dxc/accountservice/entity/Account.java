package com.dxc.accountservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private int balance;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Customer customer;
}
