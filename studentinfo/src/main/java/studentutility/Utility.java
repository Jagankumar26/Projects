package studentutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {

private static Connection conn=null;
static 
{
	try {

 String url="jdbc:mysql://localhost:3306/pawan";
	String username="root";
	String password="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 conn = DriverManager.getConnection(url,username,password);
	
		
}catch(SQLException e)
	{
	System.out.println(e.getMessage());
	}
	catch(ClassNotFoundException cle)
	{
		System.out.println(cle.getMessage());
	}
	
}
public static Connection getconnection()
{
	return conn;
	
}
public void closeconnection()
{
	try {
	if(conn!=null)
	{
		conn.close();
	}
}
	catch(SQLException e)
{
	System.out.println(e);
}
}
}
