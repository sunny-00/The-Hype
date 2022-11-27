package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class buy extends TheHype_project {
	
@SuppressWarnings({ "rawtypes", "resource" })
buy() throws SQLException, ClassNotFoundException
{
	
	Scanner sc=new Scanner(System.in);
	Statement stmt = null;
    ResultSet rs = null;
	int id=0;
	 while(true) {
	 System.out.println("1)select specific categories              2)view cart            3)back");
	  int inputnum=sc.nextInt();
	  int finalleastcategory=10;
	  
	 
	  if(inputnum==1) {
		 
	 System.out.println("1)Appliances\r\n"
	 		+ "2)Automotive\r\n"
	 		+ "3)Mobile Phones\r\n"
	 		+ "4)Televisions\r\n"
	 		+ "5)Books\r\n"
	 		+ "6)Shoes\r\n"
	 		+ "7)Computer, Electronics & Accessories\r\n"
	 		+ "8)All Other Categories");
	 			Filters.filter();
	 		System.out.println("do you want to add any item to the cart? y or n");
	 		String decision=sc.next();
	 		while(decision.equals("y"))
	 		{
	 			System.out.println("enter the id of the item you want to add to your cart");
	 			TheHype_project.tempcart.add(sc.nextInt());
	 			System.out.println("add more items ? y or n");
	 			decision=sc.next();
	 		}
	  }
	  
	 	          	else if(inputnum==2)
	 	          	{	
	 	          		if(tempcart.size()==0) {
	 	          		System.out.println("enter atleast something in cart first");
	 	          		}
	 	          	int cart=0;
	 	          	int totalbill=0;
	 	          	int k=1;
	 	          	while(inputnum==2 && tempcart.size()!=0)
	 	          	{
	 	          		Iterator i = tempcart.iterator();
	 	          		while(i.hasNext())
	 	          		{
	 	          			cart=(int) i.next();
	 	          			String sqlquery6="select list_id,product_name,category,prices from listeditems where list_id="+cart;
	 	          			stmt=con.createStatement();
	 	          			rs=stmt.executeQuery(sqlquery6);
	 	          			
	 	          	 		while(rs.next())
	 	          	 		{
	 	          	 			id=rs.getInt(1);
	 	          	 			String product_name=rs.getString(2);
	 	          	 			float prices=rs.getFloat(4);
	 	          	 			System.out.println((k)+")id= "+id
	 	          	 					          +"\nprodcut name       "+product_name
	 	          	 					          +"\nprices             "+prices
	 	          	 					          +"\n");
	 	          	 	     k++;
	 	          			}  
	 	          		}
	 	          			Scanner ner=new Scanner(System.in);
	 	          			int insertvalue=0;
	 	          	 		System.out.println("1)buy all the items?      2)cancel");
	 	          	 		int inputvalue=ner.nextInt();
	 	          	 		if(inputvalue==1)
	 	          	 		{
	 	          	 		Iterator iter = tempcart.iterator();
	 	          	 			int bill=0;
	 	          	 			String leastcategory="";
	 	          	 			int tempo=0;
	 	          	 			
	 	          	 			while(iter.hasNext())
	 	          	 			{
	 	          	 			cart=(int) iter.next();
	 	 	          			String sqlquery7="select prices,category from listeditems where list_id="+cart;
	 	 	          			rs=stmt.executeQuery(sqlquery7);
	 	 	          			while(rs.next())
	 	 	          			{
	 	 	          				bill=rs.getInt(1);
	 	 	          				leastcategory=rs.getString(2);
	 	 	          				String sqlquery0008="select Commission_rate from commission_list where category="+"'"+leastcategory+"'";
	 	 	          			    rs=stmt.executeQuery(sqlquery0008);
	 	 	          			    while(rs.next())
	 	 	          			    {
	 	 	          			    	tempo=rs.getInt(1);
	 	 	          			    	if(tempo<finalleastcategory)
	 	 	          			    	{
	 	 	          			    		finalleastcategory=tempo;
	 	 	          			    	}
	 	 	          			    }
	 	 	          			}
		          	 			totalbill=totalbill+bill;
	 	          	 			}
	 	          	 		System.out.println("Total bill amount is "+totalbill);
	 	          	 		System.out.println("1)buy      2)cancel");
	 	          	 		int temp=0;
	 	          	 		insertvalue=sc.nextInt();
	 	          	 		if(insertvalue==1)
	 	          	 		{
	 	          	 			System.out.println("Confirm the purchase of " +totalbill +" amount ? y or n");
	 	          	 			String val=sc.next();
	 	          	 			if(val.equals("y"))
	 	          	 			{
	 	          	 				System.out.println("Were you reffered by someone? y or n");
	 	          	 				String response=sc.next();
	 	          	 				while(response.equals("y"))
	 	          	 						{
	 	          	 							System.out.println("enter referral number");
	 	          	 							String ref=sc.next();
	 	          	 							String check="";
	 	          	 							String sqlquery="select referral_id from referral_id";
	 	          	 						    rs=stmt.executeQuery(sqlquery);
	 	          	 						    while(rs.next())
	 	          	 						    {
	 	          	 						    	check=rs.getString(1);
	 	          	 						    	while(check.equals(ref))
	 	          	 						    	{
	 	          	 						    		temp=1;
	 	          	 						    	login.refcheck=check;
	 	          	 						    		break;
	 	          	 						    	}        	 						    
	 	          	 						    }
	 	          	 						    if(temp==1)
	 	          	 						    {
	 	          	 						    	System.out.println("successfully referred");
	 	          	 						    	response="n";
	 	          	 						    }
	 	          	 						    else
	 	          	 						    {
	 	          	 						    	System.out.println("wrong code do you want to reenter your code? y or n");
	 	          	 						    response=sc.next();
	 	          	 						    }
	 	          	 						}
	 	          	 				if(temp==1)
	 	          	 			{	
	   	 						    Iterator j = tempcart.iterator();
	   	 	 	          		while(j.hasNext())
	   	 	 	          		    {
	   	 	 	          			int carted=(int) j.next();
	   	 	 	          			String sqlquery0007="select list_id,product_name,category,prices from listeditems where list_id="+carted;
	   	 	 	          			rs=stmt.executeQuery(sqlquery0007);
	   	 	 	          	 		while(rs.next())
	   	 	 	          	 		   {
	   	 	 	          	 			id=rs.getInt(1);
	   	 	 	          	 			String product_name=rs.getString(2);
	   	 	 	          	 			String category=rs.getString(3);
	   	 	 	          	 			float prices=rs.getFloat(4);
	   	 	 	          	 			
	   	 	 	          	 	String sqlquery007="insert into order_detail values("+"'"+login.inputEmail+"','"+product_name+"',"+"'"+category+"','"+prices+"','"+login.refcheck+"')";
	   	 	 	          	 	
	   	 	 	          	 	stmt=con.createStatement();
	   	 	 	          	 	stmt.executeUpdate(sqlquery007);
	   	 	 	          	 		   }
	   	 	 	          		    }
	 	          	 			}
	 	          	 				System.out.println("Thankyou for your purchase");
	 	          	 				Random ra=new Random(10000000);
	 	          	 				int ordernumber=ra.nextInt(10000000);
	 	          	 				int ordernumbercheck=0;
	 	          	 				String sqlquery30="select orderid from admin";
	 	          	 				rs=stmt.executeQuery(sqlquery30);
	 	          	 				while(rs.next())
	 	          	 				{
	 	          	 					ordernumbercheck=rs.getInt(1);
	 	                                if(ordernumber==ordernumbercheck)
	 	                                {
	 	                                	ordernumber=ra.nextInt(10000000);
	 	                                }
	 	          	 				}
	 	          	 				System.out.println("your order number is "+ordernumber);
	 	          	 				tempcart.removeAll(tempcart);
	 	          	 				System.out.println();
	 	          	 				if(temp==1)
	 	          	 				{
	 	          	 			String sqlquery0008="select category from commission_list where Commission_rate="+finalleastcategory;
	 	          	 			String cat="";	
	 	          	 			rs=stmt.executeQuery(sqlquery0008);
	 	          	 			{
	 	          	 				while(rs.next())
	 	          	 				{
	 	          	 					cat=rs.getString(1);
	 	          	 				}
	 	          	 			}
	 	          	 			String referred_user_id="";
	 	          	 			String sqlquery80="select userid from referral_id where referral_id='"+login.refcheck+"'";
	 	          	 			rs=stmt.executeQuery(sqlquery80);
	 	          	 			while(rs.next())
	 	          	 			{
	 	          	 			referred_user_id=rs.getString(1);
	 	          	 			}
	 	          	 			String sqlquery08="insert into admin(orderid,purchasing_user_id,referred_user_id,TOtal_bill_amount,category_least_commision_rate,commission_rate)"
	 	          	 					+ "values("+ordernumber+","+"'"+login.inputEmail+"','"+referred_user_id+"',"+totalbill+",'"+cat+"',"+finalleastcategory+")";
	 	          	 			stmt=con.createStatement();
	 	          	 			stmt.executeUpdate(sqlquery08);
	 	          	 			String sqlquery9="insert into admin_commission(referred_user_id,orderid,category,commission_rate,status)"
	 	          	 					+ "values("+"'"+referred_user_id+"',"+ordernumber+",'"+cat+"',"+finalleastcategory+",'pending')";
	 	          	 			stmt=con.createStatement();
	 	          	 			stmt.execute(sqlquery9);
	 	          	 			 break;
	 	          	 			}
	 	          	 			}	
	 	          	 		if(insertvalue==2) 
	 	          	 		{
	 	          	 			break;
	 	          	 		}
	 	          	 		}
	 	         
	 	          	 	
	 	          	 		}
	 	          	 		else if(inputvalue==2)
	 	          	 		{
	 	          	 		inputnum=1;
	 	          	 		}
	 	          	 		else
	 	          	 		{
	 	          	 		break;
	 	          	 		}
	 	          	 	
	 	          	 	
	 	          			
	 	          		break;
	 	          	}
	 	          	
	  }
	 	          	if(inputnum==3)
	 	          	{
	 	          		break;
	 	          	}
	 	          	
}
}
}
