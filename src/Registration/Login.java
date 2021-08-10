package Registration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.conn;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name1="";
	int j=0;
	String time ;
	conn c1=new conn();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0;
		try
		{
		time = new SimpleDateFormat("h:mm a").format(new Date());
		name1=request.getParameter("user");
		String pass=request.getParameter("pass");
		HttpSession hs=request.getSession();
		hs.setAttribute("pname", name1);
		conn c1=new conn();
		i=c1.login1(name1,pass);
		
		hs.setAttribute("pass", pass);
		getServletConfig().getServletContext().setAttribute("nanam", name1);
		hs.setAttribute("nnname", name1);
			System.out.println("Name   "+getServletConfig().getServletContext().getAttribute("nanam"));
		
		System.out.println(i);
		System.out.println(j);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(i==1)
		{
			j=c1.online(name1,time);
			
			

			response.sendRedirect("Inbox.jsp");
		}
		else
		{
			response.sendRedirect("error.html");
		}
	}

}
