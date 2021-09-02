package repository.Impl;

import model.Team;
import org.hibernate.SessionFactory;
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
        return null;
    }

    @Override
    public Team getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Team> getAll() {
        return null;
    }

    @Override
    public Team update(Team team) {
        return null;
    }
}
