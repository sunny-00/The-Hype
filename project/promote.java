package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class promote extends TheHype_project {
@SuppressWarnings("resource")
promote() throws SQLException
{
	while(true) {
	Scanner sc = new Scanner(System.in);
	Statement stmt = null;
    ResultSet rs = null;
	 stmt = con.createStatement();
	System.out.println("1)Promote         2)Profile          3)back");
		int response=sc.nextInt();

		while(response==1)
		{
			System.out.println("1)promote new                      2)enter ordernum for promoted products             3)back");
			int digit=sc.nextInt();
			if(digit==1)
			{
				 System.out.println("1)Appliances\r\n"
				 		+ "2)Automotive\r\n"
				 		+ "3)Mobile Phones\r\n"
				 		+ "4)Televisions\r\n"
				 		+ "5)Books\r\n"
				 		+ "6)Shoes\r\n"
				 		+ "7)Computer, Electronics & Accessories\r\n"
				 		+ "8)All Other Categories");
				Filters.promotionfilter();
		         System.out.println("want to look into other categories? y or n");
		         String resultingans=sc.next();
		if(resultingans.equals("n"))
		{
			response=response+5;
		}
		   }
			if(digit==2)
			{
				while(true)
				{
				System.out.println("enter the order number of the customer whom you have referred");
				int ordernum=sc.nextInt();
				String sqlquery09="select orderid,referred_user_id from admin";
				String refuseid="";
				int temp=0;
				int temporary=0;
				rs=stmt.executeQuery(sqlquery09);
				while(rs.next())
				{
					temp=rs.getInt(1);
					if(temp==ordernum)
					{
						refuseid=rs.getString(2);
						temporary++;
						
					}
				    	if(temporary!=0 && refuseid.equals(login.inputEmail))
					    {
						String sqlquery009="select status from admin_commission where referred_user_id="+"'"+login.inputEmail+"'";
						String currentstatus="";
						int count=0;
						rs=stmt.executeQuery(sqlquery009);
								while(rs.next())
							{
								  currentstatus=rs.getString(1);
								  if(currentstatus.equals("pending"))
								      {
									     count++;
								  
			           		if(count!=0) {
								String sqlquery11="update admin_commission set status='paid' where orderid="+ordernum;
							 stmt.executeUpdate(sqlquery11);
							 
							 System.out.println("Congrats your referrence is successfully been updated");
								 String sqlquery10="select TOtal_bill_amount,commission_rate from admin where orderid="+ordernum;
								 int totalbill;
								 int finalleastcategory=0;
								 double commission=0;
								 rs=stmt.executeQuery(sqlquery10);
								 while(rs.next())
								 {
									 totalbill=rs.getInt(1);
									 finalleastcategory=rs.getInt(2);
									 commission=(totalbill*finalleastcategory)/100;
									 System.out.println("total commission is :"+commission);
									 
									 
								 }
								 String sqlquery111="insert into totalcommission values("+"'"+login.inputEmail+"',"+commission+")";
								 stmt=con.createStatement();
								 stmt.executeUpdate(sqlquery111);
								
						
								break;
								      }
								      }
								  
					    }
					}
						else
						{
							temporary=0;
						}
				    	
						  		
			
			}
				if(temporary==0)
		    	{
		    		System.out.println("code you have entered is either incorrect or has already been commissioned");
		    	}
				break;
		    }
			}
			if(digit==3)
			{
				response=response+5;
			}
		
		}
while(response==2)	
		{
		double totalcommissionearned=0;
		String referral="";
		String sqlquery12="select referral_id from referral_id where userid="+"'"+login.inputEmail+"'";
		rs=stmt.executeQuery(sqlquery12);
		while(rs.next())
		{
			referral=rs.getString(1);
		}
		String sqlquery13="select sum(totalcommission) from totalcommission where user_id='"+login.inputEmail+"'";
		rs=stmt.executeQuery(sqlquery13);
		while(rs.next())
		{
			totalcommissionearned=rs.getDouble(1);
		}
			System.out.println("Name               :"+name);
			System.out.println("Referral code      :"+referral);
			System.out.println("Total commission   :"+totalcommissionearned);
			break;
		}
while(response==3)
{
break;
}
if(response==3)
{
	break;
}
}
}
}
