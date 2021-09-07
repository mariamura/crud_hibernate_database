package repository.Impl;

import model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.SkillRepository;

import javax.management.Query;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {

    private static SessionFactory sessionFactory;

    public SkillRepositoryImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Skill save(Skill skill) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        session.close();
        return skill;
    }

    @Override
    public Skill getById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Query query = (Query) session.createQuery("FROM Skill s where s.id=" + id);


        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Skill> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Skill> skills = session.createQuery("FROM Skill").list();

        transaction.commit();
        session.close();
        return skills;
    }

    @Override
    public Skill update(Skill skill) {
        return null;
    }
}
