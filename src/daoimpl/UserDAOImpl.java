package daoimpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import model.User;

public class UserDAOImpl implements UserDAO 
{
	@Override
	public boolean addUser(User u)
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=junit","sa","faculty@123");
			PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;	
		}
		
	}

	@Override
	public boolean deleteUser(String username) 
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=junit","sa","faculty@123");
			PreparedStatement ps=con.prepareStatement("delete from users where username=?");
			ps.setString(1, username);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public boolean updateUser(User u) 
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=junit","sa","faculty@123");
			PreparedStatement ps=con.prepareStatement("update users set email=?,password=? where username=?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getUsername());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public User displayUserByName(String username) 
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=junit","sa","faculty@123");PreparedStatement ps=con.prepareStatement("select * from users where username=?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			User u=new User();
			if(rs.next())
			{
				u.setUsername(rs.getString("username"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}
			return u;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<User> displayAllUsers() 
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=junit","sa","faculty@123");Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from users");
			
			List<User> users=new ArrayList<User>();
			while(rs.next())
			{
				User u=new User();
				u.setUsername(rs.getString("username"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				
				users.add(u);
			}
			return users;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
		
	}
}
