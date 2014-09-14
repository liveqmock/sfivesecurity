package com.sfive.security.webservice;


import com.sfive.security.domain.Userprofile;
import com.sfive.security.service.SecurityService;
import com.sfive.security.util.SpringBeanConfig;
import com.sfive.security.view.UserProfileView;

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


@Path("userprofilesrvc")
public class UserProfileWebservice {

    @GET
    @Path("users")
    @Produces( { MediaType.APPLICATION_JSON })
    public List<UserProfileView> getUserProfiles() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        List<Userprofile> userProfiles = securityService.findAllUserProfiles();
        List<UserProfileView> userProfileViewList = new ArrayList<UserProfileView>();
        for (Userprofile profile : userProfiles) {
            UserProfileView profileView = new UserProfileView();
            profileView.setUserId(profile.getUserId());
            profileView.setFirstname(profile.getFirstname());
            profileView.setLastname(profile.getLastname());
            profileView.setAddress1(profile.getAddress1());
            profileView.setAddress2(profile.getAddress2());
            profileView.setCity(profile.getCity());
            profileView.setPassword(profile.getPassword());
            profileView.setPhone1(profile.getPhone1());
            profileView.setPhone2(profile.getPhone2());
            profileView.setPincode(profile.getPincode());
            profileView.setRegId(profile.getServiceregistration().getRegId());
            profileView.setState(profile.getState());
            profileView.setUsername(profile.getUsername());
            userProfileViewList.add(profileView);
        }
        return userProfileViewList;
    }

    @GET
    @Path("user/{profileId}")
    @Produces( { MediaType.APPLICATION_JSON })
    public UserProfileView getUserProfile(@PathParam("profileId")
        Long profileId) {
        System.out.println("inside getUserProfile");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        Userprofile profile = securityService.findUserProfile(profileId);
        UserProfileView profileView = new UserProfileView();

        profileView.setUserId(profile.getUserId());
        profileView.setFirstname(profile.getFirstname());
        profileView.setLastname(profile.getLastname());
        profileView.setAddress1(profile.getAddress1());
        profileView.setAddress2(profile.getAddress2());
        profileView.setCity(profile.getCity());
        profileView.setPassword(profile.getPassword());
        profileView.setPhone1(profile.getPhone1());
        profileView.setPhone2(profile.getPhone2());
        profileView.setPincode(profile.getPincode());
        profileView.setRegId(profile.getServiceregistration().getRegId());
        profileView.setState(profile.getState());
        profileView.setUsername(profile.getUsername());
        return profileView;
    }

    @POST
    @Path("user")
    @Consumes( { "application/xml", "application/json" })
    public String createOrUpdateUser(UserProfileView profileView) {
        System.out.println("inside createOrUpdate UserProfile");
        Userprofile profile = new Userprofile();
        try {
            if (profileView != null) {
                System.out.println(profileView.toString());
                ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
                SecurityService securityService = (SecurityService)context.getBean("securityService");
                
                profile.setUserId(profileView.getUserId());
                profile.setFirstname(profileView.getFirstname());
                profile.setLastname(profileView.getLastname());
                profile.setAddress1(profileView.getAddress1());
                profile.setAddress2(profileView.getAddress2());
                profile.setCity(profileView.getCity());
                profile.setPassword(profileView.getPassword());
                profile.setPhone1(profileView.getPhone1());
                profile.setPhone2(profileView.getPhone2());
                profile.setPincode(profileView.getPincode());
                profile.setServiceregistration(securityService.findServiceReg(profileView.getRegId()));
                profile.setState(profileView.getState());
                profile.setUsername(profileView.getUsername());

                profile = securityService.insertOrUpdateUserProfile(profile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(profile.getUserId());
    }

    @DELETE
    @Path("user/{profileId}")
    public void deleteUserprofile(@PathParam("profileId")
        Long profileId) {
        System.out.println("inside delete service method");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        SecurityService securityService = (SecurityService)context.getBean("securityService");
        boolean flag = securityService.deleteUserProfile(profileId);
        System.out.println("Delete Status" + flag);
    }
}
