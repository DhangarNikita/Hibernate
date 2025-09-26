package org.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();

        Emp e = new Emp();
        e.setId(101);
        e.setName("Nikita");

        Emp e1 = new Emp();
        e1.setId(102);
        e1.setName("Sneha");

        Emp e2 = new Emp();
        e2.setId(103);
        e2.setName("Ruchita");

        Project p = new Project();
        p.setPid(201);
        p.setProjectName("Java");

        Project p1 = new Project();
        p1.setPid(202);
        p1.setProjectName("C++");

        List<Emp> list = new ArrayList<>();
        list.add(e);
        list.add(e1);
        list.add(e2);

        List <Project> list1 = new ArrayList<>();
        list1.add(p);
        list1.add(p1);

        e.setProjects(list1);
        e1.setProjects(list1);
        e2.setProjects(list1);

        p.setEmp(list);
        p1.setEmp(list);

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.save(e);
        session.save(e1);
        session.save(e2);

        session.save(p);
        session.save(p1);

        t.commit();
    }
}
