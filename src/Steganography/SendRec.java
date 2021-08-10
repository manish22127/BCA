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
 * Servlet implementation class SendRec
 */
@WebServlet("/SendRec")
public class SendRec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRec() {
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
		HttpSession ht=request.getSession();
		String hash_Val=(String)ht.getAttribute("hash_Val");
		String send=(String)ht.getAttribute("pname");
		String sim=request.getParameter("sim");
		String rec=request.getParameter("receiver");
		String sub=request.getParameter("sub");
		System.out.println(hash_Val);
		conn co=new conn();
		int i=co.splitRec(sim, rec, sub, hash_Val, send);
		String page="error.jsp";
		if(i==1)
		{
			String email=co.rec(rec);
			String sp=(String)ht.getAttribute("splitIm");
			Mail mail=new Mail(email, hash_Val);
//			boolean b=EmailSend.emailSend(email, hash_Val, sp);
//			if(b)
//			{
				page="success.jsp";
//			}
		}
		response.sendRedirect(page);
	}

}
