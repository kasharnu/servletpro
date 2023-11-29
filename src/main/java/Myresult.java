import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myresult extends HttpServlet
{
	String str="select* from results where name=? and pass=?;";
	PreparedStatement ps=null;
	ResultSet rs=null;
	PrintWriter pw=null;
	Connection con=null;
	public void init()
	{
		try{
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","Root88");	
		}
		catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
	public void service(HttpServletRequest req, HttpServletResponse res)
	{	
			try {
				String strname=req.getParameter("name");
				String strpsd=req.getParameter("pasw");
				pw=res.getWriter();
				try {
					ps=con.prepareStatement(str);
					ps.setString(1, strname);
					ps.setString(2, strpsd);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rs=ps.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		
		try {
			
			while(rs.next())
			{
				String fname=rs.getString("name");
				int m1=rs.getInt("mark1");
				int  m2=rs.getInt("mark2");
				int m3=rs.getInt("mark3");
				String pa=rs.getString("pass");
				pw.println("F_name "+fname+" "+"L_name "+m1+" mark2 "+m2+" "+"mark3"+m3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy()
	{
		
	}
}

