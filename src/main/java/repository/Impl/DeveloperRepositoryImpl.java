package repository.Impl;

import model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.DeveloperRepository;

import java.util.List;


public class DeveloperRepositoryImpl implements DeveloperRepository {
    private static SessionFactory sessionFactory;

    public DeveloperRepositoryImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Developer save(Developer developer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
        return developer;
    }

    @Override
    public Developer getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Developer> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Developer> developers = session.createQuery("FROM Developer").list();

        transaction.commit();
        session.close();
        return developers;
    }

    @Override
    public Developer update(Developer developer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        session.update(developer);
        transaction.commit();
        session.close();
        return developer;
    }
}
