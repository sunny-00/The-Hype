package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class adminlogin extends TheHype_project {
adminlogin() throws SQLException, ClassNotFoundException{
	Scanner sc=new Scanner(System.in);
	
	try {
	boolean ans=true;
	while(ans) {
	
	Statement stmt = null;
    ResultSet rst = null;
    ResultSet rs = null;
	 stmt = con.createStatement();
	String adminlogin="123456789";
	String adminpassword="123456789";
	System.out.println("enter admin loginid           :");
	String adlogin=sc.next();
	System.out.println("enter admin password          :");
	String adpass=sc.next();
	while(adminlogin.equals(adlogin) && adminpassword.equals(adpass))
	{
	int order=0;
	String purchasing_user="";
	String referred_user_id="";
	double Total_bill_amount=0;
	String category="";
	int commission_rate=0;
	String status="";
	System.out.println("1)orderstatus(commissioned)       2)Listeditems        3logout");
	int count=sc.nextInt();
	if(count==1)
	{
	String sqlquery13="select * from admin";
	stmt=con.createStatement();
	rs=stmt.executeQuery(sqlquery13);
	while(true)
	{
	while(rs.next())
	{
		order=rs.getInt(1);
		purchasing_user=rs.getString(2);
		referred_user_id=rs.getString(3);
		Total_bill_amount=rs.getDouble(4);
		category=rs.getString(5);
		commission_rate=rs.getInt(6);
		System.out.println(" Order id                       :"+order
				          +"\n purchasing user id     :"+purchasing_user
				          +"\n referred user id       :"+referred_user_id
				          +"\n Total bill             :"+Total_bill_amount
				          +"\n category               :"+category
				          +"\n commission rate        :"+commission_rate);
		
		String sqlquery14="select status from admin_commission where orderid="+order;
		stmt=con.createStatement();
		rst=stmt.executeQuery(sqlquery14);
		while(rst.next())
		{
			status=rst.getString(1);
			System.out.println("status     :"+status);
			System.out.println();
			
		}
	}
	break;
	}
	}
	if(count==2)
	{
		int list_id=0;
		String product_name="";
		String product_category="";
		String affiliate_link="";
		double prices=0;
		 System.out.println("1)Appliances\r\n"
				 		+ "2)Automotive\r\n"
				 		+ "3)Mobile Phones\r\n"
				 		+ "4)Televisions\r\n"
				 		+ "5)Books\r\n"
				 		+ "6)Shoes\r\n"
				 		+ "7)Computer, Electronics & Accessories\r\n"
				 		+ "8)All Other Categories");
		 Filters.promotionfilter();
		
		System.out.println("1)add items      2)remove items       3)back");
		int counting=sc.nextInt();
		while(counting==1)
		{
			System.out.println("enter the list id number");
			list_id=sc.nextInt();
			System.out.println("enter the product name");
			product_name=sc.next();
			System.out.println("enter the category Appliances, Automotive, Televisions, Computer, Books, Shoes, Mobile_Phones, Other_Categories");
			product_category=sc.next();
			System.out.println("enter the affiliate link");
			affiliate_link=sc.next();
			System.out.println("enter the price");
			prices=sc.nextDouble();
			String sqlquery16="insert into listeditems values("+list_id+",'"+product_name+"','"+product_category+"','"+affiliate_link+"',"+prices+")";
			stmt=con.createStatement();
			stmt.executeUpdate(sqlquery16);
			System.out.println("add more items ? y or n");
			String coun=sc.next();
			if(coun.equals("n"))
			{
				counting=counting+5;
			}
		}
		while(counting==2)
		{
			System.out.println("enter the list id you want to delete");
			int id=sc.nextInt();
			String sqlqeury17="delete from listeditems where list_id="+id;
			stmt=con.createStatement();
			stmt.executeUpdate(sqlqeury17);
			System.out.println("remove more items ? y or n");
			String coun=sc.next();
			if(coun.equals("n"))
			{
				counting=counting+5;
			}
			
		}
		
		if(counting==3)
		
		{
			ans=true;
		}
	}
	if(count==3)
	
	{
		System.exit(1);
	}
}
	
	{
		System.out.println("you have entered incorrect admin login or password");
	}
}
	
}
finally{
	sc.close();
}
}
}
