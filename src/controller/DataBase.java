package controller;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.*;

	public class DataBase {

	Connection con = null;
	public DataBase(){
		try{
			String url, user, password;

			Class dbDriver = Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/connect_ong/?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "MYSQL");
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (Exception e){}
			}
		}

	}
}
	

