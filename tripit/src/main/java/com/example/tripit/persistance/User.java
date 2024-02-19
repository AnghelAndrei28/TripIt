package com.example.tripit.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    public User(String john, String s, String number) {
        this.username = john;
        this.email = s;
        this.password = number;
    }

    public User() {

    }
}
