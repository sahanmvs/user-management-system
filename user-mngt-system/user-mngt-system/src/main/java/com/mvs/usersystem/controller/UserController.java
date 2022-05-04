package com.mvs.usersystem.controller;

import com.mvs.usersystem.model.User;
import com.mvs.usersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        user = userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable("id") Long id) {
        boolean deleted = false;
        deleted = userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("User deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id ,
                                                @RequestBody User user) {
        user = userService.updateUser(id, user);
        return ResponseEntity.ok(user);
    }

}
