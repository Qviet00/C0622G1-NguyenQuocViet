package com.example.login;


import com.example.employee.model.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;
    private String userName;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roler",
            joinColumns = @JoinColumn(name ="user_id" ),
            inverseJoinColumns = @JoinColumn(name="roler_id"))
    private List<Role> roles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @JsonBackReference
    private Employee employees;

    public User() {
    }

    public User(int userId, String userName, String password, List<Role> roles, Employee employees) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.employees = employees;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }
}
