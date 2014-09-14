package com.sfive.security.view;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ClientView implements Serializable {

    private String address1;
    private String address2;
    private String city;    
    private Long clientId;
    private String cpemail;
    private String cpfirstname;
    private String cplastname;
    private String cpphone1;
    private String cpphone2;
    private String email;
    private String fax;
    private String name;
    private String phone1;
    private String phone2;
    private String pincode;
    private String state;
    private String website;
    private Long serviceRegId;
    
    public ClientView() {
        super();
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

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setCpemail(String cpemail) {
        this.cpemail = cpemail;
    }

    public String getCpemail() {
        return cpemail;
    }

    public void setCpfirstname(String cpfirstname) {
        this.cpfirstname = cpfirstname;
    }

    public String getCpfirstname() {
        return cpfirstname;
    }

    public void setCplastname(String cplastname) {
        this.cplastname = cplastname;
    }

    public String getCplastname() {
        return cplastname;
    }

    public void setCpphone1(String cpphone1) {
        this.cpphone1 = cpphone1;
    }

    public String getCpphone1() {
        return cpphone1;
    }

    public void setCpphone2(String cpphone2) {
        this.cpphone2 = cpphone2;
    }

    public String getCpphone2() {
        return cpphone2;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setServiceRegId(Long serviceRegId) {
        this.serviceRegId = serviceRegId;
    }

    public Long getServiceRegId() {
        return serviceRegId;
    }
}
