package com.web.springboot2.exception_handling;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class NoUserWithSuchIdException extends UsernameNotFoundException {

    public NoUserWithSuchIdException(String msg) {
        super(msg);
    }
}
