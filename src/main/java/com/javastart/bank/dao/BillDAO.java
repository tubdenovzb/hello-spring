package com.javastart.bank.dao;

import com.javastart.bank.entity.Bill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class BillDAO {

    private final SessionFactory sessionFactory;

    public BillDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Bill save(Bill bill) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(bill);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return bill;
    }

    public Bill findById(Long id) {
        Session session = sessionFactory.openSession();
        Bill bill = session.find(Bill.class, id);
        session.close();
        return bill;
    }

    public Bill payment(Long billId, Integer amountOfPayment) {
        Session session = sessionFactory.openSession();
        Bill bill = session.find(Bill.class, billId);
        session.beginTransaction();
        bill.setAmount(bill.getAmount() - amountOfPayment);
        Bill billAfterPayment = (Bill) session.merge(bill);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return billAfterPayment;
    }

    public Bill adjustment(Long billId, Integer amountOfAdjustment) {
        Session session = sessionFactory.openSession();
        Bill bill = session.find(Bill.class, billId);
        session.beginTransaction();
        bill.setAmount(bill.getAmount() + amountOfAdjustment);
        Bill billAfterAdjustment = (Bill) session.merge(bill);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return billAfterAdjustment;
    }
}