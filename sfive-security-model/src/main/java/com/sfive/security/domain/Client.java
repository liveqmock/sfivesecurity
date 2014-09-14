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
@NamedQueries( { @NamedQuery(name = "Client.findAll", query = "select o from Client o"),
                 @NamedQuery(name = "Client.findById", query = "select o from Client o where o.clientId = :pClientId"),
                 @NamedQuery(name = "Client.findAllByRegId", query = "select o from Client o where o.serviceregistration.regId = :pRegId")
})
@Table(name = "\"Client\"")
@Cacheable(value = false)
public class Client implements Serializable {
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "city")
    private String city;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId", nullable = false)
    private Long clientId;
    
    @Column(name = "cpemail")
    private String cpemail;
    @Column(name = "cpfirstname")
    private String cpfirstname;
    @Column(name = "cplastname")
    private String cplastname;
    @Column(name = "cpphone1")
    private String cpphone1;
    @Column(name = "cpphone2")
    private String cpphone2;
    @Column(name = "email")
    private String email;
    @Column(name = "fax")
    private String fax;
    @Column(name = "name")
    private String name;
    @Column(name = "phone1")
    private String phone1;
    @Column(name = "phone2")
    private String phone2;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "state")
    private String state;
    @Column(name = "website")
    private String website;
    
    @ManyToOne
    @JoinColumn(name = "regId")
    private Serviceregistration serviceregistration;

    public Client() {
    }

    public Client(String address1, String address2, String city, Long clientId, String cpemail, String cpfirstname,
                  String cplastname, String cpphone1, String cpphone2, String email, String fax, String name,
                  String phone1, String phone2, String pincode, String state, String website) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.clientId = clientId;
        this.cpemail = cpemail;
        this.cpfirstname = cpfirstname;
        this.cplastname = cplastname;
        this.cpphone1 = cpphone1;
        this.cpphone2 = cpphone2;
        this.email = email;
        this.fax = fax;
        this.name = name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.pincode = pincode;
        this.state = state;
        this.website = website;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getCpemail() {
        return cpemail;
    }

    public void setCpemail(String cpemail) {
        this.cpemail = cpemail;
    }

    public String getCpfirstname() {
        return cpfirstname;
    }

    public void setCpfirstname(String cpfirstname) {
        this.cpfirstname = cpfirstname;
    }

    public String getCplastname() {
        return cplastname;
    }

    public void setCplastname(String cplastname) {
        this.cplastname = cplastname;
    }

    public String getCpphone1() {
        return cpphone1;
    }

    public void setCpphone1(String cpphone1) {
        this.cpphone1 = cpphone1;
    }

    public String getCpphone2() {
        return cpphone2;
    }

    public void setCpphone2(String cpphone2) {
        this.cpphone2 = cpphone2;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
    public Serviceregistration getServiceregistration() {
        return serviceregistration;
    }

    public void setServiceregistration(Serviceregistration serviceregistration) {
        this.serviceregistration = serviceregistration;
    }
}
