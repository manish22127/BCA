package Steganography;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class match
 */
@WebServlet("/match")
public class match extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public match() {
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
		HttpSession session=request.getSession();
		String mat=request.getParameter("mat");
		
		System.out.println("Hash value:"+mat);
	    String hash_Val=(String)session.getAttribute("verfy");
	    String page="error.jsp";
	    
	    System.out.println("Hash :"+hash_Val);
	    if(mat.equalsIgnoreCase(hash_Val))
	    {
	    	System.out.println("SUCCESS");
	    	page="successMatch.jsp";
	    }
	    response.sendRedirect(page);
	}

}
