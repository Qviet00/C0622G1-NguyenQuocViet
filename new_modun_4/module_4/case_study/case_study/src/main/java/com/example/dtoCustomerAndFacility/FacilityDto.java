package com.example.dtoCustomerAndFacility;

import com.example.facility.model.FacilityType;
import com.example.facility.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private int facilityId;
    @Pattern(regexp = "^([A-Z][a-z0-1]*)+(\\s[A-Z0-9][a-z0-9]*)*$",message = "Tên dịch vụ được phép chứa số. Và các kí tự đầu tiên của mỗi từ phải viết\n" +
            "hoa.")
    private String facilityName;
    @NotNull(message = "Không được để trống, Nhập số")
    private Integer area;
    @NotNull(message = "Không được để trống, Nhập số")
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {return rentType;}

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public FacilityDto(int facilityId, String facilityName, Integer area, Double cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloor, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors){
        FacilityDto facilityDto = (FacilityDto) target;
        if (facilityDto.numberOfFloor != null){
            if (facilityDto.numberOfFloor<=0) {
                errors.rejectValue("numberOfFloor","add.numberOfFloor","Số tầng phải là số nguyên dương");
            }
        }
        if (facilityDto.cost != null){
            if(facilityDto.cost<=0) {
                errors.rejectValue("cost","add.cost","Giá phải là số dương.");
            }
        }
        if (facilityDto.area!=null) {
            if (facilityDto.area<=0) {
                errors.rejectValue("area","add.area","Area phải là số dương.");
            }
        }
    }
}
