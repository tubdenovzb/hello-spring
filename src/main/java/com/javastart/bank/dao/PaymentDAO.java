package com.javastart.bank.dao;

import com.javastart.bank.entity.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentDAO {

    private final SessionFactory sessionFactory;

    public PaymentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Payment save(Payment payment) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(payment);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return payment;
    }

    public Payment findById(Long paymentId) {
        Session session = sessionFactory.openSession();
        Payment payment = session.find(Payment.class, paymentId);
        session.close();
        return payment;
    }
}