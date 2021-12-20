package com.web.springboot2.service;

import com.web.springboot2.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    Role getRoleByName(String name);
    Role save(Role role);
}
