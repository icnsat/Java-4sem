package org.example;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class DepartureService {
    private final SessionFactory sessionFactory;
    private Session session;

    public DepartureService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void init(){
        session = sessionFactory.openSession();
    }

    public PostOffice getPostOfficeByDeparture(Long departureId) {
        PostOffice office = session.createQuery("from Departure where id = :id", Departure.class).setParameter("id", departureId).getSingleResult().getPostOffice();
        return office;
    }

    public void create(Departure departure) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(departure);
        transaction.commit();
    }


    public List<Departure> readAll() {
        List<Departure> departures = session.createQuery("select u from Departure u", Departure.class).getResultList();
        return departures;
    }

    public Departure read(long id) {
        Departure departure = session.createQuery("from Departure where id = :id", Departure.class).setParameter("id", id).getSingleResult();
        return departure;
    }


    public boolean delete(long id) {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Departure where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        return true;
    }

    public List<Departure> filterByType(String type) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Departure> departureCriteriaQuery = builder.createQuery(Departure.class);
        Root<Departure> root = departureCriteriaQuery.from(Departure.class);

        departureCriteriaQuery.select(root).where(builder.equal(root.get("type"),type));

        Query<Departure> query = session.createQuery(departureCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void stop(){
        session.close();
    }
}

