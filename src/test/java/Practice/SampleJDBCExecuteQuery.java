package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef=new Driver();
		//Step 1: Register the driver
		DriverManager.registerDriver(driverRef);
		//Step 2:Establish connection with DB
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/m11db","root", "root");
		//Step 3: issue create statement
		Statement state=con.createStatement();
		//Execute a query
		ResultSet result = state.executeQuery("select * from candidates_details");
		while(result.next()) {
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}
		
		//close the connection
		con.close();

	}

}
