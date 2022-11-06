package ru.maxawergy.pizzeriaBeFe.entity;

import javax.persistence.*;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vendorId;
    private String vendorName;
    private String address;
    private Integer priority;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "del_id")
    private Delegate del_id;


    public Vendor(String vendorName, String address, Integer priority, Delegate del_id) {
        this.vendorName = vendorName;
        this.address = address;
        this.priority = priority;
        this.del_id = del_id;
    }

    public Vendor() {

    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Delegate getDel_id() {
        return del_id;
    }

    public void setDel_id(Delegate del_id) {
        this.del_id = del_id;
    }
}
