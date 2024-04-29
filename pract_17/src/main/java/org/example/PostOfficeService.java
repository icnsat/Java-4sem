package org.example;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    @PostConstruct
    public void init(){
        session = sessionFactory.openSession();
    }

    public void create(PostOffice postOffice) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(postOffice);
        transaction.commit();
    }


    public List<PostOffice> readAll() {
        List<PostOffice> offices = session.createQuery("select u from PostOffice u", PostOffice.class).getResultList();
        for (PostOffice office : offices) Hibernate.initialize(office.getDepartures());
        return offices;
    }

    public PostOffice read(long id) {
        PostOffice office = session.createQuery("from PostOffice where id = :id", PostOffice.class).setParameter("id", id).getSingleResult();
        return office;
    }


    public boolean delete(long id) {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from PostOffice where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        return true;
    }

    public List<PostOffice> filterByName(String name) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PostOffice> postOfficeCriteriaQuery = builder.createQuery(PostOffice.class);
        Root<PostOffice> root = postOfficeCriteriaQuery.from(PostOffice.class);

        postOfficeCriteriaQuery.select(root).where(builder.equal(root.get("name"),name));

        Query<PostOffice> query = session.createQuery(postOfficeCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void stop(){
        session.close();
    }
}

