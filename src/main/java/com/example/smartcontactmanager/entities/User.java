package com.example.smartcontactmanager.entities;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;
    private String enabled;
    private String imageurl;
    @Column(length = 500)
    private String about;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}