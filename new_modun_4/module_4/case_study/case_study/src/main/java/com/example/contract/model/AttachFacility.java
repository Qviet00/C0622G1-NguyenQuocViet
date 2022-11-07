package com.example.contract.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_facility")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_facility_id")
    private int idAttachFacilityId;
    @Column(name = "attach_facility_name")
    private String nameOfAttachFacility;
    @Column(name = "price")
    private double price;
    @Column(name="unit")
    private String unit;
    @Column(name = "status")
    private String status;

    @JsonBackReference
    @OneToMany(mappedBy = "attachFacility")
    private List<ContractDetail> contractDetailList;

    public AttachFacility() {
    }

    public AttachFacility(int idAttachFacilityId, String nameOfAttachFacility, double price, String unit, String status, List<ContractDetail> contractDetailList) {
        this.idAttachFacilityId = idAttachFacilityId;
        this.nameOfAttachFacility = nameOfAttachFacility;
        this.price = price;
        this.unit = unit;
        this.status = status;
        this.contractDetailList = contractDetailList;
    }

    public int getIdAttachFacilityId() {
        return idAttachFacilityId;
    }

    public void setIdAttachFacilityId(int idAttachFacilityId) {
        this.idAttachFacilityId = idAttachFacilityId;
    }

    public String getNameOfAttachFacility() {
        return nameOfAttachFacility;
    }

    public void setNameOfAttachFacility(String nameOfAttachFacility) {
        this.nameOfAttachFacility = nameOfAttachFacility;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
