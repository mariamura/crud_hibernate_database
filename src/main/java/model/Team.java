package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity(name = "Team")
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTeam")
    private Long id;

    @Column(name = "teamName")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Developer> developers;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 8)
    private TeamStatus teamStatus;

    public Team(Long id, String name, List<Developer> developers, TeamStatus teamStatus) {
        this.id = id;
        this.name = name;
        this.developers = developers;
        this.teamStatus = teamStatus;
    }

    public Team(Long id, String name, TeamStatus teamStatus) {
        this.id = id;
        this.name = name;
        this.teamStatus = teamStatus;
    }

    public Team(String name, TeamStatus teamStatus) {
        this.name = name;
        this.teamStatus = teamStatus;
    }

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Developer> getDevelopers() {
        return this.developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public TeamStatus getTeamStatus() {
        return this.teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers +
                ", teamStatus=" + teamStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(getId(), team.getId()) && Objects.equals(getName(), team.getName()) && Objects.equals(getDevelopers(), team.getDevelopers()) && getTeamStatus() == team.getTeamStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDevelopers(), getTeamStatus());
    }
}
