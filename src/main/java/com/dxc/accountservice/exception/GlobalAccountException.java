package com.dxc.accountservice.exception;

public class GlobalAccountException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GlobalAccountException(String message) {
        super(message);
    }
}
