package com.sfive.security.service;


import com.sfive.security.dao.SecurityDao;
import com.sfive.security.domain.Client;
import com.sfive.security.domain.Employee;
import com.sfive.security.domain.Serviceregistration;
import com.sfive.security.domain.Userprofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SecurityServiceImpl implements SecurityService {
    
    @Autowired
    private SecurityDao securityDao;
    
    public SecurityServiceImpl() {
        super();
    }

    @Transactional
    public List<Employee> findAllEmployees() {
        return securityDao.findAllEmployees();
    }
    
    @Transactional
    public List<Employee> findAllEmployeesByRegId(Long regId){
        return securityDao.findAllEmployeesByRegId(regId);
    }

    @Transactional
    public Employee insertOrUpdateEmployee(Employee emp) {
        return securityDao.insertOrUpdateEmployee(emp);
    }

    @Transactional
    public Employee findEmployee(Long empId) {
        return securityDao.findEmployee(empId);
    }

    @Transactional
    public boolean deleteEmployee(Long empId) {
        return securityDao.deleteEmployee(empId);
    }

    @Transactional
    public List<Client> findAllClients() {
        return securityDao.findAllClients();
    }
    
    @Transactional
    public List<Client> findAllClientByRegId(Long regId) {
        return securityDao.findAllClientByRegId(regId);
    }

    @Transactional
    public Client insertOrUpdateClient(Client client) {
        return securityDao.insertOrUpdateClient(client);
    }

    @Transactional
    public Client findClient(Long clientId) {
        return securityDao.findClient(clientId);
    }

    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public boolean deleteClient(Long clientId) {
        return securityDao.deleteClient(clientId);
    }


    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Serviceregistration insertOrUpdateServiceReg(Serviceregistration serviceReg) {
        return securityDao.insertOrUpdateServiceReg(serviceReg);
    }

    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public boolean deleteServiceReg(Long regId) {
        return securityDao.deleteServiceReg(regId);
    }

    @Transactional
    public List<Serviceregistration> findAllServiceRegs() {
        List<Serviceregistration> regs = securityDao.findAllServiceRegs();
        return regs;
    }

    @Transactional
    public Serviceregistration findServiceReg(Long regId) {
        return securityDao.findServiceReg(regId);
    }
    
    @Transactional
    public Serviceregistration findServiceRegByUsername(String username) {
        return securityDao.findServiceRegByUsername(username);
    }

    @Transactional
    public Userprofile insertOrUpdateUserProfile(Userprofile userProfile) {
        return securityDao.insertOrUpdateUserProfile(userProfile);
    }

    @Transactional
    public boolean deleteUserProfile(Long userId) {
        return securityDao.deleteUserProfile(userId);
    }

    @Transactional
    public List<Userprofile> findAllUserProfiles() {
        return securityDao.findAllUserProfiles();
    }

    @Transactional
    public Userprofile findUserProfile(Long userId) {
        return securityDao.findUserProfile(userId);
    }
}
