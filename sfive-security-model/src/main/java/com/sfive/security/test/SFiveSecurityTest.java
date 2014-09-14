package com.sfive.security.test;


import com.sfive.security.domain.Client;
import com.sfive.security.domain.Employee;
import com.sfive.security.domain.Serviceregistration;
import com.sfive.security.domain.Userprofile;
import com.sfive.security.service.SecurityService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//import org.junit.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class SFiveSecurityTest {
    public SFiveSecurityTest() {
    }
    
    @Autowired
    public SecurityService securityService;
    
    @Test
    public void testFindAll(){
        System.out.println(securityService.findAllEmployees().size());
    }
    
    @Test
    public void insertEmployeeTest(){
        Employee emp = new Employee();
        emp.setFirstname("ram");
        emp.setLastname("Immidisetti");
        emp.setAge(35);
        emp.setSex("Male");
        emp.setAddress1("#54/4, Kapil Homes, Sneha Enclave");
        emp.setAddress2("Macha Bolarum");
        emp.setCity("Secunderabad");
        emp.setState("Andhra Pradesh");
        emp.setPincode("500010");
        emp.setPhone1("9948911777");
        emp.setPhone2("8790224466");
        emp.setRfirstname("Mohan");
        emp.setRlastname("Immidisetti");
        emp.setRphone("8881119999");
        Employee empResult = securityService.insertOrUpdateEmployee(emp);
        System.out.println(empResult.getEmpId());
    }
    
    @Test
    public void insertServiceRegistration(){
        Serviceregistration serviceReg = new Serviceregistration();
        serviceReg.setCompanyname("Sri Shiridi Sai Security Services");
        serviceReg.setAddress1("54/4, Kapil Homes, Sneha Enclave");
        serviceReg.setAddress2("Macha Bolarum");
        serviceReg.setCity("Secunderabad");
        serviceReg.setState("Andhra Pradesh");
        serviceReg.setPhone1("87902244666");
        serviceReg.setPhone2("9948911777");
        serviceReg.setEmail("sfive1997@yahoo.com");
        serviceReg.setFax("8790224466");
        serviceReg.setPincode("500090");
        serviceReg = securityService.insertOrUpdateServiceReg(serviceReg);
        System.out.println(serviceReg.getRegId());
        //Assert.assertEquals(Boolean.TRUE, insertFlag);
    }
    
    @Test
    public void insertClient(){
        Client client = new Client();
        client.setName("Mahavir");
        client.setAddress1("401 sundacey");
        client.setAddress2("apt 2020");
        client.setCity("austin");
        client.setState("TX");
        client.setPincode("55523534");
        client.setPhone1("34343434343");
        client.setPhone1("34343343434");
        client.setPhone2("4343434343");
        client.setCpfirstname("ram");
        client.setCplastname("immidisetti");
        client.setCpphone1("5434343343");
        client.setCpphone2("42234342114");
        Serviceregistration serviceRegistration = new Serviceregistration();
        serviceRegistration = securityService.findServiceReg(35L);
        client.setServiceregistration(serviceRegistration);
        securityService.insertOrUpdateClient(client);
    }
    
    @Test
    public void insertUserProfile(){
        Userprofile user = new Userprofile();
        user.setAddress1("54/4, Kapil Homes, Sneha Enclave");
        user.setAddress2("Macha Bolarum");
        user.setCity("Secunderabad");
        user.setState("Andhra Pradesh");
        user.setPhone1("87902244666");
        user.setPhone2("9948911777");
        user = securityService.insertOrUpdateUserProfile(user);
        System.out.println(user.getUserId());
    }
    
    @Test
    public void fetchAllServiceRegs(){
        List<Serviceregistration> regs = new ArrayList<Serviceregistration>();
        regs = securityService.findAllServiceRegs();
        System.out.println(regs.size());
        for(Serviceregistration reg : regs){
            System.out.println("registration id :"+reg.getRegId()+"...");
        }
    }
    
    @Test
    public void fetchAllClients(){
        List<Client> clients = new ArrayList<Client>();
        clients = securityService.findAllClients();
        System.out.println(clients.size());
        for(Client client : clients){
            System.out.println("registration id :"+client.getClientId()+"...");
        }
    }
    
    @Test
    public void fetchAllClientsByRegId(){
        List<Client> clients = new ArrayList<Client>();
        clients = securityService.findAllClientByRegId(34L);
        System.out.println(clients.size());
        for(Client client : clients){
            System.out.println("registration id :"+client.getClientId()+"...");
        }
    }
    
    @Test
    public void fetchAllEmployees(){
        List<Employee> emps = new ArrayList<Employee>();
        emps = securityService.findAllEmployees();
        System.out.println(emps.size());
        for(Employee emp : emps){
            System.out.println("registration id :"+emp.getEmpId()+"...");
        }
    }
    
    @Test
    public void fetchAllUsers(){
        List<Userprofile> profiles = new ArrayList<Userprofile>();
        profiles = securityService.findAllUserProfiles();
        System.out.println(profiles.size());
        for(Userprofile profile : profiles){
            System.out.println("registration id :"+profile.getUserId()+"...");
        }
    }
}
