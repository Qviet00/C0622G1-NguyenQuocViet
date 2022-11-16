package com.example.baithi.dto;

import com.example.baithi.model.TypePayment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

public class MotelDto implements Validator {

    private int id;

    @NotBlank
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải\n" +
            "viết hoa.")
    private String name;
    @NotBlank
    @Pattern(regexp = "^[0|84+][90|91][0-9]{8}$", message = "Nhập đúng định dạng phone number")
    private String phone;

    private String starDay;

    private int status;

    private String typePayment;

    public MotelDto() {
    }

    public MotelDto(int id, String name, String phone, String starDay, int status, String typePayment) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.starDay = starDay;
        this.status = status;
        this.typePayment = typePayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStarDay() {
        return starDay;
    }

    public void setStarDay(String starDay) {
        this.starDay = starDay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MotelDto customerDto = (MotelDto) target;
        LocalDate birthday;
        if (customerDto.starDay == "") {
            errors.rejectValue("starDay", "add.starDay", "Không được để trống");

        } else {
            try {
                birthday = LocalDate.parse(customerDto.starDay);
                if (Period.between(birthday, LocalDate.now()).getYears() < 18) {
                    errors.rejectValue("starDay", "add.starDay", "Nhập ngày tháng lớn hơn 18 tuổi");
                }
            } catch (Exception e) {
                errors.rejectValue("starDay", "add.starDay", "Nhập đúng định dạng: dd/MM/yyyy");
            }
        }
    }

}
