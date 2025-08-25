package com.walker.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.walker.hibernate.entity.Address;
import com.walker.hibernate.entity.Employee;
import com.walker.hibernate.entity.Street;

public class EmployeeTest {
    public static void main(String[] args) {
        // Create Street objects
        Street street1 = new Street("B-12", "Marine Drive Road");
        Street street2 = new Street("45", "MG Road");

        // Create Address objects  
        Address address1 = new Address("Mumbai", "Maharashtra", street1);
        Address address2 = new Address("Bengaluru", "Karnataka", street2);

        Employee employee1 = new Employee(null, "Rajesh Kumar", address1, 0);
        Employee employee2 = new Employee(null, "Priya Sharma", address2, 0);
        
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session openSession = sessionFactory.openSession();
        openSession.getTransaction().begin();
        
        openSession.persist(employee1);
        openSession.persist(employee2);
        
        openSession.getTransaction().commit();
        

        System.out.println("Employee 1 ID: " + employee1.getId());
        System.out.println("Employee 2 ID: " + employee2.getId());
        
        openSession.close();
        sessionFactory.close();
    }
}