package com.sfive.security.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "Employee.findAll", query = "select o from Employee o"), 
                 @NamedQuery(name = "Employee.findById", query = "select o from Employee o where o.empId = :pEmpId"),
                 @NamedQuery(name = "Employee.findAllByRegId", query = "select o from Employee o where o.serviceregistration.regId = :pRegId")
            })
@Table(name = "\"Employee\"")
@Cacheable(value = false)
public class Employee implements Serializable {
    @Column(name = "address1")
    private String address1;
    
    @Column(name = "address2")
    private String address2;
    
    @Column(name = "age")
    private int age;
    
    @Column(name = "city")
    private String city;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId", nullable = false)
    private Long empId;
    
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone1")
    private String phone1;
    @Column(name = "phone2")
    private String phone2;
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "rfirstname")
    private String rfirstname;
    @Column(name = "rlastname")
    private String rlastname;
    @Column(name = "rphone")
    private String rphone;
    @Column(name = "sex")
    private String sex;
    @Column(name = "state")
    private String state;
    
    @ManyToOne
    @JoinColumn(name = "serviceRegId")
    private Serviceregistration serviceregistration;

    public Employee() {
    }

    public Employee(String address1, String address2, int age, String city, Long empId, String firstname,
                    String lastname, String phone1, String phone2, String pincode, String rfirstname, String rlastname,
                    String rphone, String sex, String state) {
        this.address1 = address1;
        this.address2 = address2;
        this.age = age;
        this.city = city;
        this.empId = empId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.pincode = pincode;
        this.rfirstname = rfirstname;
        this.rlastname = rlastname;
        this.rphone = rphone;
        this.sex = sex;
        this.state = state;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getRfirstname() {
        return rfirstname;
    }

    public void setRfirstname(String rfirstname) {
        this.rfirstname = rfirstname;
    }

    public String getRlastname() {
        return rlastname;
    }

    public void setRlastname(String rlastname) {
        this.rlastname = rlastname;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setServiceregistration(Serviceregistration serviceregistration) {
        this.serviceregistration = serviceregistration;
    }

    public Serviceregistration getServiceregistration() {
        return serviceregistration;
    }
}
