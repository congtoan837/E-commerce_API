package com.poly.model;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer userId;
    private String username;
    private List<String> roles;

    public JwtResponse() {
        super();
    }

    public JwtResponse(String token, Integer userId, String username, List<String> roles) {
        super();
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


}
