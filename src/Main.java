
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	static final String DB_URL ="jdbc:oracle:thin:@localhost:1521:xe";
	static final String USER = "xe";
	static final String PASS = "xe";
	static final String QUERY = "SELECT name,roll_no,address FROM student";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Open a connection
		//Class.forName("oracle.jdbc.driver.OracleDriver"); //without adding driver it is working for select statement
		//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				System.out.print("ID: " + rs.getString("name"));
				System.out.print(", Age: " + rs.getInt("roll_no"));
				System.out.print(", First: " + rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




