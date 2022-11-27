package project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class signup  extends TheHype_project {
	
	signup() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		Scanner scan=new Scanner(System.in);
		
		try {
		Statement stmt = null;
	    ResultSet rs = null;
	    PreparedStatement pst=null ;
		 stmt = con.createStatement();
		 String email="";
		 String password="";
		 HashMap<String,String> m = new HashMap<String,String>();
		String array[]= {"0","1","2","3","4","5","6","7","8","9","10"};
		System.out.print("enter your name                                                      :" );
		String newusername=sc.next();
		for(int i=0;i<11;i++)
		{
			
		if(newusername.contains(array[i]))
				{
					System.out.println("integer values are not allowed in name reenter your name");
					newusername=sc.next();
				}
		}
		
		System.out.print("enter your age                                                       :");
		int newuserage=sc.nextInt();
		if(newuserage<18 || newuserage>120)
		{
			System.out.println("enter appropriate age(should be older than 18)");
			newuserage=sc.nextInt();
		}
		
		System.out.print("enter your email (without spaces)                                    :");
		String newuseremail=scan.nextLine();
		if(newuseremail.isBlank())
		{
			System.out.println("Emai cannot be blank re-enter your email                                :");
			newuseremail=scan.nextLine();
		}
		while(newuseremail.contains(" "))
		{
			System.out.print("enter an email without spaces!!                                  :");
			newuseremail=scan.nextLine();
		}
		String sqlquery1="select useremail,userpassword from signupinfo";
		rs=stmt.executeQuery(sqlquery1);
		while(rs.next())
		{
			email=rs.getString(1);
			password=rs.getString(2);	
			m.put(email, password);
		}
		while(m.containsKey(newuseremail))
		{
		System.out.println("email already in use");
		System.out.print    ("re-enter your email                                              :");
		newuseremail=scan.nextLine();
		}
		System.out.print("enter your password (more than 2 characters but less than 15         :");
		String newuserpassword=scan.nextLine();
		while(newuserpassword.length()<=2)
		{
			System.out.print("enter a longer password, more than 2 characters and less than 15 :");
			newuserpassword=scan.nextLine();
		}
		while(newuserpassword.length()>=15)
		{
			System.out.print("enter a longer password, more than 2 characters and less than 15 :");
			newuserpassword=scan.nextLine();
		}
		
            	String sqlquery2="insert into signupinfo values(?,?,?,?)";
            	pst=null;
            	pst=con.prepareStatement(sqlquery2);
            	pst.setString(1,newusername);
            	pst.setInt(2, newuserage);
            	pst.setString(3, newuseremail);
            	pst.setString(4, newuserpassword);
            	pst.addBatch();
            	pst.executeBatch();	
		System.out.println("successfully signed up");
		StringBuffer randomstring=new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
		StringBuffer referral=new StringBuffer();
		String sqlquery07="select referral_id from referral_id";
		rs=stmt.executeQuery(sqlquery07);
		String comparing01="";
		while(rs.next())
		{
			comparing01=rs.getString(1);	
		}
		for(int i=0;i<=7;i++)
		{
			Random ran=new Random();
			int j=ran.nextInt(randomstring.length());
			referral.append(randomstring.charAt(j));
			if(referral.equals(comparing01))
			{
				referral=null;
				i=0;
				
			}
		}
		String sqlquery003="insert into referral_id values("+"'"+newuseremail+"','"+referral+"')";
		stmt=con.createStatement();
		stmt.executeUpdate(sqlquery003);
	}
	finally{
		sc.close();
		scan.close();
	}
	}
}
