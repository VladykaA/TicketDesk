package com.dom;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class CriteriaService {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("trip_service");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        DateAndTime dateAndTime = new DateAndTime();
        Trip trip1 = new Trip(11,false,"2 hours", CityRun.ODESSA, CityRun.KIEV);
        trip1.setDateAndTime(dateAndTime);

        em.persist(trip1);

        transaction.commit();
        em.close();
        factory.close();
    }
}

class MyCriteriaSelect{
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("trip_service");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root<Trip> root = query.from(Trip.class);
        CriteriaQuery<Trip> select = query.select(root);
        Query allTrips = em.createQuery(select);

        List<Trip> list = allTrips.getResultList();
        list.forEach(System.out::println);

        transaction.commit();
        em.close();
    }
}

class MyCriteriaDelete{
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("trip_service");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<Trip> delete = builder.createCriteriaDelete(Trip.class);
        Root<Trip> root = delete.from(Trip.class);
        Path<Integer> path = root.get(Trip_.id);
        delete.where(builder.equal(path, 1));
        em.createQuery(delete).executeUpdate();

        transaction.commit();
        em.close();
    }
}
