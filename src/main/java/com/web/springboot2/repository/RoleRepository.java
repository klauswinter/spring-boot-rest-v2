package com.web.springboot2.repository;

import com.web.springboot2.model.Role;
import com.web.springboot2.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query(value = "select r from Role r where r.role like :role")
    Role getRoleByName(@Param("role") String role);
}
