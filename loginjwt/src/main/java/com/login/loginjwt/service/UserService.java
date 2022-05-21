package com.login.loginjwt.service;

import com.login.loginjwt.domain.Role;
import com.login.loginjwt.domain.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    Role saveRole (Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();

}
