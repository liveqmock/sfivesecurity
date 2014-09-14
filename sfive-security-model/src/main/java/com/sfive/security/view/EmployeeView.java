package com.sfive.security.view;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class EmployeeView implements Serializable {
    
    private String address1;
    private String address2;
    private int age;
    private String city;
    private Long empId;
    private String firstname;
    private String lastname;
    private String phone1;
    private String phone2;
    private byte[] photo;
    private String pincode;
    private String rfirstname;
    private String rlastname;
    private String rphone;
    private String sex;
    private String state;
    private Long regId;
    
    public EmployeeView() {
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
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

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPincode() {
        return pincode;
    }

    public void setRfirstname(String rfirstname) {
        this.rfirstname = rfirstname;
    }

    public String getRfirstname() {
        return rfirstname;
    }

    public void setRlastname(String rlastname) {
        this.rlastname = rlastname;
    }

    public String getRlastname() {
        return rlastname;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getRphone() {
        return rphone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public Long getRegId() {
        return regId;
    }
}
