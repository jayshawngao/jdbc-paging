package paging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnectionUtil {

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql:///springdata";
		String user = "root";
		String password = "gao963680393";
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
