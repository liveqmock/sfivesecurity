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
@NamedQueries( { @NamedQuery(name = "Userprofile.findAll", query = "select o from Userprofile o"),
                 @NamedQuery(name = "Userprofile.findById", query = "select o from Userprofile o where o.userId = :pUserId")
                 })
@Table(name = "\"UserProfile\"")
@Cacheable(value = false)
public class Userprofile implements Serializable {
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "city")
    private String city;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "password")
    private String password;
    @Column(name = "phone1")
    private String phone1;
    @Column(name = "phone2")
    private String phone2;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "state")
    private String state;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Long userId;
    @Column(name = "username")
    private String username;
   
    @ManyToOne
    @JoinColumn(name = "regId")
    private Serviceregistration serviceregistration;

    public Userprofile() {
    }

    public Userprofile(String address1, String address2, String city, String firstname, String lastname,
                       String password, String phone1, String phone2, String pincode,
                       Serviceregistration serviceregistration, String state, Long userId, String username) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.pincode = pincode;
        this.serviceregistration = serviceregistration;
        this.state = state;
        this.userId = userId;
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Serviceregistration getServiceregistration() {
        return serviceregistration;
    }

    public void setServiceregistration(Serviceregistration serviceregistration) {
        this.serviceregistration = serviceregistration;
    }
}
