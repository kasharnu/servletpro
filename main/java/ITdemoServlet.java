

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ITdemoServlet")
public class ITdemoServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res )
	{
		try {
			String a=req.getParameter("f1");
			int a1= Integer.parseInt(a);
			//String b=req.getParameter("f2");
			String c=req.getParameter("f3");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahendra","root","Root88");
			String q="insert into ipl values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, a1);
			ps.setString(2,req.getParameter("f2"));
			ps.setString(3,c);
			ps.execute();
			PrintWriter pw=res.getWriter();
			res.sendRedirect("/DemoItproject/success.html");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
