package com.sfive.security.webservice;


import com.sfive.security.domain.Serviceregistration;
import com.sfive.security.service.SecurityService;
import com.sfive.security.util.SpringBeanConfig;
import com.sfive.security.view.ServiceRegistrationView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Path("subscriptionsrvc")
public class SubscriptionWebservice {
    
    @GET
    @Path("subscriptions")
    @Produces( { MediaType.APPLICATION_JSON })
    public List<ServiceRegistrationView> getSubscriptions(@Context
        HttpServletResponse response) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        List<Serviceregistration> regs = securityService.findAllServiceRegs();
        List<ServiceRegistrationView> regsViews = new ArrayList<ServiceRegistrationView>();  
        for(Serviceregistration reg : regs){
            ServiceRegistrationView regView = new ServiceRegistrationView();
            regView.setRegId(reg.getRegId());
            regView.setCompanyname(reg.getCompanyname());
            regView.setAddress1(reg.getAddress1());
            regView.setAddress2(reg.getAddress2());
            regView.setCity(reg.getCity());
            regView.setState(reg.getState());
            regView.setPincode(reg.getPincode());
            regView.setEmail(reg.getEmail());
            regView.setPhone1(reg.getPhone1());
            regView.setPhone2(reg.getPhone2());
            regView.setFax(reg.getFax());
            regView.setUsername(reg.getUsername());
            regView.setRole(reg.getRole());
            regView.setPassword(reg.getPassword());
            regsViews.add(regView);
        }
        return regsViews;
    }
    
    @GET
    @Path("subscription/{regId}")
    @Produces( { MediaType.APPLICATION_JSON })
    public ServiceRegistrationView getSubscription(@PathParam("regId") Long regId) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        Serviceregistration reg = securityService.findServiceReg(regId);
        ServiceRegistrationView serviceRegistrationView = new ServiceRegistrationView();
        serviceRegistrationView.setCompanyname(reg.getCompanyname());
        serviceRegistrationView.setRegId(reg.getRegId());
        serviceRegistrationView.setAddress1(reg.getAddress1());
        serviceRegistrationView.setAddress2(reg.getAddress2());
        serviceRegistrationView.setCity(reg.getCity());
        serviceRegistrationView.setState(reg.getState());
        serviceRegistrationView.setPincode(reg.getPincode());
        serviceRegistrationView.setPhone1(reg.getPhone1());
        serviceRegistrationView.setPhone2(reg.getPhone2());
        serviceRegistrationView.setEmail(reg.getEmail());
        serviceRegistrationView.setFax(reg.getFax());
        serviceRegistrationView.setUsername(reg.getUsername());
        serviceRegistrationView.setRole(reg.getRole());
        serviceRegistrationView.setPassword(reg.getPassword());
        return serviceRegistrationView;
    }
    
    @GET
    @Path("user/{username}")
    @Produces( { MediaType.APPLICATION_JSON })
    public ServiceRegistrationView getSubscriptionByUsername(@PathParam("username") String username) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        Serviceregistration reg = securityService.findServiceRegByUsername(username);
        ServiceRegistrationView serviceRegistrationView = new ServiceRegistrationView();
        serviceRegistrationView.setCompanyname(reg.getCompanyname());
        serviceRegistrationView.setRegId(reg.getRegId());
        serviceRegistrationView.setAddress1(reg.getAddress1());
        serviceRegistrationView.setAddress2(reg.getAddress2());
        serviceRegistrationView.setCity(reg.getCity());
        serviceRegistrationView.setState(reg.getState());
        serviceRegistrationView.setPincode(reg.getPincode());
        serviceRegistrationView.setPhone1(reg.getPhone1());
        serviceRegistrationView.setPhone2(reg.getPhone2());
        serviceRegistrationView.setEmail(reg.getEmail());
        serviceRegistrationView.setFax(reg.getFax());
        serviceRegistrationView.setUsername(reg.getUsername());
        serviceRegistrationView.setRole(reg.getRole());
        serviceRegistrationView.setPassword(reg.getPassword());
        return serviceRegistrationView;
    }

    @POST
    @Path("subscription")
    @Consumes({"application/xml", "application/json"})
    public String createOrUpdateSubscription(ServiceRegistrationView serviceregistrationView) {

        Serviceregistration serviceRegistration = new Serviceregistration();
        Serviceregistration serviceRegistrationNew = new Serviceregistration();
        try {
            if(serviceregistrationView != null){
                System.out.println(serviceregistrationView.toString());
            ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
            SecurityService securityService = (SecurityService)context.getBean("securityService");
            serviceRegistration.setCompanyname(serviceregistrationView.getCompanyname());
            serviceRegistration.setRegId(serviceregistrationView.getRegId());
            serviceRegistration.setAddress1(serviceregistrationView.getAddress1());
            serviceRegistration.setAddress2(serviceregistrationView.getAddress2());
            serviceRegistration.setCity(serviceregistrationView.getCity());
            serviceRegistration.setState(serviceregistrationView.getState());
            serviceRegistration.setPincode(serviceregistrationView.getPincode());
            serviceRegistration.setPhone1(serviceregistrationView.getPhone1());
            serviceRegistration.setPhone2(serviceregistrationView.getPhone2());
            serviceRegistration.setEmail(serviceregistrationView.getEmail());
            serviceRegistration.setFax(serviceregistrationView.getFax());
            serviceRegistration.setUsername(serviceregistrationView.getUsername());
            serviceRegistration.setPassword(serviceregistrationView.getPassword());
            serviceRegistration.setRole(serviceregistrationView.getRole());
            serviceRegistrationNew = securityService.insertOrUpdateServiceReg(serviceRegistration);
            System.out.println(serviceRegistrationNew.getRegId());
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(serviceRegistrationNew.getRegId());
    }
    
    @DELETE
    @Path("subscription/{regId}")
    public void deleteSubscription(@PathParam("regId") Long regId){
        System.out.println("inside delete service method");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        System.out.println(securityService.deleteServiceReg(regId));
    }
    
}
