package com.user.UserService.controllers;

import com.user.UserService.entities.Users;
import com.user.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users users){
        Users users1 =  userService.saveUser(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getSingleUser(@PathVariable("userId") String userId){
        Users users = userService.getUsers(userId);
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> allUser = userService.getAllUsers();
        return ResponseEntity.ok(allUser);
    }
}
