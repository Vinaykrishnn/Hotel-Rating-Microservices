package com.user.UserService.services;

import com.user.UserService.entities.Users;

import java.util.List;

public interface UserService {

    Users saveUser(Users users);

    List<Users> getAllUsers();

    Users getUsers(String userId);
}
