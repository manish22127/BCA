package Steganography;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.conn;

/**
 * Servlet implementation class selected_Image
 */
@WebServlet("/selected_Image")
public class selected_Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selected_Image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ht=request.getSession();
		String sim=request.getParameter("SIm");
		String hash_Val=(String)ht.getAttribute("hash_Val");
		conn c=new conn();
		byte[] b=c.spl(hash_Val, sim);
		System.out.println("spbyte"+b);
		ht.setAttribute("spbyte", b);
		response.sendRedirect("SpliImage.jsp?sim="+sim);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
