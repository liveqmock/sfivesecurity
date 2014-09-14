package com.sfive.security.dao;


import com.sfive.security.domain.Client;
import com.sfive.security.domain.Employee;
import com.sfive.security.domain.Serviceregistration;
import com.sfive.security.domain.Userprofile;

import java.util.List;

public interface SecurityDao {
    
    /** Employee **/
    
    public List<Employee> findAllEmployees();
    
    public List<Employee> findAllEmployeesByRegId(Long regId);
    
    public Employee insertOrUpdateEmployee(Employee emp);
    
    public Employee findEmployee(Long empId);
    
    public boolean deleteEmployee(Long empId);
    
    /** client **/

    public List<Client> findAllClients();
    
    public List<Client> findAllClientByRegId(Long regId);
    
    public Client insertOrUpdateClient(Client client);
    
    public Client findClient(Long clientId);
    
    public boolean deleteClient(Long clientId);
    
    
    /** Service Registration **/

    public Serviceregistration insertOrUpdateServiceReg(Serviceregistration serviceReg);
    
    public boolean deleteServiceReg(Long regId);
    
    public List<Serviceregistration> findAllServiceRegs();
    
    public Serviceregistration findServiceReg(Long regId);
    
    public Serviceregistration findServiceRegByUsername(String username);
    
    /** User Profile **/
    
    public Userprofile insertOrUpdateUserProfile(Userprofile userProfile);
    
    public boolean deleteUserProfile(Long userId);
    
    public List<Userprofile> findAllUserProfiles();
    
    public Userprofile findUserProfile(Long userId);
}
