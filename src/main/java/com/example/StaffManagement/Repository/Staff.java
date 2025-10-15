package com.example.StaffManagement.Repository;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "staff")
public class Staff { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StaffRole role; // CHEF, WAITER, MANAGER

    private BigInteger phone;
private String name;
    private String email;

    private String username;

    private String password;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public StaffRole getRole() { return role; }
    public void setRole(StaffRole role) { this.role = role; }

    public String getName() { return name; } // ✅ Getter
    public void setName(String name) { this.name = name; }

    public BigInteger getPhone() { return phone; }
    public void setPhone(BigInteger phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
