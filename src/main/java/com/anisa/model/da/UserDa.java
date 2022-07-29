package com.anisa.model.da;

import com.anisa.model.entity.User;
import com.anisa.provider.HibernateProviderXml;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class UserDa {

    private SessionFactory sessionFactory;

    public UserDa() {
        sessionFactory= HibernateProviderXml.getSessionFactory();
    }

    public void insertUser(User user)
    {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
    public List<User> getUser(){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery(" from User  where gender='0' order by age desc ");
        List<User> list= (List<User>) query.stream().collect(Collectors.toList());
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public  List<User> getMan(){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery(" from User  where gender='1' and age between 40 and 50 and name like 'a%'");
        List<User> list= (List<User>) query.stream().collect(Collectors.toList());
        session.getTransaction().commit();
        session.close();
        return list;
    }



}
