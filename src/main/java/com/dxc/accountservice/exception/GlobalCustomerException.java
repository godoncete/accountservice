package com.dxc.accountservice.exception;

public class GlobalCustomerException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GlobalCustomerException(String message) {
        super(message);
    }
}
