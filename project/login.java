package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class login  extends TheHype_project {
	static String inputEmail="";
	static String refcheck="";
	@SuppressWarnings("resource")
	login() throws ClassNotFoundException, SQLException {
		Statement stmt = null;
	    ResultSet rs = null;
	   HashMap<String,String> m = new HashMap<String,String>();
		 stmt = con.createStatement();
		
		 String email="";
		 String password="";
		 
		String sqlquery1="select useremail,userpassword from signupinfo";
		rs=stmt.executeQuery(sqlquery1);
		while(rs.next())
		{
			email=rs.getString(1);
			password=rs.getString(2);	
			m.put(email, password);
		}
	while(true) {
	Scanner can =new Scanner(System.in);
	System.out.print("enter your email      :");
	 inputEmail=can.nextLine();
	System.out.print("enter your password   :");
	String inputPassword=can.nextLine();
	
	if(m.containsKey(inputEmail) && (m.containsValue(inputPassword)))
			{
				System.out.println("you have successfully logged in");
				break;
			}
	else if(inputEmail.isBlank())
	{
		System.out.println("Emai; cannot be blank re-enter your email");
	}
	else if(m.containsKey(inputEmail))
	{
		System.out.println("incorrect password");
	}
	else
	{
		System.out.println("please re-enter email and password");
	}
	}
	}
}
