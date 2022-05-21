package com.javastart.bank.dao;

import com.javastart.bank.entity.Adjustment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class AdjustmentDAO {

    private final SessionFactory sessionFactory;

    public AdjustmentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Adjustment save(Adjustment adjustment) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(adjustment);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return adjustment;
    }

    public Adjustment findById(Long adjustmentId) {
        Session session = sessionFactory.openSession();
        Adjustment adjustment = session.find(Adjustment.class, adjustmentId);
        session.close();
        return adjustment;
    }
}