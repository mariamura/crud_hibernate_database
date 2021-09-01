package view;

import DButils.DBUtil;
import controller.TeamController;
import model.ConsoleMessage;
import model.TeamStatus;
import repository.jdbcImpl.TeamRepositoryImpl;

import java.util.Scanner;

public class TeamStatusView {
    private static final Scanner sc = new Scanner(System.in);

    private static final String teamStMenu =
            ConsoleMessage.LINE.getMessage() +
                    "1. Active Teams\n" +
                    "2. Deleted Teams\n" +
                    "3. Main menu\n" +
                    "4. Exit\n" +
                    ConsoleMessage.LINE.getMessage();

    private static final TeamController teamController = new TeamController(new TeamRepositoryImpl());

    public static void startTeamSt() throws Exception {
        boolean exit = false;
        do {
            System.out.println(teamStMenu);
            String userInput = sc.next();
            switch (userInput) {
                case "1" -> {
                    read(TeamStatus.ACTIVE);
                    exit = true;
                }
                case "2" -> {
                    read(TeamStatus.DELETED);
                    exit = true;
                }
                case "3" -> {
                    TeamView.startTeam();
                    exit = true;
                }
                case "4" -> {
                    exit = true;
                    DBUtil.closeConnection();
                }
            }
        } while (!exit);
    }

    private static void read(TeamStatus teamStatus)  {
        teamController.getAll().stream().
                filter(n->n.getTeamStatus().equals(teamStatus)).
                forEach(n-> System.out.println(n.getId() + ":" + n.getName()));
        try {
            startTeamSt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
