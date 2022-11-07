package com.example.dtoCustomerAndFacility;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {
    private int customerCode;
    @NotBlank
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải\n" +
            "viết hoa.")
    private String customerName;
    private String dateOfBirth;

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    private int gender;
    @NotBlank
    @Pattern(regexp = "^[0-9]{9}$", message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX\n" +
            "(X là số 0-9).")
    private String identify;
    @NotBlank
    @Pattern(regexp = "^[0|84+][90|91][0-9]{8}$", message = "Nhập đúng định dạng phone number")
    private String phoneNumber;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Địa chỉ email phải đúng định dạng.")
    private String email;
    private String address;
    private String typeCustomer;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        LocalDate birthday;
        if (customerDto.dateOfBirth == "") {
            errors.rejectValue("dateOfBirth", "add.dateOfBirth", "Không được để trống");

        } else {
            try {
                birthday = LocalDate.parse(customerDto.dateOfBirth);
                if (Period.between(birthday, LocalDate.now()).getYears() < 18) {
                    errors.rejectValue("dateOfBirth", "add.dateOfBirth", "Nhập ngày tháng lớn hơn 18 tuổi");
                }
            } catch (Exception e) {
                errors.rejectValue("dateOfBirth", "add.dateOfBirth", "Nhập đúng định dạng: dd/MM/yyyy");
            }
        }
    }
}
