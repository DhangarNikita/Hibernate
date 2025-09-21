package org.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
        Session s = factory.openSession();

        Question q = s.get(Question.class,1);
        System.out.println(q);

        /*System.out.println(q.getQuestion());
        System.out.println(q.getAnswer().getAnswer());*/

    }
}
