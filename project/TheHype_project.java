package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
class TheHype_project {
	
	static Connection con=null;
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{	
    Class.forName("com.mysql.cj.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunny","root","");  
    return con;
	}
	public static int input;
	
static ArrayList<Integer> tempcart = new ArrayList<Integer>();
static String name="";
public static void main(String[] args) throws ClassNotFoundException, SQLException 
{
new Tables();	
	
	Scanner sc = new Scanner(System.in);
	try {
		
	con=getConnection();
	
	Statement stmt = null;
    ResultSet rs = null;
   while(true) {  
  	System.out.println("press 1 to login or press 2 to signup and 3 to login as admin");
  	 
  	System.out.println("1)login " +"         " +"2)signup          3)admin         0)END");
     input=sc.nextInt();
	 stmt = con.createStatement();
	 while(input>-1) {
			if(input==1)
			{
				new login(); 
			}
			
			if(input==0)
			{
				System.exit(1);
			}
			
			if(input==2)
			
			{
				new signup();
				
				System.exit(0);
			}
			
			while(input==3)
			
			{
				new adminlogin();
            }
			
 String sqlquery3="select name,useremail from signupinfo where useremail="+"'"+login.inputEmail+"'";
 rs=stmt.executeQuery(sqlquery3);
  name="";
 while(rs.next())
 {
	 name=rs.getString(1).toUpperCase();
 }
 System.out.println();
 System.out.println("                                           Welcome "+name );
 System.out.println("                                            TO 'THE HYPE' ");

 while(true)
 {
 System.out.println("1)buy                        2)promote products                      3)Logout                      4)How does it work?");
 int bypro=sc.nextInt();
 boolean bypo = false;
 if(bypro==1)
 {
	bypo=true;
 }
 
 while(bypo) {
	 			new buy();
	 			break;
 			}
 		while(bypro==2)
 		{	
 			new promote();
 			break;
 		}
 		if(bypro==3)
 		{
 			break;
 		}
 		if(bypro==4)
 		{
 			new FAQ();
 		}

 
 
}
break;
}
	 
}
   
   
}

	finally
	{
		sc.close();
	}
}
}
 
	


