package com.web.springboot2.exception_handling;

import org.springframework.dao.DataIntegrityViolationException;

public class NoUserWithSuchLoginException extends DataIntegrityViolationException {

    public NoUserWithSuchLoginException(String msg) {
        super(msg);
    }
}
