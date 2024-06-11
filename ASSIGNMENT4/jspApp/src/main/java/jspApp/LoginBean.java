package jspApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class LoginBean {
	private String email;
	private String password;
	private User user;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void authenticate()
	{
		String DB_URL = "jdbc:mysql://localhost:3306/electiondb";
		String DB_USER = "root";
		String DB_PASS = "manager";
		try(Connection con =  DriverManager.getConnection(DB_URL))
		{
			String sql = "select * from users where email = ? AND password = ?";
			try(PreparedStatement pstmt = con.prepareStatement(sql))
			{
				pstmt.setString(1,this.email);
				pstmt.setString(2,this.password);
				try(ResultSet rs = pstmt.executeQuery())
				{
					if(rs.next())
					{
						int id = rs.getInt("id");
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						email = rs.getString("email");
						String password = rs.getString("password");
						Date dob = rs.getDate("dob");
						int status = rs.getInt("status");
						String role = rs.getString("role");
						this.user = new User(id, firstName, lastName, email, password, dob, status, role);	
					}
					else {
						this.user=null;
					}
					int id = rs.getInt("id");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
