package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Tables {
Tables() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
	PreparedStatement pst=null;
	  Statement stmt = null;
	  Connection co=null;
	  try {
	co=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
	String sqlquery000="create database sunny";
	  stmt=co.createStatement();
	  stmt.execute(sqlquery000);
	  Connection con=null;
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunny","root","");
	  String sqlquery="create table signupinfo(name varchar(20),age int,useremail varchar(50),userpassword varchar(50))";
	  stmt=con.createStatement();
	  stmt.executeUpdate(sqlquery);
	  String sqlquery1="create table commission_list(category varchar(70),Commission_rate decimal(8,2))";
	  stmt.executeUpdate(sqlquery1);
	
	String sqlquery2="insert into commission_list values(?,?)";
	pst=con.prepareStatement(sqlquery2);
	pst.setString(1,"Appliances");
	pst.setInt(2,9);
	pst.addBatch();
	
	pst.setString(1,"Automotive");
	pst.setInt(2,6);
	pst.addBatch();
	
	pst.setString(1,"Televisions");
	pst.setInt(2,5);
	pst.addBatch();
	
	pst.setString(1,"Computer");
	pst.setInt(2,7);
	pst.addBatch();
	
	pst.setString(1,"Books");
	pst.setInt(2,4);
	pst.addBatch();
	
	pst.setString(1,"Shoes");
	pst.setInt(2,2);
	pst.addBatch();
	
	pst.setString(1,"Mobile_Phones");
	pst.setInt(2,1);
	pst.addBatch();
	
	pst.setString(1,"Other_Categories");
	pst.setInt(2,8);
	pst.addBatch();
	
	pst.executeBatch();
	
	 pst=null;
	String sqlquery3="create table listeditems(list_id int primary key,product_name varchar(125),category varchar(100),affiliate_link varchar(125),prices decimal(8,2))";
	stmt.executeUpdate(sqlquery3);
	
	String sqlquery4="insert into listeditems values(?,?,?,?,?)";
	pst=con.prepareStatement(sqlquery4);
	pst.setInt(1, 1000);
	pst.setString(2, "Knife");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/6DUglFO");
	pst.setDouble(5, 1200);
	pst.addBatch();
	
	pst.setInt(1, 1001);
	pst.setString(2, "Gas");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/7DUglFO");
	pst.setDouble(5, 12000);
	pst.addBatch();
	
	pst.setInt(1, 1002);
	pst.setString(2, "Tea-pot");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/8DUglFO");
	pst.setDouble(5, 700);
	pst.addBatch();
	
	pst.setInt(1, 1003);
	pst.setString(2, "Mixer");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/9DUglFO");
	pst.setDouble(5, 3500);
	pst.addBatch();
	
	pst.setInt(1, 1004);
	pst.setString(2, "wooden utensils");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/10DUglFO");
	pst.setDouble(5, 200);
	pst.addBatch();
	
	pst.setInt(1, 1005);
	pst.setString(2, "electronic stovekraft");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/11DUglFO");
	pst.setDouble(5, 2000);
	pst.addBatch();
	
	
	
	pst.setInt(1, 1006);
	pst.setString(2, "Bloo basket");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/7eQ7jkY");
	pst.setDouble(5, 14000);
	pst.addBatch();
	
	pst.setInt(1, 1007);
	pst.setString(2, "Air tight containers");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/8eQ7jkY");
	pst.setDouble(5, 400);
	pst.addBatch();
	
	pst.setInt(1, 1008);
	pst.setString(2, "Kitchen racks and shelves");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/9eQ7jkY");
	pst.setDouble(5, 900);
	pst.addBatch();
	
	pst.setInt(1, 1009);
	pst.setString(2, "Milton aqua bottle");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/10eQ7jkY");
	pst.setDouble(5, 1100);
	pst.addBatch();
	
	pst.setInt(1, 1010);
	pst.setString(2, "360 plastic storage");
	pst.setString(3, "Appliances");
	pst.setString(4,"https://amzn.eu/d/11eQ7jkY");
	pst.setDouble(5, 2000);
	pst.addBatch();
	
	
	pst.setInt(1, 2001);
	pst.setString(2, "Washing machine");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/7QyFB5M");
	pst.setDouble(5, 20000);
	pst.addBatch();
	
	pst.setInt(1, 2002);
	pst.setString(2, "water dispenser");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/8QyFB5M");
	pst.setDouble(5, 1000);
	pst.addBatch();
	
	pst.setInt(1, 2003);
	pst.setString(2, "magic air kit");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/9QyFB5M");
	pst.setDouble(5, 1500);
	pst.addBatch();
	
	pst.setInt(1, 2004);
	pst.setString(2, "Automaze universal car fit");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/10QyFB5M");
	pst.setDouble(5, 1800);
	pst.addBatch();
	
	pst.setInt(1, 2005);
	pst.setString(2, "Soft pun");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/11QyFB5M");
	pst.setDouble(5, 200);
	pst.addBatch();
	
	pst.setInt(1, 2006);
	pst.setString(2, "Super concentrated automotive glass");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/12QyFB5M");
	pst.setDouble(5, 34000);
	pst.addBatch();
	
	pst.setInt(1, 2007);
	pst.setString(2, "Sponge wipes");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/13QyFB5M");
	pst.setDouble(5, 150);
	pst.addBatch();
	
	pst.setInt(1, 2008);
	pst.setString(2, "waxpol");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/14QyFB5M");
	pst.setDouble(5, 600);
	pst.addBatch();
	
	pst.setInt(1, 2009);
	pst.setString(2, "Auto MT sparco");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/15QyFB5M");
	pst.setDouble(5, 7000);
	pst.addBatch();
	
	pst.setInt(1, 2010);
	pst.setString(2, "AutoTrends");
	pst.setString(3, "Automotive");
	pst.setString(4,"https://amzn.eu/d/16QyFB5M");
	pst.setDouble(5, 850);
	pst.addBatch();
	
	pst.setInt(1, 3001);
	pst.setString(2, "Toshiba 139cm(55 inches");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/1eibt6h");
	pst.setDouble(5, 36000);
	pst.addBatch();
	
	pst.setInt(1, 3002);
	pst.setString(2, "Sony barvia(43 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/2eibt6h");
	pst.setDouble(5, 45000);
	pst.addBatch();
	
	pst.setInt(1, 3003);
	pst.setString(2, "Vc 123cm(50 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/3eibt6h");
	pst.setDouble(5, 30000);
	pst.addBatch();
	
	pst.setInt(1, 3004);
	pst.setString(2, "Redmi 80cm(32 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/4eibt6h");
	pst.setDouble(5, 23000);
	pst.addBatch();
	
	pst.setInt(1, 3005);
	pst.setString(2, "Oneplus 80cm(32 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/5eibt6h");
	pst.setDouble(5, 28000);
	pst.addBatch();
	
	pst.setInt(1, 3006);
	pst.setString(2, "Acer 80cm(32 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/6eibt6h");
	pst.setDouble(5, 45000);
	pst.addBatch();
	
	pst.setInt(1, 3007);
	pst.setString(2, "Samsung 80cm(32 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/7eibt6h");
	pst.setDouble(5, 60000);
	pst.addBatch();
	
	pst.setInt(1, 3008);
	pst.setString(2, "LG 80cm(32 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/8eibt6h");
	pst.setDouble(5, 26000);
	pst.addBatch();
	
	pst.setInt(1, 3009);
	pst.setString(2, "Mi 80cm(32 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/9eibt6h");
	pst.setDouble(5, 25000);
	pst.addBatch();
	
	pst.setInt(1, 3010);
	pst.setString(2, "Mi 125.7cm(50 inches)");
	pst.setString(3, "Televisions");
	pst.setString(4, "https://amzn.eu/d/10eibt6h");
	pst.setDouble(5, 90000);
	pst.addBatch();
	
	pst.setInt(1, 4001);
	pst.setString(2, "Lenovo");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/41eQ7jkY");
	pst.setDouble(5, 36000);
	pst.addBatch();
	
	pst.setInt(1, 4002);
	pst.setString(2, "DEll");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/42eQ7jkY");
	pst.setDouble(5, 56000);
	pst.addBatch();
	
	pst.setInt(1, 4003);
	pst.setString(2, "Asus");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/43eQ7jkY");
	pst.setDouble(5, 63000);
	pst.addBatch();
	
	pst.setInt(1, 4004);
	pst.setString(2, "HP");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/44eQ7jkY");
	pst.setDouble(5, 73000);
	pst.addBatch();
	
	pst.setInt(1, 4005);
	pst.setString(2, "Entwino");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/45eQ7jkY");
	pst.setDouble(5, 45500);
	pst.addBatch();
	
	pst.setInt(1, 4006);
	pst.setString(2, "Acer");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/46eQ7jkY");
	pst.setDouble(5, 37500);
	pst.addBatch();
	
	pst.setInt(1, 4007);
	pst.setString(2, "Radiant");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/47eQ7jkY");
	pst.setDouble(5, 36000);
	pst.addBatch();
	
	pst.setInt(1, 4008);
	pst.setString(2, "Acer Aspire 3");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/48eQ7jkY");
	pst.setDouble(5, 70000);
	pst.addBatch();
	
	pst.setInt(1, 4009);
	pst.setString(2, "Legion");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/49eQ7jkY");
	pst.setDouble(5, 127000);
	pst.addBatch();
	
	pst.setInt(1, 4010);
	pst.setString(2, "ANT esports");
	pst.setString(3, "Computer");
	pst.setString(4,"https://amzn.eu/d/410eQ7jkY");
	pst.setDouble(5, 26000);
	pst.addBatch();
	
	
	pst.setInt(1, 5001);
	pst.setString(2, "Most Influential classics");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/51eQ7jkY");
	pst.setDouble(5, 450);
	pst.addBatch();
	
	pst.setInt(1, 5002);
	pst.setString(2, "The Untethered soul");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/52eQ7jkY");
	pst.setDouble(5, 800);
	pst.addBatch();
	
	pst.setInt(1, 5003);
	pst.setString(2, "Life's Amazing Secrets");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/53eQ7jkY");
	pst.setDouble(5, 120);
	pst.addBatch();
	
	pst.setInt(1, 5004);
	pst.setString(2, "The power of your Subconcious mind");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/54eQ7jkY");
	pst.setDouble(5, 90);
	pst.addBatch();
	
	pst.setInt(1, 5005);
	pst.setString(2, "The Psychology of Money");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/55eQ7jkY");
	pst.setDouble(5, 180);
	pst.addBatch();
	
	pst.setInt(1, 5006);
	pst.setString(2, "Do Epic Thing");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/56eQ7jkY");
	pst.setDouble(5, 150);
	pst.addBatch();
	
	pst.setInt(1, 5007);
	pst.setString(2, "Karma");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/57eQ7jkY");
	pst.setDouble(5, 90);
	pst.addBatch();
	
	pst.setInt(1, 5008);
	pst.setString(2, "The Midnight Library");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/58eQ7jkY");
	pst.setDouble(5, 320);
	pst.addBatch();
	
	pst.setInt(1, 5009);
	pst.setString(2, "Ikigai");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/59eQ7jkY");
	pst.setDouble(5, 220);
	pst.addBatch();
	
	pst.setInt(1, 5010);
	pst.setString(2, "You can");
	pst.setString(3, "Books");
	pst.setString(4,"https://amzn.eu/d/510eQ7jkY");
	pst.setDouble(5, 85);
	pst.addBatch();
	
	pst.setInt(1, 6001);
	pst.setString(2, "Adidas");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/61eQ7jkY");
	pst.setDouble(5, 2300);
	pst.addBatch();
	
	pst.setInt(1, 6002);
	pst.setString(2, "Robbie jones");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/62eQ7jkY");
	pst.setDouble(5, 1200);
	pst.addBatch();
	
	pst.setInt(1, 6003);
	pst.setString(2, "Centrino");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/63eQ7jkY");
	pst.setDouble(5, 400);
	pst.addBatch();
	
	pst.setInt(1, 6004);
	pst.setString(2, "Sparx");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/64eQ7jkY");
	pst.setDouble(5, 550);
	pst.addBatch();
	
	pst.setInt(1, 6005);
	pst.setString(2, "Corstyle");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/65eQ7jkY");
	pst.setDouble(5, 670);
	pst.addBatch();
	
	pst.setInt(1, 6006);
	pst.setString(2, "Puma");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/66eQ7jkY");
	pst.setDouble(5, 2600);
	pst.addBatch();
	
	pst.setInt(1, 6007);
	pst.setString(2, "Nike");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/67eQ7jkY");
	pst.setDouble(5, 2100);
	pst.addBatch();
	
	pst.setInt(1, 6008);
	pst.setString(2, "Reebok");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/68eQ7jkY");
	pst.setDouble(5, 1800);
	pst.addBatch();
	
	pst.setInt(1, 6009);
	pst.setString(2, "Giro");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/69eQ7jkY");
	pst.setDouble(5, 23000);
	pst.addBatch();
	
	pst.setInt(1, 6010);
	pst.setString(2, "Foam Yeezy");
	pst.setString(3, "Shoes");
	pst.setString(4,"https://amzn.eu/d/610eQ7jkY");
	pst.setDouble(5, 56000);
	pst.addBatch();
	
	pst.setInt(1, 7001);
	pst.setString(2, "Samsung Galaxy S20 FE 5G");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/71eQ7jkY");
	pst.setDouble(5, 29000);
	pst.addBatch();
	
	pst.setInt(1, 7002);
	pst.setString(2, "One-plus Nord CE");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/72eQ7jkY");
	pst.setDouble(5, 34000);
	pst.addBatch();
	
	pst.setInt(1, 7003);
	pst.setString(2, "Redmi Not 11T");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/73eQ7jkY");
	pst.setDouble(5, 17000);
	pst.addBatch();
	
	pst.setInt(1, 7004);
	pst.setString(2, "Realme narzo 50i");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/74eQ7jkY");
	pst.setDouble(5, 6500);
	pst.addBatch();
	
	pst.setInt(1, 7005);
	pst.setString(2, "Oppo");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/75eQ7jkY");
	pst.setDouble(5, 21000);
	pst.addBatch();
	
	pst.setInt(1, 7006);
	pst.setString(2, "Xiaomi");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/76eQ7jkY");
	pst.setDouble(5, 38000);
	pst.addBatch();
	
	pst.setInt(1, 7007);
	pst.setString(2, "Tecno Spark 9");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/77eQ7jkY");
	pst.setDouble(5, 9500);
	pst.addBatch();
	
	pst.setInt(1, 7008);
	pst.setString(2, "Vivo v9");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/78eQ7jkY");
	pst.setDouble(5, 23500);
	pst.addBatch();
	
	pst.setInt(1, 7009);
	pst.setString(2, "Nothing");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/79eQ7jkY");
	pst.setDouble(5, 90000);
	pst.addBatch();
	
	pst.setInt(1, 7010);
	pst.setString(2, "Iphone 14 pro max");
	pst.setString(3, "Mobile_Phones");
	pst.setString(4,"https://amzn.eu/d/710eQ7jkY");
	pst.setDouble(5, 188000);
	pst.addBatch();
	
	pst.setInt(1, 8001);
	pst.setString(2, "Ant Enterprize Yezdi");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/810eQ7jkY");
	pst.setDouble(5, 900);
	pst.addBatch();
	
	pst.setInt(1, 8002);
	pst.setString(2, "LAZI multipurpose Gel");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/820eQ7jkY");
	pst.setDouble(5, 280);
	pst.addBatch();
	
	pst.setInt(1, 8003);
	pst.setString(2, "HSR car emergency Escape");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/830eQ7jkY");
	pst.setDouble(5, 390);
	pst.addBatch();
	
	pst.setInt(1, 8004);
	pst.setString(2, "ELV Car Mount phone holder");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/840eQ7jkY");
	pst.setDouble(5, 200);
	pst.addBatch();
	
	pst.setInt(1, 8005);
	pst.setString(2, "Callas Foldable Laptop table");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/850eQ7jkY");
	pst.setDouble(5, 600);
	pst.addBatch();
	
	pst.setInt(1, 8006);
	pst.setString(2, "Involve your Senses");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/860eQ7jkY");
	pst.setDouble(5, 330);
	pst.addBatch();
	
	pst.setInt(1, 8007);
	pst.setString(2, "Lukzer 1Pc");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/870eQ7jkY");
	pst.setDouble(5, 560);
	pst.addBatch();
	
	pst.setInt(1, 8008);
	pst.setString(2, "Wire 20mm");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/880eQ7jkY");
	pst.setDouble(5, 60);
	pst.addBatch();
	
	pst.setInt(1, 8009);
	pst.setString(2, "Divya Mantra");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/890eQ7jkY");
	pst.setDouble(5, 110);
	pst.addBatch();
	
	pst.setInt(1, 8010);
	pst.setString(2, "Torch LED 3W");
	pst.setString(3, "Other_Categories");
	pst.setString(4,"https://amzn.eu/d/8100eQ7jkY");
	pst.setDouble(5, 950);
	pst.addBatch();
	
	
	
	pst.executeBatch();
	
	
	 String sqlquery02="create table ordernum(userid varchar(70),order_id int)";
	  stmt=con.createStatement();
	  stmt.executeUpdate(sqlquery02);
	  String sqlquery03="create table referral_id(userid varchar(70),referral_id varchar(100))";
	  stmt=con.createStatement();
	  stmt.executeUpdate(sqlquery03);
	 
	 String sqlquery006="create table order_detail(userid varchar(70),product_name varchar(100),category varchar(70),prices decimal(8,2),referral_id varchar(70))";
	stmt=con.createStatement();
	stmt.executeUpdate(sqlquery006);
	 
	String sqlquery08="create table admin(orderid int,purchasing_user_id varchar(70),referred_user_id varchar(70),TOtal_bill_amount decimal(8,2),category_least_commision_rate varchar(70),commission_rate int)";
	stmt=con.createStatement();
	stmt.executeUpdate(sqlquery08);
	
	String sqlquery008="create table admin_commission(referred_user_id varchar(70),orderid int,category varchar(70),commission_rate int,status varchar(70))";
	stmt=con.createStatement();
	stmt.executeUpdate(sqlquery008);
	
	String sqlquery09="create table totalcommission(user_id varchar(70),totalcommission decimal(8,2))";
	stmt=con.createStatement();
	stmt.executeUpdate(sqlquery09);
	
	
	System.out.println("All tables and databases are created successfully");
	
}
	  catch(Exception e)
	  {
		 
	  }
}
}
