package com.javastart.bank.dao;

import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Bill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private final SessionFactory sessionFactory;

    public AccountDAO(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
    }

    public Account save(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return account;
    }

    public Account findById(Long id) {
        Session session = sessionFactory.openSession();
        Account account = session.find(Account.class, id);
        session.close();
        return account;
    }

    public void update(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    public void addBill(Long id, Bill bill) {
        Session session = sessionFactory.openSession();
        Account account = session.find(Account.class, id);
        session.beginTransaction();
        account.getBills().add(bill);
        session.merge(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Account account = session.find(Account.class, id);
        session.beginTransaction();
        session.delete(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}