package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("/register")
  public User register(@RequestBody User u) {
    return service.register(u);
  }

  @PostMapping("/login")
  public User login(@RequestParam String username,
                    @RequestParam String password) {
    return service.login(username, password);
  }
}
