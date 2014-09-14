package com.sfive.security.util;


import com.sfive.security.service.SecurityService;
import com.sfive.security.service.SecurityServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * Java container based spring configuration class for Letter correspondence service application.
 * @author tgd2g
 * Repository path  :  $HeadURL: $
 * Last committed   :  $Revision: $
 * Last changed by  :  $Author: $
 * Last changed date:  $Date: $
 */
@Configuration
@ImportResource("classpath:appContext.xml")
public class SpringBeanConfig {

    @Bean(name = "securityService")
    public SecurityService letterCorrespondenceService() {
        return new SecurityServiceImpl();
    }
}

