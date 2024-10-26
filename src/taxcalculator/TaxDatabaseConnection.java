package taxcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TaxDatabaseConnection {
	
	public class TaxDbCon {
		public static Connection getCon() throws SQLException
		{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taxdata","root","Password");
		return con;
		}
	}
}
