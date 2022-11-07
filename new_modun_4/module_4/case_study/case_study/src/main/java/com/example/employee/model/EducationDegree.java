package com.example.employee.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private int idEducationDegree;
    @Column(name = "education_degree_name")
    private String nameOfEducationDegree;
    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public EducationDegree(int idEducationDegree, String nameOfEducationDegree, List<Employee> employeeList) {
        this.idEducationDegree = idEducationDegree;
        this.nameOfEducationDegree = nameOfEducationDegree;
        this.employeeList = employeeList;
    }

    public int getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(int idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public String getNameOfEducationDegree() {
        return nameOfEducationDegree;
    }

    public void setNameOfEducationDegree(String nameOfEducationDegree) {
        this.nameOfEducationDegree = nameOfEducationDegree;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
