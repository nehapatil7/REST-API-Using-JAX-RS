package restapi.crud.REST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

	Connection con;
	
	public StudentRepository()
	{
		String url = "jdbc:mysql://localhost:3306/db";
		String username = "root";
		String password = "create@00"; 
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");	
	    con = DriverManager.getConnection(url,username,password);
	    System.out.println("connected database");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Rest> getstudent() {
			List<Rest> student=new ArrayList<>();
			String sql="select * from Rest";
			try
			{
				PreparedStatement st=con.prepareStatement(sql);
				ResultSet rs=st.executeQuery(sql);
				while(rs.next())
				{
					
					Rest s=new Rest();
					s.setSname(rs.getString(1));
					s.setSid(rs.getInt(2));
					student.add(s);
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return student;
		}

	
	public Rest getRest(int Sid) {
		String sql="select * from Rest where Sid="+Sid;
		Rest s=new Rest();
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				
				
				s.setSname(rs.getString(1));
				s.setSid(rs.getInt(2));
			
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
		
	}



	public void create(Rest s1) {
		String sql = "insert into Rest values(?,?) ";
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,s1.getSname());
			st.setInt(2,s1.getSid());

			st.executeUpdate();
			
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void update(Rest s1) {
		String sql = "update Rest set Sname=? where Sid=?";
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1,s1.getSname());
			st.setInt(2,s1.getSid());
			st.executeUpdate();
			
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void delete(int Sid) {
		String sql = "delete from Rest where Sid=?";
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setInt(1,Sid);
			st.executeUpdate();
			System.out.println("Deleted sucessfully");
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
