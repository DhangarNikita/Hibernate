package org.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();

        Student1 student = new Student1();
        student.setEmail("dhangarnikita13@gmail.com");
        student.setName("Nikita Dhangar");
        student.setPassword("nikita");
        student.setGender("Female");
        student.setCity("Pune");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        // create
        //session.save(student);
       //tx.commit();

        //get
        //Student1 st = session.load(Student1.class,1);

        Student1 st = session.get(Student1.class,1);
        System.out.println(st);


        // update
        Student1 s = session.get(Student1.class,1);
        s.setCity("Mumbai");
        session.update(s);
        tx.commit();

        //delete
        Student1 sd = session.get(Student1.class,1);
        session.delete(sd);
        tx.commit();

    }
}
