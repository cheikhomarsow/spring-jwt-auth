package com.example.jwtauth.service;

import com.example.jwtauth.model.Role;
import com.example.jwtauth.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
