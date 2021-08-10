package down;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class download
 */
@WebServlet("/download")
public class download extends HttpServlet {
	 private static final int BUFSIZE = 4096;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");
        String f_name=request.getParameter("fname");
       // System.out.println("ssssss"+" "+f_name);
        String path="D:/eclipse [JUNO]/palraj/sample2/WebContent/PDF/"+f_name;
       
        try
         {
               System.out.println("pathhhhhhhhhhhhhh "+path);
               File file = new File(path);
               String F_name=file.getName();
               System.out.println("File Path "+file+"File name os "+F_name);
               int length = 0;
               ServletOutputStream outStream =  response.getOutputStream();
               ServletContext context = getServletConfig().getServletContext();
               String mimetype = context.getMimeType(path);

               if(mimetype == null)
                {
                 mimetype = "application/octet-stream";
                }
                response.setContentType(mimetype);
                response.setContentLength((int)file.length());

                response.setHeader("Content-Disposition", "attachement; filename=\"" + F_name + "\"");
                byte[] byteBuffer = new byte[BUFSIZE];

                DataInputStream dis =   new DataInputStream(new FileInputStream(file));

                while((dis != null) && ((length = dis.read(byteBuffer)) != -1 ))
                {
                outStream.write(byteBuffer, 0, length);
                }
                dis.close();
                outStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                finally {
            //out.close();
        }

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
