package imagecreator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.conn;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class EncryptImage
 */
@WebServlet("/EncryptImage")
public class EncryptImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String saveFile="";
	   String text=null;
	   String Path="";
	   String dept="";
	   String filepath="";
	   File f=null;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncryptImage() {
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
		 byte[] imgByte = null;
		 int j=0;
		try
		{
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        int insert=0;
	        try {

	            /****************/
	            FilePart filePart = null;
	           
	            MultipartParser mp = new MultipartParser(request, 99999999);
	            Part part;
	            HashMap<String, String> params = new HashMap<String, String>();
	            String fileName = null;

	            String uploadDir = getServletContext().getRealPath("");
	            System.out.println("upload doccc  ::"+uploadDir);
	            HttpSession session=request.getSession();
	            while ((part = mp.readNextPart()) != null)
	            {
	            	//System.out.println("Inside loop1");
	                  String name = part.getName();
	                  
                	  String ss=(String)session.getAttribute("pname");

	                  // If the part is parameter ... put the parameter in a hashmap with the key as the name of the request
//	                  if (part.isParam())
//	                  {
//	                	 System.out.println("inside param");
//	                        // it's a parameter part
//	                        ParamPart paramPart = (ParamPart) part;
//	                        String value = paramPart.getStringValue();
//	                        params.put(name, value);
//	                       
//	                        FileInputStream  file = new FileInputStream(Path);
//	       		      FileOutputStream   output = new FileOutputStream(Path+ss+".jpg");
//	       		      
//	       		     
//	       		        //Sparse encode
//	       		        byte k[]="sparseencodetech".getBytes();
//	       		        SecretKeySpec kye = new SecretKeySpec(k,"AES");
//	       		        System.out.println(kye);
//	       		        Cipher enc = Cipher.getInstance("AES");
//	       		        enc.init(Cipher.ENCRYPT_MODE,kye);
//	       		        CipherOutputStream cos = new CipherOutputStream(output, enc);
//	       		        byte[] buf = new byte[1024];
//	       		        int read;
//	       		        while((read=file.read(buf))!=-1){
//	       		            cos.write(buf,0,read);
//	       		        }
//	       		        file.close();
//	       		        output.flush();
//	       		        cos.close();
//	                  }
	                   if (part.isFile())
	                  { // case where the part of the request is a file it's a file part
	                	  System.out.println("image or file");
	                        filePart = (FilePart) part;
	                       
	                        fileName =ss+"_"+filePart.getFileName();
	                        System.out.println(uploadDir +"\t"+fileName+"\t"+filePart.getContentType()+"\t"+filePart.getName());
	                         Path=uploadDir +"\\"+fileName;
	                         f = new File(uploadDir+"\\",fileName);
	                        System.out.println("f is ~~~ "+f);
	                        filepath=f.toString();
	                        System.out.println(",,,,,,,,,,,,,, "+filepath);
	                        double fileSize = filePart.writeTo(f);
	                  }	                  
	                  System.out.println("Uploaded successfully !");
	                  conn db= new conn();
	          	    imgByte=db.insertImage(Path,ss,filePart.getFileName());
	          	  ServletContext context=getServletContext();
	      	  //  context.setAttribute("code",code);
	      	    context.setAttribute("img", imgByte);
	      	    context.setAttribute("path", filePart.getFileName());
	      	    context.setAttribute("Pic_Path", Path);
	      	  context.setAttribute("Pic_upload", uploadDir);
	      	context.setAttribute("fileName", fileName);
	      	  
	      	  request.getRequestDispatcher("Display.jsp").forward(request, response);
	           }
	        }catch (Exception e) {
				// TODO: handle exception
	        	e.printStackTrace();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
