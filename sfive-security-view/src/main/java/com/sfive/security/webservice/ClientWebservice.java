package com.sfive.security.webservice;


import com.sfive.security.domain.Client;
import com.sfive.security.service.SecurityService;
import com.sfive.security.util.SpringBeanConfig;
import com.sfive.security.view.ClientView;

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


@Path("clientsrvc")
public class ClientWebservice {
    @GET
    @Path("clients")
    @Produces( { MediaType.APPLICATION_JSON })
    public List<ClientView> getClients() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        List<Client> clients = securityService.findAllClients();
        List<ClientView> clientViews = new ArrayList<ClientView>();

        for (Client client : clients) {
            ClientView clientView = new ClientView();
            clientView.setClientId(client.getClientId());
            clientView.setName(client.getName());
            clientView.setAddress1(client.getAddress1());
            clientView.setAddress2(client.getAddress2());
            clientView.setCity(client.getCity());
            clientView.setState(client.getState());
            clientView.setPincode(client.getPincode());
            clientView.setPhone1(client.getPhone1());
            clientView.setPhone2(client.getPhone2());
            clientView.setFax(client.getFax());
            clientView.setCpfirstname(client.getCpfirstname());
            clientView.setCplastname(client.getCplastname());
            clientView.setCpphone1(client.getCpphone1());
            clientView.setCpphone2(client.getCpphone2());
            clientView.setCpemail(client.getCpemail());
            clientView.setServiceRegId(client.getServiceregistration().getRegId());
            clientViews.add(clientView);
        }
        return clientViews;
    }
    
    @GET
    @Path("regclients/{regId}")
    @Produces( { MediaType.APPLICATION_JSON })
    public List<ClientView> getClientsByRegId(@PathParam("regId") Long regId) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        List<Client> clients = securityService.findAllClientByRegId(regId);
        List<ClientView> clientViews = new ArrayList<ClientView>();

        for (Client client : clients) {
            ClientView clientView = new ClientView();
            clientView.setClientId(client.getClientId());
            clientView.setName(client.getName());
            clientView.setAddress1(client.getAddress1());
            clientView.setAddress2(client.getAddress2());
            clientView.setCity(client.getCity());
            clientView.setState(client.getState());
            clientView.setPincode(client.getPincode());
            clientView.setPhone1(client.getPhone1());
            clientView.setPhone2(client.getPhone2());
            clientView.setFax(client.getFax());
            clientView.setCpfirstname(client.getCpfirstname());
            clientView.setCplastname(client.getCplastname());
            clientView.setCpphone1(client.getCpphone1());
            clientView.setCpphone2(client.getCpphone2());
            clientView.setCpemail(client.getCpemail());
            clientView.setServiceRegId(client.getServiceregistration().getRegId());
            clientViews.add(clientView);
        }
        return clientViews;
    }


    @GET
    @Path("client/{clientId}")
    @Produces( { MediaType.APPLICATION_JSON })
    public ClientView getClient(@PathParam("clientId")
        Long clientId) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        Client client = securityService.findClient(clientId);
        ClientView clientView = new ClientView();
        clientView.setClientId(client.getClientId());
        clientView.setName(client.getName());
        clientView.setAddress1(client.getAddress1());
        clientView.setAddress2(client.getAddress2());
        clientView.setCity(client.getCity());
        clientView.setState(client.getState());
        clientView.setPincode(client.getPincode());
        clientView.setPhone1(client.getPhone1());
        clientView.setPhone2(client.getPhone2());
        clientView.setFax(client.getFax());
        clientView.setCpfirstname(client.getCpfirstname());
        clientView.setCplastname(client.getCplastname());
        clientView.setCpphone1(client.getCpphone1());
        clientView.setCpphone2(client.getCpphone2());
        clientView.setCpemail(client.getCpemail());
        clientView.setServiceRegId(client.getServiceregistration().getRegId());
        return clientView;
    }

    @POST
    @Path("client")
    @Consumes( { "application/xml", "application/json" })
    public String createOrUpdateClient(ClientView clientView) {
        try {
            if (clientView != null) {
                System.out.println(clientView.toString());
                ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
                SecurityService securityService = (SecurityService)context.getBean("securityService");
                Client client = new Client();
                client.setClientId(clientView.getClientId());
                client.setName(clientView.getName());
                client.setAddress1(clientView.getAddress1());
                client.setAddress2(clientView.getAddress2());
                client.setCity(clientView.getCity());
                client.setState(clientView.getState());
                client.setPincode(clientView.getPincode());
                client.setPhone1(clientView.getPhone1());
                client.setPhone2(clientView.getPhone2());
                client.setFax(clientView.getFax());
                client.setCpfirstname(clientView.getCpfirstname());
                client.setCplastname(clientView.getCplastname());
                client.setCpphone1(clientView.getCpphone1());
                client.setCpphone2(clientView.getCpphone2());
                client.setCpemail(clientView.getCpemail());
                client.setServiceregistration(securityService.findServiceReg(clientView.getServiceRegId()));
                client = securityService.insertOrUpdateClient(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(clientView.getClientId());
    }

    @DELETE
    @Path("client/{clientId}")
    public void deleteClient(@PathParam("clientId")
        Long clientId) {
        System.out.println("inside delete service method");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        boolean flag = securityService.deleteClient(clientId);
        System.out.println("Delete Status" + flag);
    }
}
