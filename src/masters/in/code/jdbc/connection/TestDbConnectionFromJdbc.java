package masters.in.code.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDbConnectionFromJdbc {

	private static Connection connection = null;

	public static void main(String[] args) throws SQLException {

		try {
			// Step1: Load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2: Get the jdbc connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "Discover@1");

			// Step3: Create a statement
			Statement statement = connection.createStatement();

			// Step4: Execute the query
			ResultSet resultSet = statement.executeQuery("select * from emp");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
