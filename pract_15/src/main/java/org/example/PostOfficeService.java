package org.example;


import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PostOfficeService {
    private final SessionFactory sessionFactory;
    private Session session;

    public PostOfficeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(PostOffice postOffice) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(postOffice);
        transaction.commit();
        session.close();
    }


    public List<PostOffice> readAll() {
        session = sessionFactory.openSession();
        List<PostOffice> offices = session.createQuery("select u from PostOffice u", PostOffice.class).getResultList();
        session.close();
        return offices;
    }

    public PostOffice read(long id) {
        session = sessionFactory.openSession();
        PostOffice office = session.createQuery("from PostOffice where id = :id", PostOffice.class).setParameter("id", id).getSingleResult();
        session.close();
        return office;
    }


    public boolean delete(long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from PostOffice where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }
}

