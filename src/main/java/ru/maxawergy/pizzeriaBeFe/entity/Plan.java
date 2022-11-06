package ru.maxawergy.pizzeriaBeFe.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long planId;
    private String planName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id")
    private Vendor vendorId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employer empId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Supply> supplies = new ArrayList<>();

    public Plan(String planName, Vendor vendorId, Employer empId, List<Supply> supplies) {
        this.planName = planName;
        this.vendorId = vendorId;
        this.empId = empId;
        this.supplies = supplies;
    }

    public Plan() {

    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Vendor getVendorId() {
        return vendorId;
    }

    public void setVendorId(Vendor vendorId) {
        this.vendorId = vendorId;
    }

    public Employer getEmpId() {
        return empId;
    }

    public void setEmpId(Employer empId) {
        this.empId = empId;
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(List<Supply> supplies) {
        this.supplies = supplies;
    }
}
