package Steganography;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.conn;

/**
 * Servlet implementation class ImageStegano
 */
@WebServlet("/ImageStegano")
public class ImageStegano extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageStegano() {
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
		String mess=request.getParameter("message");
		System.out.println("message is"+" "+mess);
		ServletContext context=getServletContext();	
		String fname=(String)context.getAttribute("Pic_Path");
		System.out.println("fname is"+" "+fname);
		String Pic_upload=(String)context.getAttribute("Pic_upload");
		System.out.println("Pic_upload is"+" "+Pic_upload);
		HttpSession session=request.getSession();
		String pname=(String)session.getAttribute("pname");
		String fileName=(String)context.getAttribute("fileName");
		System.out.println("fileName is"+" "+fileName);
		Steganography ste=new Steganography();
		boolean b=ste.encode(Pic_upload, fileName, pname+"_stegno", mess);
		String page="error.jsp";
		if(b)
		{
			String picture=Pic_upload+"\\"+pname+"_stegno.png";
			String hashcode=SHA_256.hash(picture);
			conn con=new conn();
			byte[] byt=con.innerStegano(picture, pname);					
			session.setAttribute("byte", byt);
			session.setAttribute("hash_Val", hashcode);
			session.setAttribute("picture", Pic_upload);
			session.setAttribute("message", mess);
			page="Steshow.jsp";
		}
		response.sendRedirect(page);
	}

}
