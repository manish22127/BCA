package imagecreator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	   String saveFile="";
	   String text=null;
	   String Path="";
	   String dept="";
	   String filepath="";
	   File f=null;
    public upload() {
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
		
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        int insert=0;
	        try {

	            /****************/
	            FilePart filePart = null;
	            int maxFileSize = 100 * 1024 * 1024; // 100 MB;
	            MultipartParser mp = new MultipartParser(request, 99999999);
	            Part part;
	            HashMap<String, String> params = new HashMap<String, String>();
	            String fileName = null;

	            String uploadDir = getServletContext().getRealPath("");
	            System.out.println("upload doccc  ::"+uploadDir);

	            while ((part = mp.readNextPart()) != null)
	            {
	                  String name = part.getName();

	                  // If the part is parameter ... put the parameter in a hashmap with the key as the name of the request
	                  if (part.isParam())
	                  {
	                        // it's a parameter part
	                        ParamPart paramPart = (ParamPart) part;
	                        String value = paramPart.getStringValue();
	                        params.put(name, value);
	                        System.out.println("param list  >>"+params);
	                  }
	                  else if (part.isFile())
	                  { // case where the part of the reequest is a file it's a file part
	                        filePart = (FilePart) part;
	                        fileName = filePart.getFileName();
	                        System.out.println(uploadDir +"\\Files\\"+filePart.getFileName());
	                         Path=uploadDir +""+filePart.getFileName();
	                         f = new File(uploadDir+"",filePart.getFileName());
	                        System.out.println("f is ~~~ "+f);
	                        filepath=f.toString();
	                        System.out.println(",,,,,,,,,,,,,, "+filepath);
	                        double fileSize = filePart.writeTo(f);
	                  }
	                  Set s=(Set)params.entrySet();
	                  System.out.println("parames "+params);
	                  System.out.println("Value is ::"+params.values());
	                  Iterator ii=s.iterator();
	                  while(ii.hasNext())
	                  {
	                      Map.Entry m=(Map.Entry)ii.next();
	                       dept=m.getValue().toString();
	                      System.out.println("Valuuuuuuuuuuu "+dept);
	                  }
	                  System.out.println("Uploaded successfully !");
	           }
	                Date d=new Date();
	                String date=d.toString();
	                HttpSession hs=request.getSession();
	                String sendername=(String)hs.getAttribute("LoginUser");

	                System.out.println("List to DB values ::"+f.getName()+" :: "+filepath+" :: "+date+">>>>>>>"+sendername+"<<<<<<<"+dept);
	                
	                System.out.println("insert upload list is >>>>>>>>>>>>> "+insert);
	        }
	            catch(Exception e)
	            {
	            e.printStackTrace();
	           }
	        if(insert==1)
	        {
	           RequestDispatcher rs=request.getRequestDispatcher("Display.jsp");
	           rs.forward(request, response);
	        }
	 else{
	            RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
	            rd.forward(request, response);
	 }
	}

}
