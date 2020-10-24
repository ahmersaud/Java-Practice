package loginPkg;
import java.util.*;
import java.sql.*;

public class DBConnect 

{
	private Statement statement;//Compulsory variable as it will be used to send queries and other stuff
	private Connection connection;//Will be used to create connection with database and its drives
	private ResultSet result;//Will be used when storing, retrieving, updating or deleting data in any table of database
	//Here in this project there are only storing and retrieving queries implemented
	
	
	public void getDBConnect()//method to establish connection with database
	{
		System.out.println("Establishing Connection...");
		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Always import ucanaccess .jar files before doing this or running project
			
			connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\University\\eclipse-workspace\\New\\DatabaseJDBCPrac\\LogIn.accdb");
			//here after jdbc:ucanaccess:// paste your address of database 
			
		}
		catch (ClassNotFoundException | SQLException e) //exception thrown automatically by Class and connection
		{
			e.printStackTrace();
		}
		
		System.out.println("Connection Established...");
		
		
	}
	
	public boolean InsertData(String name, String pass)//Take two parameters from users and store them in database
	{
		getDBConnect();//Establishing every time data is to be inserted into Database
		
		boolean Done = true;
		String p = "insert into Users (UserName,Password) " +"Values ('"+name+"'," + "'"+pass+"')";//only adding name and password the Id will be added automatically

		try 
		{
		statement = connection.createStatement();
		statement.execute(p);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			Done = false;
		} 
		finally
		{
			closeConnection();
		}
		
		if(Done == true)
		{
			System.out.println("The data was added successfully!!!:)");
			return Done;
		}
		else
		{
			System.out.println("The data was not added!!:(");
			return Done;
		}
		
	}
	
 public void getData()
 {
	
	 getDBConnect();
	 String r = " select * from Users";
	 try 
	 {
		statement = connection.createStatement();
		 result= statement.executeQuery(r);		 
		 while(result.next())
		 {
			 int Id = result.getInt(1);
			 String userName = result.getString(2);
			 String password = result.getString(3);
			 System.out.println("ID : "+ Id +" "+" User Name: "+userName+" "+" Password: "+ password);
		 }
	}
	 catch (SQLException e) 
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 finally
	 {
		 closeConnection();
	 }

	
	  
 }
 
 public boolean LogInData(String uName, String Upass)

 {
	 getDBConnect();
	 String p = "select * from Users";
	
	 String userName = "";
	 String password = "";
	 boolean run = true;
	 try 
	 {
		statement = connection.createStatement();
		result = statement.executeQuery(p);
		while(run)
		{
		 while(result.next())
		 {		
			 userName = result.getString(2);
			 password = result.getString(3);
			 
			 if(userName.compareTo(uName)== 0 && password.compareTo(Upass)==0)
			 {
				 
				System.out.println("The Login Successfull");
				break;
				
				
						 
			 }
			 run = false;
			 
				
		 }		
	}
	 }
	 catch (SQLException e)
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 finally
	 {
		 closeConnection();
	 }
	 
	  
	 if(userName.compareTo(uName)== 0 && password.compareTo(Upass)==0)
	 {
		 System.out.println("LogIn Successful!!:)");
		 closeConnection();
	 return true;
	 }
	 else 
	 {
		 System.out.println("LogIn Failed try again!!!:(" );
		 closeConnection();
		 return false;
	 }
	 
	
	
}
 
 
 public void closeConnection()
 {
	 try 
	 {
		connection.close();
	} 
	 catch (SQLException e) 
	 {
		
		e.printStackTrace();
	}
	 
	 System.out.println("Connection Closed...");
 }

}
 
 
 