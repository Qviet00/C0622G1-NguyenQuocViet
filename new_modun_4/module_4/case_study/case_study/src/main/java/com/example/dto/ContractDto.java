package com.example.dto;


import com.example.customer.model.Customer;
import com.example.employee.model.Employee;
import com.example.facility.model.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class ContractDto implements Validator {
    public int validate;
    private Integer idContract;
    @NotBlank(message = "Không để Trống")
    private String startDate;
    @NotBlank(message = "Không để trống")
    private String endDate;

    @PositiveOrZero( message = "Tiền đặt cọc không là số âm")
    private Double deposit;

    @NotNull(message = "Vui lòng chọn")
    private Employee employee;
    private Customer customer;

    @NotNull(message = "Không được để trống")
    private Facility facility;


    public ContractDto() {
    }

    public int getValidate() {
        return validate;
    }

    public void setValidate(int validate) {
        this.validate = validate;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
