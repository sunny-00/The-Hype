package project;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Filters extends TheHype_project {
	
	@SuppressWarnings("resource")
	public static void filter()
	{
		 
		try
		{
		Scanner kc=new Scanner(System.in);
		System.out.println("select from the above category");
		int number=kc.nextInt();
		String category="";
		switch(number) {
		case 1 :
			  category="Appliances";
			  break;
		case 2 :
			  category="Automotive";
			  break;
		case 3 :
			  category="Televisions";
			  break;
		case 4 :
			  category="Computer";
			  break;
		case 5 :
			  category="Books";
			  break;
		case 6 :
			  category="Shoes";
			  break;
		case 7 :
			  category="Mobile_Phones";
			  break;
		default :
			  category="Other_Categories";
		}
		System.out.println(category);
		Statement stmt = null;
	    ResultSet rs = null;
	  
	   Scanner Sner=new Scanner(System.in);
	   Scanner sc=new Scanner(System.in);
		String product_name="";
	 		String sqlquery00="select product_name,affiliate_link,prices,list_id from listeditems where category='"+category+"'";
	 		stmt=con.createStatement();
	 		rs=stmt.executeQuery(sqlquery00);
	 		int i=1;
	 		while(rs.next())
	 		{	
	 			product_name=rs.getString(1);
	 			double prices=rs.getDouble(3);
	 			int list_id=rs.getInt(4);
	 			System.out.println("--------------------------------------------------");
	 			System.out.println(i+")id= "+list_id
		 					+"\n"+"product name                	        | prices"
					        +"\n"  +product_name);
	 			System.out.println("                                           "+prices);                                    
	 			System.out.println("--------------------------------------------------");
	 			i++;
	 		}
	 		System.out.println("Filter the above result? y or n");
	 		String answer=sc.next();
	 		if(answer.equals("y"))
	 		{
	 			System.out.println("1)Filter by prices?\n2)Filter by aplhabetical order");
	 			int num=Sner.nextInt();
	 			if(num==1)
	 			{
	 				String sqlquery01="select * from listeditems where category="+"'"+category+"'" +"order by prices";
	 		 		rs=stmt.executeQuery(sqlquery01);
	 		 		int j=1;
	 		 		while(rs.next())
	 		 		{	
	 		 			int list_id=rs.getInt(1);
	 		 			String name=rs.getString(2);
	 		 			float prices=rs.getFloat(5);
	 		 			System.out.println("--------------------------------------------------");
	 		 			System.out.println(""+j+")id= "+list_id+"                          "+"\n" 
	 		 					          +"product name                        prices     "+"\n"
	 					                  +""+name+"                                       ");
	 			        System.out.println("                                    "+prices+" ");                                    
	 		        	System.out.println("--------------------------------------------------");
	 		 			j++;
	 		 		}
	 			}
	 			else
	 			{
	 				String sqlquery010="select * from listeditems where category="+"'"+category+"'" +"order by product_name";
	 		 		rs=stmt.executeQuery(sqlquery010);
	 		 		int j=1;
	 		 		while(rs.next())
	 		 		{	
	 		 			int list_id=rs.getInt(1);
	 		 			String name=rs.getString(2);
	 		 			double prices=rs.getDouble(5);
	 		 			System.out.println("--------------------------------------------------");
	 		 			System.out.println(j+")id= "+list_id
	 		 					+"\n"+"product name                	        | prices"
	 					        +"\n"  +name);
	 			System.out.println("                                           "+prices);                                    
	 			System.out.println("--------------------------------------------------");
	 		 			j++;
	 		 		}
	 			}
	 		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	 	}
	
	@SuppressWarnings("resource")
	public static void promotionfilter()
	{
		try {
		Scanner kc=new Scanner(System.in);
		System.out.println("select from the above category");
		int number=kc.nextInt();
		String category="";
		switch(number)
		{
		case 1 :
			  category="Appliances";
			  break;
		case 2 :
			  category="Automotive";
			  break;
		case 3 :
			  category="Televisions";
			  break;
		case 4 :
			  category="Computer";
			  break;
		case 5 :
			  category="Books";
			  break;
		case 6 :
			  category="Shoes";
			  break;
		case 7 :
			  category="Mobile_Phones";
			  break;
		default :
			  category="Other_Categories";
		}
		System.out.println(category);
		Statement stmt = null;
	    ResultSet rs = null;
	  
	   Scanner hs=new Scanner(System.in);
	   Scanner sx=new Scanner(System.in);
		String product_name="";
	 		String sqlquery00="select product_name,affiliate_link,prices,list_id from listeditems where category='"+category+"'";
	 		stmt=con.createStatement();
	 		rs=stmt.executeQuery(sqlquery00);
	 		int i=1;
	 		while(rs.next())
	 		{	
	 			product_name=rs.getString(1);
	 			String affiliate_link=rs.getString(2);
	 			double prices=rs.getDouble(3);
	 			int list_id=rs.getInt(4);
	 			System.out.println("--------------------------------------------------");
	 			System.out.println(i+")id= "+list_id+"    Link :"+affiliate_link
		 					+"\n"+"product name                	        | prices"
					        +"\n"  +product_name);
	 			System.out.println("                                           "+prices);                                    
	 			System.out.println("--------------------------------------------------");
	 			System.out.println();
	 			i++;
	 		}
	 		System.out.println("Filter the above result? y or n");
	 		String answer=hs.next();
	 		if(answer.equals("y"))
	 		{
	 			System.out.println("1)Filter by prices?\n2)Filter by aplhabetical order");
	 			int num=sx.nextInt();
	 			if(num==1)
	 			{
	 				String sqlquery01="select * from listeditems where category="+"'"+category+"'" +"order by prices";
	 		 		rs=stmt.executeQuery(sqlquery01);
	 		 		int j=1;
	 		 		while(rs.next())
	 		 		{	
	 		 			int list_id=rs.getInt(1);
	 		 			String affiliate_link=rs.getString(4);
	 		 			float prices=rs.getFloat(5);
	 		 			System.out.println("--------------------------------------------------");
	 		 			System.out.println(j+")id= "+list_id+"    Link :"+affiliate_link
	 		 					+"\n"+"product name                	        | prices"
	 					        +"\n"  +product_name);
	 	 			System.out.println("                                           "+prices);                                    
	 	 			System.out.println("--------------------------------------------------");
	 			System.out.println();
	 		 			j++;
	 		 		}
	 			}
	 			else
	 			{
	 				String sqlquery010="select * from listeditems where category="+"'"+category+"'" +"order by product_name";
	 		 		rs=stmt.executeQuery(sqlquery010);
	 		 		int j=1;
	 		 		while(rs.next())
	 		 		{	
	 		 			int list_id=rs.getInt(1);
	 		 			String affiliate_link=rs.getString(4);
	 		 			double prices=rs.getDouble(5);
	 		 			System.out.println("--------------------------------------------------");
	 		 			System.out.println(j+")id= "+list_id+"    Link :"+affiliate_link
	 		 					+"\n"+"product name                	        | prices"
	 					        +"\n"  +product_name);
	 	 			System.out.println("                                           "+prices);                                    
	 	 			System.out.println("--------------------------------------------------");
	 			System.out.println();
	 		 			j++;
	 		 		}
	 			}
	 		}
		}
	 		catch(Exception e)
	 		{
	 			System.out.println(e);
	 		}
	 	}
}
