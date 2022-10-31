package com.example.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int idPosition;
    @Column(name = "position_name")
    private String positionName;

    @OneToMany(mappedBy = "position")
    private List<Employee> employeeList;
}
