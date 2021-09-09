
import view.ConsoleStarter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class StartProgram {
	public static void main(String[] args) throws Exception {
		ConsoleStarter.start();

	}
	//manual creation skill  table
	/*public void getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/crud_database_pg", "maria", "123");
			System.out.println("Connected to the PostgreSQL server successfully.");
			conn.createStatement().executeQuery("create table if not exists skill (\n" +
					"    id\t            \t\tSERIAL PRIMARY KEY,\n" +
					"    skillName    \t    \tvarchar(20) not null\n" +
					");");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}*/
}
