package Registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.conn;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String name1=request.getParameter("Name");
		String pass=request.getParameter("pwd");
		String cpass=request.getParameter("cpwd");
		String mailid=request.getParameter("email");
		String phoneno=request.getParameter("phone");
		String gender=request.getParameter("m1");
		String add=request.getParameter("Address");
		String day=request.getParameter("Day");
		String month=request.getParameter("mm");
		String year=request.getParameter("yr");
		String Date=day +"/"+ month+"/" +year;
		
		
		conn c=new conn();
		i=c.register(name1,pass,cpass,Date,mailid,phoneno,gender,add);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(i==1)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Userinterface.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
