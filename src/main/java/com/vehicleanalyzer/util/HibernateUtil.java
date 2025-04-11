package com.vehicleanalyzer.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }


        return sessionFactory;
    }
}
