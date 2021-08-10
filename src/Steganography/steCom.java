package Steganography;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class steCom
 */
@WebServlet("/steCom")
public class steCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public steCom() {
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
		byte[] b=null;
		File f=null;
		String uploadDir = getServletContext().getRealPath("");
		
		TreeMap hasImg=(TreeMap)ht.getAttribute("hasImg");
		String picture=uploadDir;
		String pname=(String)ht.getAttribute("fro");
		String fname=pname+"_stegno.png";
		String path="E:\\UImage\\test";
		String fpath=picture+"\\"+pname+"_stegno.png";
		ht.setAttribute("hiddMes", fpath);
		System.out.println(picture+"\\"+pname+"_stegno.png");
		int i=hasImg.size();
		for(int k=0;k<i;k++)
		{
			b=(byte[])hasImg.get(k);
			f=new File(path+k+".jpg");
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(b);
			fos.close();
		}
		SplitImage ste=new SplitImage();
		byte[] boo= ste.combineImages(path,path+"\\"+"ste.png", i);
		ht.setAttribute("boo", boo);
		String page="error.jsp";
		if(boo!=null)
		{
			String hashvalu=SHA_256.hash(fpath);
			ht.setAttribute("verfy", hashvalu);
			page="steCom.jsp";
		}
		response.sendRedirect(page);
	}
}