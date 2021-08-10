package Steganography;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ImgeSplit
 */
@WebServlet("/ImgeSplit")
public class ImgeSplit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgeSplit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ht=request.getSession();
		String pname=(String)ht.getAttribute("pname");
		String split=request.getParameter("split");
		ht.setAttribute("splitIm", split);
		String picture=(String)ht.getAttribute("picture");
		String fname=pname+"_stegno.png";
		SplitImage si=new SplitImage();
		String hash_Val=(String)ht.getAttribute("hash_Val");
		HttpSession ses=request.getSession();
		String message=ses.getAttribute("message").toString();
		String sp=si.getSplit(picture, fname, Integer.parseInt(split),hash_Val,message);
	   String page="error.jsp";
	   if(sp.equals("SPLITTED"))
	   {
		   page="ImgeSplit.jsp";
	   }
	   response.sendRedirect(page);
	   
	}
}
