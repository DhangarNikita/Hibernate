package org.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();

        Student s = new Student();
        s.setName("Nikita");
        s.setCity("Pune");


       Course c = new Course();
       c.setStudent(s);
       c.setCourse("java");

       Course c1 = new Course();
       c1.setStudent(s);
       c1.setCourse("Python");

       List<Course> list = new ArrayList<>();
       list.add(c);
       list.add(c1);

       s.setCourse(list);


        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.save(s);
        session.save(c);
        session.save(c1);
        t.commit();

        session.close();
        factory.close();


    }
}
