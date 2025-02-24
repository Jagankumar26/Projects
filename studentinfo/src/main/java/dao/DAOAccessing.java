package dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import encapsulations.UsingEntity;
import entitypackage.Student;
import studentutility.Utility;

public class DAOAccessing {
	Utility utility = new Utility();
	Scanner sc = new Scanner(System.in);
	float sum=0;
	int nmbr;
	int total=0;
	

	public void inserionRow() throws SQLException {
		System.out.println("enter student details");
		utility = new Utility();
		
		Connection conobj = utility.getconnection();
		Statement st = conobj.createStatement();
		UsingEntity ue = new UsingEntity();

		Student sc = ue.getStudent();

		PreparedStatement pst = conobj.prepareStatement("insert into Student1 (name, id, course) VALUES (?, ?, ?)");
		pst.setString(1, sc.getName());

		pst.setInt(2, sc.getId());
		pst.setString(3, sc.getCourse());
		int i = pst.executeUpdate();
		if (i > 0) {
			System.out.println("done");
		} else {
			System.out.println("failed");
		}
		System.out.println("======================================================================");

	}

	public void selection() throws SQLException {
		Connection conobj = utility.getconnection();
		Statement st = conobj.createStatement();

		String sql = "select * from student1";

		ResultSet rs = st.executeQuery(sql);
		System.out.println("name---------id------standard");
		while (rs.next()) {
			System.out.println(rs.getString(1) + "--" + rs.getInt(2) + "--" + rs.getString(3));

		}
System.out.println("======================================================================");
	}

	public void deletion() throws SQLException {
		
		Connection conobj = utility.getconnection();

		PreparedStatement pst = conobj.prepareStatement("delete from student1 where id=?");

		System.out.println("enter the id of the student");
		int id = sc.nextInt();
		pst.setInt(1, id);
		int i = pst.executeUpdate();
		if (i > 0) {
			System.out.println("successfully deletion completed");
		} else {
			System.out.println("id is not there or\n some error");
		}
System.out.println("==============================================================");
	}
	public void sumofid() throws SQLException
	{
		String sql="select id from student1";
		Connection conobj = utility.getconnection();
		Statement st=conobj.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			sum=sum+rs.getInt(1);
		}
		System.out.println(sum);
		System.out.println("=====================================================");
	}
	public void store() throws SQLException
	{
		Connection conobj = utility.getconnection();
		Statement st = conobj.createStatement();

		String sql = "select * from student1";

		ResultSet rs = st.executeQuery(sql);
			
		System.out.println("select here to store::");
		System.out.println("how many students do you want to store let me know::");
		int nmbr=sc.nextInt();
		String option[]=new String[nmbr];
		sc.nextLine();
		for(int i=0;i<nmbr;i++)
		{
			option[i]=sc.nextLine();
		}
		System.out.println("those students are::");
		
		while(rs.next())
		{
			for(int i=0;i<nmbr;i++)
			{
				if(rs.getString("name").equalsIgnoreCase(option[i])) 
				{
					total=total+rs.getInt("id");
					System.out.println("the id of "+option[i]+","+rs.getInt("id"));
				
					
				}
				else
				{
					continue;
				}
			}
			
		}
		System.out.println("the sum of ids is:::"+total);
		System.out.println("=======================================================");
	}
	public void selectById() throws SQLException
	{
		Connection conobj = utility.getconnection();
		Statement st = conobj.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int i=sc.nextInt();
		String sql = "SELECT name FROM student1 WHERE id = ?";
		PreparedStatement pstmt = conobj.prepareStatement(sql);
		pstmt.setInt(1, i);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("the name of the Employe with "+i+" id is");
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
	}
}
