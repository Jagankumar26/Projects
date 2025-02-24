import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import studentutility.Utility;
public class Customer {

	public static void main(String[] args) throws SQLException {
		Connection conn=Utility.getconnection();
		Scanner sc=new Scanner(System.in);
	PreparedStatement pps=	conn.prepareStatement("insert into customer values (?,?)");
	while(true)
	{
		System.out.println("enter name, id");
	String s=	sc.nextLine();
	int id=	sc.nextInt();
	sc.nextLine();
pps.setString(1, s);
pps.setInt(2, id);
pps.executeUpdate();
System.out.println("enter yes/no");
String option=sc.nextLine();
if(option.equals("no")) {
	break;
}
		
	}
	System.out.println("complted...");

	}

}
