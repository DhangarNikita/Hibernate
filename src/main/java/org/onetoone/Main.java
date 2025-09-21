package org.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();

        Answer a1 = new Answer();
        a1.setId(101);
        a1.setAnswer("Java is programming language");

        Question q1 = new Question();
        a1.setQuestion(q1);
        q1.setId(1);
        q1.setQuestion("What is java");
        q1.setAnswer(a1);

        Session s = factory.openSession();

        Transaction t = s.beginTransaction();

        s.save(a1);
        s.save(q1);
        t.commit();

        s.close();
        factory.close();

    }
}
