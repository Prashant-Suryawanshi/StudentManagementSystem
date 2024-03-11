package studentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection createConnection(String connectionType) throws SQLException {
		if(connectionType.equalsIgnoreCase("mySql")) {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementsystem", "root", "Playbold@123");
		}
		else {
			return null;
		}
	}
}
