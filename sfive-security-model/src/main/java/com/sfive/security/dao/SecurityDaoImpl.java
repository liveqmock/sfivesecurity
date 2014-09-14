package com.sfive.security.dao;


import com.sfive.security.domain.Client;
import com.sfive.security.domain.Employee;
import com.sfive.security.domain.Serviceregistration;
import com.sfive.security.domain.Userprofile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class SecurityDaoImpl implements SecurityDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public SecurityDaoImpl() {
        super();
    }

   @Transactional
    public List<Employee> findAllEmployees() {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }
   
    @Transactional
     public List<Employee> findAllEmployeesByRegId(Long regId) {
         return em.createNamedQuery("Employee.findAllByRegId").setParameter("pRegId", regId).getResultList();
     }

    @Transactional
    public Employee insertOrUpdateEmployee(Employee emp) {
        
        try {
            emp = em.merge(emp);
        } catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }

    @Transactional
    public Employee findEmployee(Long empId) {
        return (Employee) em.createNamedQuery("Employee.findById").setParameter("pEmpId", empId).getSingleResult();
    }

    @Transactional
    public boolean deleteEmployee(Long empId) {
        boolean deleteFlag = Boolean.TRUE;
        try {
            Employee emp = em.find(Employee.class, empId);
            em.remove(emp);
        } catch(Exception e){
            e.printStackTrace();
            deleteFlag = Boolean.FALSE;
        }
        return deleteFlag;
    }

    @Transactional
    public List<Client> findAllClients() {
        return em.createNamedQuery("Client.findAll").getResultList();
    }
    
    @Transactional
    public List<Client> findAllClientByRegId(Long regId) {
        return em.createNamedQuery("Client.findAllByRegId").setParameter("pRegId", regId).getResultList();
    }

    @Transactional
    public Client insertOrUpdateClient(Client client) {
        try {
           client =  em.merge(client);
        } catch(Exception e){
            e.printStackTrace();
        }
        return client;
    }

    @Transactional
    public Client findClient(Long clientId) {
        return (Client) em.createNamedQuery("Client.findById").setParameter("pClientId", clientId).getSingleResult();
    }

    @Transactional
    public boolean deleteClient(Long clientId) {
        boolean deleteFlag = Boolean.TRUE;
        try {
            Client client = em.find(Client.class, clientId);
            em.remove(client);
        } catch(Exception e){
            e.printStackTrace();
            deleteFlag = Boolean.FALSE;
        }
        return deleteFlag;
    }

    @Transactional
    public Serviceregistration insertOrUpdateServiceReg(Serviceregistration serviceReg) {
        try {
          serviceReg = em.merge(serviceReg);
        } catch(Exception e){
           e.printStackTrace();
        }
        return serviceReg;
    }

    @Transactional
    public boolean deleteServiceReg(Long regId) {
        boolean deleteFlag = Boolean.TRUE;
        try {
            Serviceregistration reg = em.find(Serviceregistration.class, regId);
            em.remove(reg);
        } catch(Exception e){
            e.printStackTrace();
            deleteFlag = Boolean.FALSE;
        }
        return deleteFlag;
    }

    @Transactional
    public List<Serviceregistration> findAllServiceRegs() {
     return em.createNamedQuery("Serviceregistration.findAll").getResultList();
    }

    @Transactional
    public Serviceregistration findServiceReg(Long regId) {
        return (Serviceregistration) em.createNamedQuery("Serviceregistration.findById").setParameter("pRegId", regId).getSingleResult();
    }
    
    @Transactional
    public Serviceregistration findServiceRegByUsername(String username) {
        return (Serviceregistration) em.createNamedQuery("Serviceregistration.findByUsername").setParameter("pUsername", username).getSingleResult();
    }

    @Transactional
    public Userprofile insertOrUpdateUserProfile(Userprofile userProfile) {
        try {
           userProfile = em.merge(userProfile);
        } catch(Exception e){
            e.printStackTrace();
        }
        return userProfile;
    }
    
    @Transactional
    public Userprofile findUserProfile(Long userId) {
        return (Userprofile) em.createNamedQuery("Userprofile.findById").setParameter("pUserId", userId).getSingleResult();
    }

    @Transactional
    public boolean deleteUserProfile(Long userId) {
        boolean deleteFlag = Boolean.TRUE;
        try {
            Userprofile userProfile = em.find(Userprofile.class, userId);
            em.remove(userProfile);
        } catch(Exception e){
            e.printStackTrace();
            deleteFlag = Boolean.FALSE;
        }
        return deleteFlag;
    }

    @Transactional
    public List<Userprofile> findAllUserProfiles() {
        return em.createNamedQuery("Userprofile.findAll").getResultList();
    }

    
}
