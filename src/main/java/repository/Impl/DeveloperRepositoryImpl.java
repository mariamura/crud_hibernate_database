package repository.Impl;

import model.Developer;
import model.Skill;
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
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
        return developer;
    }

    @Override
    public Developer getById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        transaction.commit();
        session.close();
        return developer;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        session.delete(developer);
        transaction.commit();
        session.close();
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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Developer developer1 = session.get(Developer.class, developer.getId());
        developer1.setFirstName(developer.getFirstName());
        developer1.setLastName(developer.getLastName());
        developer1.setSkills(developer.getSkills());

        session.update(developer);
        transaction.commit();
        session.close();
        return developer1;
    }
}
