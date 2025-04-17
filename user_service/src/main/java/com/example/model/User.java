package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
}

  public void setId(Long id) {
    this.id = id;
  }

  @Column(unique = true, nullable = false)
  private String username;

  public String getUsername() {
    return username;
}

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(nullable = false)
  private String password;

  public String getPassword() {
    return password;
}

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(unique = true, nullable = false)
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


}
