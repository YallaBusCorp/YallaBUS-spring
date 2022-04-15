package com.alphaq.yallabusserver.dto;

import java.util.Objects;

public class AdminDTO {
    private Integer id;
    private EmployeeDTO emp;
    private String username;
    private String password;
    private String accessToken;

    public AdminDTO() {
    }

    public AdminDTO(Integer id, EmployeeDTO emp, String username, String password, String accessToken) {
        this.id = id;
        this.emp = emp;
        this.username = username;
        this.password = password;
        this.accessToken = accessToken;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmp(EmployeeDTO emp) {
        this.emp = emp;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getId() {
        return id;
    }

    public EmployeeDTO getEmp() {
        return emp;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO entity = (AdminDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.emp, entity.emp) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.accessToken, entity.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emp, username, password, accessToken);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "emp = " + emp + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "accessToken = " + accessToken + ")";
    }
}
