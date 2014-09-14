package com.sfive.security.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "Serviceregistration.findAll", query = "select o from Serviceregistration o"),
                 @NamedQuery(name = "Serviceregistration.findById", query = "select o from Serviceregistration o where o.regId = :pRegId"),
                 @NamedQuery(name = "Serviceregistration.findByUsername", query = "select o from Serviceregistration o where o.username = :pUsername")
                 })
@Table(name = "\"ServiceRegistration\"")
@Cacheable(value = false)
public class Serviceregistration implements Serializable {
    
    @Column(name = "address1")
    private String address1;
    
    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "companyname")
    private String companyname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "fax")
    private String fax;
    
    @Column(name = "phone1")
    private String phone1;
    
    @Column(name = "phone2")
    private String phone2;
    
    @Column(name = "pincode")
    private String pincode;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regId", nullable = false)
    private Long regId;
    
    @Column(name = "username", nullable=false)
    private String username;
    
    @Column(name = "password", nullable=false)
    private String password;
    
    @Column(name = "role", nullable=false)
    private String role;

    public Serviceregistration() {
        super();
    }

    public Serviceregistration(String address1, String address2, String city, String companyname, String email,
                               String fax, String phone1, String phone2, String pincode, Long regId, String state, String username, String password, String role) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.companyname = companyname;
        this.email = email;
        this.fax = fax;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.pincode = pincode;
        this.regId = regId;
        this.state = state;
        this.username= username;
        this.password = password;
        this.role = role;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
