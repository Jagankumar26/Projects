package service;

import java.sql.SQLException;
import java.util.Scanner;

import dao.DAOAccessing;

public class servicing {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		DAOAccessing dao=new DAOAccessing();
		boolean isRun=true;
		while(isRun)
		{
			System.out.println("select options");
			
			System.out.println("1.Insertion");
			
			System.out.println("2.deletion by id");
			System.out.println("3.select all rows");
			System.out.println("4.exit");
			System.out.println("5.store student names who selected");
			System.out.println("6.select by id");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:
				dao.inserionRow();
			break;	
			
			case 2:
				System.out.println(option);
				dao.deletion();
			break;	
			case 3:
				dao.selection();
				break;

			case 4:
				System.out.println("Thankyou visit again...");
				isRun=false;
				break;
			
			
			case 5:
				dao.store();
				break;
			case 6:
				dao.selectById();
				break;
			}
			
		}

	}

}
