package com.sfive.security.view;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;


@XmlRootElement
public class ServiceRegistrationView implements Serializable {
    
    private Long regId;
    private String companyname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String email;
    private String fax;
    private String phone1;
    private String phone2;
    private String pincode;
    private String username;
    private String password;
    private String role;

    public ServiceRegistrationView() {
        super();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("regId", regId)
            .append("companyname", companyname)
            .append("address1", address1)
            .append("address2", address2)
            .append("city", city)
            .append("state", state)
            .append("email", email)
            .append("fax", fax)
            .append("phone1", phone1)
            .append("phone2", phone2)
            .append("pincode", pincode)
            .append("username", username)
            .append("role", role)
            .toString();
    }


    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public Long getRegId() {
        return regId;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPincode() {
        return pincode;
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
