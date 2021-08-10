package Steganography;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imgDisplay
 */
@WebServlet("/imgDisplay")
public class imgDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imgDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param=request.getParameter("param");
		System.out.println("param = "+param);
		if(param!=null){
if(param.equals("display.jsp")){
			response.getOutputStream().write((byte[])getServletContext().getAttribute("img"));
		response.getOutputStream().close();
		}else if (param.equals("steCom.jsp")) {
			response.getOutputStream().write((byte[])request.getSession().getAttribute("boo"));
			response.getOutputStream().close();
		}
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
