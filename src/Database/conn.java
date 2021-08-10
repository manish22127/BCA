package Database;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import Steganography.Mail;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

	public class conn {
		Connection con;
			Statement st;
		PreparedStatement ps;
		ResultSet rs;
		
		public Connection conn()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root","root");
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		
			return con;
		}
		public int encryption2(String pdffile,String message,String subject,String from,String to,String value,String sss,String priv)
		{
			
			int i=0;
			try
			{
				/*File file=new File(pdf);
				FileInputStream fis=new FileInputStream(file);
				len=(int)file.length();*/
				/*System.out.println("insert into compose values('"+pdffile+"','"+message+"')");*/
				st=conn().createStatement();
				i=st.executeUpdate("insert into compose values('"+pdffile+"','"+message+"','"+subject+"','"+from+"','"+to+"','"+value+"','"+sss+"','"+priv+"')");
				
				/*ps=conn().prepareStatement("insert into compose values(?,?,?,?,?,?,?)");
			ps.setString(1, s);
			ps.setString(2, ss);
			ps.setString(3, sss);
			ps.setString(4, pdffile);
			ps.setString(5, message);
			ps.setString(6, from);
			ps.setString(7, to);
			i=ps.executeUpdate();*/
				//i=st.executeUpdate("insert into compose values Text='"+s+"',keys='"+ss+"',encrypted='"+sss+"'");
				System.out.println("haiiiiiiiiiiiii"+i);
				/*String sql="insert into encryption(Text,keys) values(?,?)";
				ps=conn().prepareStatement(sql);
				ps.setString(1, "s");
				ps.setString(2, "ss");
				ps.setInt(3, len);
				ps.setBinaryStream(4, fis,len);
				ps.executeUpdate();*/
				
				if(i==1)
				{
					
					System.out.println("hellooooo");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return i;
		}
		public int register(String name1, String pass,String cpass, String Date,String mailid,String phoneno,String gender,String add )
		{
			int i=0;
			try
			{
			st=conn().createStatement();
			i=st.executeUpdate("insert into Registration values('"+name1+"','"+pass+"','"+cpass+"','"+Date+"','"+mailid+"','"+phoneno+"','"+gender+"','"+add+"')");
			System.out.println("haiiiiii"+i);
			if(i==1)
			{
				System.out.println("hellooooooooo");
			}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return i;
			
		}
		public int login1(String name1,String pass)
		{
			int i=0;
			try
			{
				
			ps=conn().prepareStatement("select Name,Password from Registration where Name=? and Password=?");
			ps.setString(1, name1);
			ps.setString(2, pass);
		//	ps.setBinaryStream(1,new FileInputStream(new File("d://new.jpg")), 23);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				System.out.print("login successfully");
				i=1;
			}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return i;
		}
		
		public int online(String name1,String time)
		{
			int i=0;
			try
			{
				st=conn().createStatement();
				i=st.executeUpdate("insert into onlineusers values('"+name1+"','"+time+"')");
				System.out.println("inserted");
				if(i==1)
				{
					System.out.println("hellllll");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return i;
		}
		public int logout(String ss)
		{
			int i=0;
			try
			{
				st=conn().createStatement();
				i=st.executeUpdate("delete from onlineusers where users='"+ss+"'");
				System.out.println("deleted"+i);
				/*if(i==1)
				{
					System.out.println("helllooooo");
				}*/
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return i;
		}
		public int textandval(String s, String ss,String hidden,String pass,String sss) {
			int j=0;
			try
			{
		/*		System.out.println("1233333"+img);*/
				ps=conn().prepareStatement("insert into textval1 values(?,?,?,?,?)");
				/*FileInputStream fi = null;
	            fi = new FileInputStream(img);
	         ps.setBinaryStream(6, fi, fi.available());*/
				ps.setString(1, s);
				ps.setString(2, ss);
				ps.setString(3, hidden);
				ps.setString(4, pass);
				ps.setString(5, sss);
				
				/*ps.setString(6, img);*/
			j=ps.executeUpdate();
			System.out.println("inserted successfully"+j);
				
				/*st=conn().createStatement();
				j=st.executeUpdate("insert into textval1 values('"+s+"','"+ss+"','"+hidden+"','"+pass+"','"+sss+"','"+encContent+"')");
				j=1;
				System.out.println("inserted"+j);*/
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return j;
		}
		public int delete(String s[])
		{
			int i=0;
			List li=new ArrayList();
			try
			{
				for(i=0;i<s.length;i++)
			       {
			       /* String nnn="D:\\eclipse [JUNO]\\palraj\\sample2\\WebContent\\PDF\\"+s[i];   */
					String nnn=s[i];
					System.out.println("this is delete path"+nnn);
					//System.out.println("<li>"+li.add(s[i])+"</li>"+nnn);
			        st=conn().createStatement();
			        ResultSet rs=st.executeQuery("select * from sendmail where pdfpath='"+nnn+"'");
			        if(rs.next())
			        {
			        	i=st.executeUpdate("delete from sendmail where pdfpath='"+nnn+"'");
			        	i=1;
			        }
					/*ps=conn().prepareStatement("select * from compose where files=?");
					ps.setString(4, nnn);	 */  
			       }
				
			
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return i;
			
		}
		public int decrypt(String decrypt, String dkey, String sss) {
			int j=0;
			try
			{
				st=conn().createStatement();
		
				/*rs=st.executeQuery("select * from textval1 where value='"+dkey+"'");*/
				
					
				
					j=st.executeUpdate("insert into decryption values('"+decrypt+"','"+dkey+"','"+sss+"')");				
					j=1;
				System.out.println("jhshdkhsdkjhds"+j);
				
						
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return j;
		}
		public int checking(String keyvalue, String name, String pass,String encrypted) {
			int i=0;
			try
			{
				st=conn().createStatement();
				rs=st.executeQuery("select * from textval1 where value='"+keyvalue+"' and from1='"+name+"'and Pass='"+pass+"' and encrypted='"+encrypted+"'");
				while(rs.next())
				{
					
				System.out.print("innnnnnnlooooop");
				
				i=1;
							
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			return i;
		}
		
		public ArrayList getImage()
		{
			ArrayList al=new ArrayList();
			try {
				st=conn().createStatement();
				rs=st.executeQuery("select * from textval1");
				while(rs.next())
				{
					al.add(rs.getString(1));
					al.add(rs.getString(2));
					al.add(rs.getString(3));
					al.add(rs.getString(4));
					al.add(rs.getString(5));
					al.add(rs.getBytes(6));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return al;
		}
		
		public TreeMap getImag(String hash)
		{
			TreeMap al=new TreeMap();
			try {
				ps=conn().prepareStatement("select * from HashImage where hash='"+hash+"'");
		     	ResultSet rs1=ps.executeQuery();
		     	while(rs1.next())
		       	{
		     		System.out.println("In db loop/....");
		       		byte[] b1=rs1.getBytes(2);
		       		int n=rs1.getInt(3);
		       		al.put(n, b1);
		     	}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return al;
		}
		
		public byte[] spl(String hash,String im)
		{
			int num=Integer.parseInt(im);
			byte[] b=null;
			try {
				ps=conn().prepareStatement("select * from HashImage where hash='"+hash+"'");
		     	ResultSet rs1=ps.executeQuery();
		     	int i=1;
		       	while(rs1.next())
		       	{
		       		if(i==num)
		       		{
		       			byte[] b1=rs1.getBytes(2);
		       			b=b1;
		       		}
		     		 i++;
		     	}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return b;
		}
		
		public String rec(String name)
		{
			String email=null;
			try {
				Statement stm=conn().createStatement();
				ResultSet rs=stm.executeQuery("select * from Registration where Name='"+name+"'");
				if(rs.next())
				{
					email=rs.getString("Mailid").trim();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return email;
		}
		
		public int splitRec(String sim,String rec,String sub,String hash,String sen)
		{
			
			//new Mail(rec,hash);
			try {
				byte[] b=spl(hash, sim);
				File f=new File("E:\\te12st.jpg");
				FileOutputStream fos=new FileOutputStream(f);
				fos.write(b);
				fos.close();
				FileInputStream fi=new FileInputStream(f);
		     	PreparedStatement ps=conn().prepareStatement("insert into composeImage values(?,?,?,?)");
		     	ps.setString(1, rec);
		     	ps.setBinaryStream(2, fi, fi.available());	
		     	ps.setString(3, sen);
		     	ps.setString(4, sub);
		     	int i=ps.executeUpdate();
		     	return i;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return 0;
		}
		
		public int splitIm(String hash,String path,int k)
		{
			int i=0;
			try {
				File f=new File(path);
		     	FileInputStream fi=new FileInputStream(f);
		     	PreparedStatement ps=conn().prepareStatement("insert into HashImage values(?,?,?)");
		     	ps.setBinaryStream(2, fi, fi.available());	
		     	ps.setString(1, hash);
		     	ps.setInt(3, k);
		        i=ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return i;
		}
		
		public byte[] innerStegano(String path,String pname)
		{
			 byte[] b=null;
			try {
				
				 File f=new File(path);
			     	FileInputStream fi=new FileInputStream(f);
			     	PreparedStatement ps=conn().prepareStatement("insert into P_Image values(?,?) ");
			     	ps.setBinaryStream(1, fi, fi.available());	
			     	ps.setString(2, pname);
			     	ps.executeUpdate();
			     	ps=conn().prepareStatement("select * from P_Image where username='"+pname+"'");
			     	ResultSet rs1=ps.executeQuery();
			       	while(rs1.next())
			       	{
			     		byte[] b1=rs1.getBytes(1);
			     		b=b1;
			     		 String nb=rs1.getString(2).trim();
			     		 if(nb.equalsIgnoreCase(pname))
			     		 {
			       		 System.out.println("bytes"+b);
			     		 b=b1;
			     		 }
			     	}
			       	ps=conn().prepareStatement("delete P_Image where username=?");
			       	ps.setString(1, pname);
			       	ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return b;
			
		}
		
		public byte[] insertImage(String pic, String user, String name) {
			// TODO Auto-generated method stub
			 byte[] b=null;
	     	try
	     	{
	     		System.out.println("imgassssssss:::::"+pic);
	     	File f=new File(pic);
	     	FileInputStream fi=new FileInputStream(f);
	     	PreparedStatement ps=conn().prepareStatement("insert into img values(?,?,?) ");
	     	ps.setBinaryStream(1, fi, fi.available());
	     	ps.setString(2, user);
	     	ps.setString(3, name);;
	     	ps.executeUpdate();
	     	ps=con.prepareStatement("select * from img where username='"+user+"'");
	     	ResultSet rs1=ps.executeQuery();
	       	while(rs1.next())
	       	{
	     		byte[] b1=rs1.getBytes(1);
	     		 String nb=rs1.getString(3).trim();
	     		 if(nb.equalsIgnoreCase(name))
	     		 {
	       		 System.out.println("bytes"+b);
	     		 b=b1;
	     		 }
	     	}
	     	
	     	}

	     	catch(Exception e)
	     	{
	     		e.printStackTrace();
	     	}
	     	
	     
			return b;
	     	
		}
		
		public byte[] insertImage1(String pic) {
			// TODO Auto-generated method stub
			 byte[] b=null;
	     	try
	     	{
	     	File f=new File(pic);
	     	FileInputStream fi=new FileInputStream(f);
	     	PreparedStatement ps=conn().prepareStatement("insert into img values(?) ");
	     	ps.setBinaryStream(1, fi, fi.available());
	     	ps.executeUpdate();
	     	ps=con.prepareStatement("select *from original");
	     	 rs=ps.executeQuery();
	     	
	     	if( rs.next()){
	     		 b=rs.getBytes(1);
	     		 System.out.println("bytes"+b);
	     		
	     		 System.out.println("bytes"+b);
	     	}
	     	}
	     	catch(Exception e)
	     	{
	     		e.printStackTrace();
	     	}
	     	try
	     	{
	     		ps=con.prepareStatement("delete from original");
	        	ps.executeUpdate();
	     	}
	     	catch(Exception e)
	     	{
	     		e.printStackTrace();
	     	}
	     
			return b;
	     	
		}
		
		
		public int mailsend(String fromname, String password1, String toname,
				String choosing, String message) {
			int i=0;
			try
			{
				st=conn().createStatement();
				i=st.executeUpdate("insert into mailsend values('"+fromname+"','"+password1+"','"+toname+"','"+choosing+"','"+message+"')");
				i=1;
				System.out.println("sent mail 1");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return i;
		}
		public String updatefile(String name, String user,String enc) {
			// TODO Auto-generated method stub
			String code=null;
			int i=0;
			try
			{
				System.out.println("db jdhfjkdaskf"+name+"\t"+user+"\t"+enc);
				//PreparedStatement pst=con.prepareStatement("select * from compose ");
				st=conn().createStatement();
				rs=st.executeQuery("select * from compose where from1='"+user+"' and encryption1='"+enc+"' ");
				if(rs.next())
				{
					System.out.println("okkkk dbbbb");
					String fname=rs.getString(1).toString().trim();
					String username=rs.getString(3).toString().trim();
					String encrypt=rs.getString(7).toString().trim();
					System.out.println("db encryyy::"+encrypt+"\t"+enc);
					if(encrypt.equals(enc))
					{
						//st=con.prepareStatement();
						i=st.executeUpdate("update compose set files='"+name+"' where encryption1='"+enc+"'");
						code=enc;
					}
				}
					
			}
			catch(Exception e)
			{
				
			}
			return code;
		}
		public byte[] EmbedImage(String fpath, String user, String name) 
		{
			byte[] b=null;
	     	try
	     	{
	     		System.out.println("imgassssssss:::::"+fpath+user+name);
	     	File f=new File(fpath);
	     	FileInputStream fi=new FileInputStream(f);
	     	PreparedStatement ps=conn().prepareStatement("insert into Embed values(?,?,?) ");
	     	ps.setBinaryStream(1, fi, fi.available());
	     	ps.setString(2, user);
	     	ps.setString(3, name);
	     	ps.executeUpdate();
	     	ps=con.prepareStatement("select * from Embed where username='"+user+"'");
	     	rs=ps.executeQuery();
	       	while(rs.next())
	       	{
	     		byte[] b1=rs.getBytes(1);
	     		 String s=rs.getString(3).trim();
	     		 if(s.equals(name))
	     		 {
	       		 System.out.println("bytes"+b1);
	     		 System.out.println("bytes"+b);
	     		 b=b1;
	     		 }
	     	}
	     	}
		catch (Exception e) 
		{
		e.printStackTrace();
		}
	     	return b;
		}
		public int insertinbox(String fpath, String message, String from, String to) {
			// TODO Auto-generated method stub
			int i=0;
			try
			{
				st=conn().createStatement();
				i=st.executeUpdate("insert into inbox values('"+fpath+"','"+message+"','"+from+"','"+to+"')");
				
				
			}
			catch(Exception e)
			{
				
			}
			return i;
		}
		public int sendmail(String from, String to,String pdfsend, String subject,String message ) {
			// TODO Auto-generated method stub
			int i=0;
			try
			{
				st=conn().createStatement();
				i=st.executeUpdate("insert into sendmail values('"+from+"','"+to+"','"+pdfsend+"','"+subject+"','"+message+"')");
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return i;
		}
		public ArrayList keycheck(String keys) {
			// TODO Auto-generated method stub
			int i=0;
			String pri=null;
			ArrayList al=new ArrayList();
			try
			{
				st=conn().createStatement();
				rs=st.executeQuery("select * from compose where priv='"+keys+"'");
				if(rs.next())
				{
					System.out.println("key values");
					pri=rs.getString(2).trim();
					i=1;
					al.add(i);
					al.add(pri);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return al;
		}
	}


