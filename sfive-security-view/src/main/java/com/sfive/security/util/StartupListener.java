package com.sfive.security.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class StartupListener implements ServletContextListener {
    public StartupListener() {
        super();
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {    
        Logger logger = null;
        String log4jFile = servletContextEvent.getServletContext().getInitParameter("log4jFileName");
        DOMConfigurator.configure(servletContextEvent.getServletContext().getRealPath(log4jFile));
        logger = LogManager.getLogger(StartupListener.class.getName());
        logger.debug("Loaded: " + log4jFile);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}

