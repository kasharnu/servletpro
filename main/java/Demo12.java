

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Demo12")
public class Demo12 extends HttpServlet {
	
public void doPost(HttpServletRequest req,HttpServletResponse res)
{
	String str=req.getParameter("t1");
	int num=Integer.parseInt(str);
	try {
	PrintWriter pw=res.getWriter();
	if(num%2==0)
	{
		pw.println("given number is even");
	}
	else {
		pw.print("not even number");
	}
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
