package com.javastart.bank.dao;

import com.javastart.bank.entity.Transfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class TransferDAO {

    private final SessionFactory sessionFactory;

    public TransferDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Transfer save(Transfer transfer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(transfer);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return transfer;
    }

    public Transfer findById(Long transferId) {
        Session session = sessionFactory.openSession();
        Transfer transfer = session.find(Transfer.class, transferId);
        session.close();
        return transfer;
    }
}