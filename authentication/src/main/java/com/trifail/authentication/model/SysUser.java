package com.trifail.authentication.model;

import javax.persistence.*;

@Entity(name = "sys_user")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", length = 20)
    private String username;
    @Column(name = "password", length = 60)
    private String password;
    @Column(name = "email", length = 40)
    private String email;
    @Column(name = "phone", length = 20)
    private String phone;
    @Column(name = "terminal_type", length = 6)
    private Short terminalType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(Short terminalType) {
        this.terminalType = terminalType;
    }
}