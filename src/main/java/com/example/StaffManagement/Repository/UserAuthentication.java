package com.example.StaffManagement.Repository;

import jakarta.persistence.*;

@Entity
@Table(name = "user_authentication")
public class UserAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Staff getStaff() { return staff; }
    public void setStaff(Staff staff) { this.staff = staff; }
}
