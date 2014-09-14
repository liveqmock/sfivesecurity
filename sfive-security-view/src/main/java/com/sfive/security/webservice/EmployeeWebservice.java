package com.sfive.security.webservice;


import com.sfive.security.domain.Employee;
import com.sfive.security.service.SecurityService;
import com.sfive.security.util.SpringBeanConfig;
import com.sfive.security.view.EmployeeView;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Path("employeesrvc")
public class EmployeeWebservice {
    
    @GET
    @Path("emps")
    @Produces( { MediaType.APPLICATION_JSON })
    public List<EmployeeView> getEmployees() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        List<Employee> employees = securityService.findAllEmployees();
        List<EmployeeView> employeeViewList = new ArrayList<EmployeeView>();
        for (Employee emp : employees) {
            EmployeeView empView = new EmployeeView();
            empView.setFirstname(emp.getFirstname());
            empView.setLastname(emp.getLastname());
            empView.setAge(emp.getAge());
            empView.setAddress1(emp.getAddress1());
            empView.setAddress2(emp.getAddress2());
            empView.setCity(emp.getCity());
            empView.setState(emp.getState());
            empView.setPincode(emp.getPincode());
            empView.setPhone1(emp.getPhone1());
            empView.setPhone2(emp.getPhone2());
            empView.setPhoto(emp.getPhoto());
            empView.setEmpId(emp.getEmpId());
            empView.setRfirstname(emp.getRfirstname());
            empView.setRlastname(emp.getRlastname());
            empView.setRphone(emp.getRphone());
            empView.setSex(emp.getSex());
            empView.setRegId(emp.getServiceregistration().getRegId());
            employeeViewList.add(empView);
        }
        return employeeViewList;
    }
    
    @GET
    @Path("regemps/{regId}")
    @Produces( { MediaType.APPLICATION_JSON })
    public List<EmployeeView> getEmployeesByRegId(@PathParam("regId") Long regId) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        List<Employee> employees = securityService.findAllEmployeesByRegId(regId);
        List<EmployeeView> employeeViewList = new ArrayList<EmployeeView>();
        for (Employee emp : employees) {
            EmployeeView empView = new EmployeeView();
            empView.setFirstname(emp.getFirstname());
            empView.setLastname(emp.getLastname());
            empView.setAge(emp.getAge());
            empView.setAddress1(emp.getAddress1());
            empView.setAddress2(emp.getAddress2());
            empView.setCity(emp.getCity());
            empView.setState(emp.getState());
            empView.setPincode(emp.getPincode());
            empView.setPhone1(emp.getPhone1());
            empView.setPhone2(emp.getPhone2());
            empView.setPhoto(emp.getPhoto());
            empView.setEmpId(emp.getEmpId());
            empView.setRfirstname(emp.getRfirstname());
            empView.setRlastname(emp.getRlastname());
            empView.setRphone(emp.getRphone());
            empView.setSex(emp.getSex());
            empView.setRegId(emp.getServiceregistration().getRegId());
            employeeViewList.add(empView);
        }
        return employeeViewList;
    }

    @GET
    @Path("emp/{empId}")
    @Produces( { MediaType.APPLICATION_JSON })
    public EmployeeView getEmployee(@PathParam("empId")
        Long empId) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        Employee emp = securityService.findEmployee(empId);
        EmployeeView empView = new EmployeeView();
        empView.setFirstname(emp.getFirstname());
        empView.setLastname(emp.getLastname());
        empView.setAge(emp.getAge());
        empView.setAddress1(emp.getAddress1());
        empView.setAddress2(emp.getAddress2());
        empView.setCity(emp.getCity());
        empView.setState(emp.getState());
        empView.setPincode(emp.getPincode());
        empView.setPhone1(emp.getPhone1());
        empView.setPhone2(emp.getPhone2());
        empView.setPhoto(emp.getPhoto());
        empView.setEmpId(emp.getEmpId());
        empView.setRfirstname(emp.getRfirstname());
        empView.setRlastname(emp.getRlastname());
        empView.setRphone(emp.getRphone());
        empView.setSex(emp.getSex());
        empView.setRegId(emp.getServiceregistration().getRegId());
        return empView;
    }

    @POST
    @Path("emp")
    @Consumes( { "application/xml", "application/json" })
    public String createOrUpdateEmployee(EmployeeView employeeView) {
        Employee emp = new Employee();
        try {
            if (employeeView != null) {
                System.out.println(employeeView.toString());
                ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
                SecurityService securityService = (SecurityService)context.getBean("securityService");
                emp.setFirstname(employeeView.getFirstname());
                emp.setLastname(employeeView.getLastname());
                emp.setAge(employeeView.getAge());
                emp.setAddress1(employeeView.getAddress1());
                emp.setAddress2(employeeView.getAddress2());
                emp.setCity(employeeView.getCity());
                emp.setState(employeeView.getState());
                emp.setPincode(employeeView.getPincode());
                emp.setPhone1(employeeView.getPhone1());
                emp.setPhone2(employeeView.getPhone2());
                emp.setPhoto(employeeView.getPhoto());
                emp.setEmpId(employeeView.getEmpId());
                emp.setRfirstname(employeeView.getRfirstname());
                emp.setRlastname(employeeView.getRlastname());
                emp.setRphone(employeeView.getRphone());
                emp.setSex(employeeView.getSex());
                emp.setServiceregistration(securityService.findServiceReg(employeeView.getRegId()));
                emp = securityService.insertOrUpdateEmployee(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(emp.getEmpId());
    }

    @DELETE
    @Path("employee/{empId}")
    public void deleteEmployee(@PathParam("empId")
        Long empId) {
        System.out.println("inside delete service method");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        boolean flag = securityService.deleteEmployee(empId);
        System.out.println("Delete Status" + flag);
    }
}
