package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  public User register(User u) {
    if (repo.existsByUsername(u.getUsername())) {
      throw new RuntimeException("用户名已存在");
    }
    if (repo.existsByEmail(u.getEmail())) {
      throw new RuntimeException("邮箱已注册");
    }
    // TODO: 密码加密
    return repo.save(u);
  }

  public User login(String username, String password) {
    Optional<User> opt = repo.findByUsername(username);
    if (!opt.isPresent()) {
      throw new RuntimeException("用户不存在");
    }
    User u = opt.get();
    if (!u.getPassword().equals(password)) {
      throw new RuntimeException("密码错误");
    }
    return u;
  }
}
