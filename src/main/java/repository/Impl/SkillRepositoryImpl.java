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
        Transaction transaction = session.beginTransaction();
        Skill skill = session.get(Skill.class, id);
        transaction.commit();
        session.close();
        return skill;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Skill skill = session.get(Skill.class, id);
        session.delete(skill);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Skill> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Skill> skills = session.createQuery("FROM Skill").list();
        transaction.commit();
        session.close();
        return skills;
    }

    @Override
    public Skill update(Skill skill) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Skill skill1 = session.get(Skill.class, skill.getId());
        skill1.setName(skill.getName());
        session.update(skill1);
        transaction.commit();
        session.close();
        return skill1;
    }
}
