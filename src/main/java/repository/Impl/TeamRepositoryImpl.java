package repository.Impl;

import model.Developer;
import model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.TeamRepository;

import java.util.List;

public class TeamRepositoryImpl implements TeamRepository {
    private static SessionFactory sessionFactory;

    public TeamRepositoryImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Team save(Team team) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(team);
        transaction.commit();
        session.close();
        return team;
    }

    @Override
    public Team getById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Team team = session.get(Team.class, id);
        transaction.commit();
        session.close();
        return team;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Team team = session.get(Team.class, id);
        session.delete(team);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Team> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Team> teams = session.createQuery("FROM Team").list();

        transaction.commit();
        session.close();
        return teams;
    }

    @Override
    public Team update(Team team) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Team team1 = session.get(Team.class, team.getId());
        team1.setName(team.getName());
        team1.setTeamStatus(team.getTeamStatus());
        team1.setDevelopers(team.getDevelopers());

        session.update(team1);
        transaction.commit();
        session.close();
        return team1;
    }
}
