package masters.in.code.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {

	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Discover@1");
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate("delete from student where stid=0");
			System.out.println(rows+" effected");
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
