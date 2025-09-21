package org.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
        Session session = factory.openSession();
        Student s = session.get(Student.class,1);

        System.out.println(s.getName());

        for(Course c : s.getCourse()){
            System.out.println(c.getCourse());
        }
    }
}
