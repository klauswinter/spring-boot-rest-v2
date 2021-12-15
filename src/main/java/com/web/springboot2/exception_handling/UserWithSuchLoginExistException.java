package com.web.springboot2.exception_handling;

import org.springframework.dao.DataIntegrityViolationException;

public class UserWithSuchLoginExistException extends DataIntegrityViolationException {

    public UserWithSuchLoginExistException(String msg) {
        super(msg);
    }
}
