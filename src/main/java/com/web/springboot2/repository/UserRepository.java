package com.web.springboot2.repository;

import com.web.springboot2.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select u from User u where u.username like :username")
    User getUserByUsername(@Param("username") String username);
}
